package hwst.service.orders;

import hwst.dao.cart.CartDao;
import hwst.dao.orders.OrderProductDao;
import hwst.dao.orders.OrdersDao;
import hwst.dao.orders.PaymentDao;
import hwst.dao.product.ProductOptionDao;
import hwst.domain.orders.OrderProductVo;
import hwst.domain.orders.OrdersVo;
import hwst.domain.orders.PaymentVo;
import hwst.domain.product.ProductOptionVo;
import hwst.domain.users.UsersVo;

import java.util.List;

import javax.annotation.Resource;

import org.springframework.stereotype.Service;

@Service("ordersService")
public class OrdersServiceImpl implements OrdersService {

	@Resource(name="ordersDao")
	private OrdersDao ordersDao;
	
	@Resource(name="orderProductDao")
	private OrderProductDao orderProductDao;
	
	@Resource(name="productOptionDao")
	private ProductOptionDao productOptionDao;
	
	@Resource(name="paymentDao")
	private PaymentDao paymentDao;
	
	@Resource(name="cartDao")
	private CartDao cartDao;
	
	
	//주문정보 Insert
	@Override
	public boolean insertOrders(OrdersVo ordersVo, List<Integer> productOptionNo, List<Integer> buyAmount,
			List<Integer> totalPrice, int checkoutInfo,String fromCart) throws Exception{
		int stat2 = 0;
		int stat3 = 0;
		int stat4 = 0;
		
		
		int stat = ordersDao.insertOrders(ordersVo);
		if(stat==1){
			int orderNo= ordersDao.selectOrderNoByUserNo(ordersVo.getUserNo());
			
			for(int i=0; i<productOptionNo.size(); i++){
				OrderProductVo opVo = new OrderProductVo(orderNo, productOptionNo.get(i), buyAmount.get(i), totalPrice.get(i), ordersVo.getUserNo());
				stat2 += orderProductDao.insertOrderProduct(opVo);
			}
			if(stat2==productOptionNo.size()){
				stat3 = paymentDao.insertPayment(new PaymentVo(orderNo, checkoutInfo));
			}
			if(stat3==1 && fromCart=="yes"){
				for(int i=0; i<productOptionNo.size(); i++){
					ProductOptionVo productOptionVo = new ProductOptionVo(productOptionNo.get(i),ordersVo.getUserNo());
					stat4 = cartDao.deleteCartByOrderComplete(productOptionVo);
				}
					
			}
			
		}
		
		if(stat4>0){
			return true;
		}
		return false;
	}
	
	//주문정보 불러오기
	@Override
	public List<OrdersVo> selectOrdersAll(UsersVo usersVo)throws Exception{
		List<OrdersVo> ordersVo = null;
		List<OrdersVo> orderNoCount = null;		
		
		if(usersVo.getUserSection()==1){
			ordersVo = ordersDao.selectOrdersAll(usersVo.getUserNo());
			orderNoCount = ordersDao.selectOrderNoGroupCount(usersVo.getUserNo());
		}
		else if(usersVo.getUserSection()==2){
			ordersVo = ordersDao.selectSellerOrdersAll(usersVo.getUserNo());
			orderNoCount = ordersDao.selectSellerGroupCount(usersVo.getUserNo());
		}
		
		for(int i=0; i<ordersVo.size(); i++){		//ordersVo를 OrderNo 별로 group한 orderNoCount를 가지고 각 group의 개수를 해당 group의 첫번째 데이터의 orderNoCount속성에 set한다
			for(int j=0; j<orderNoCount.size(); j++){
				if(ordersVo.get(i).getOrderNo()==orderNoCount.get(j).getOrderNo()){ //주문번호가 같을때 해당 주문번호 group에 해당하는 개수를 set해준다
					ordersVo.get(i).setOrderNoCount(orderNoCount.get(j).getOrderNoCount());
					int stat=0;
					for(int k=i; k<i+orderNoCount.get(j).getOrderNoCount(); k++){	//이 때 group에 속하는 각 주문상품들의 재고수량과 구매수량을 체크하여 구매수량이 더 많을경우 QuantityCheck에 값'1'을 set한다. 후에 값'1'이 존재할 경우 '재고부족'으로 화면에 표시된다.
						if(ordersVo.get(k).getBuyAmount()>ordersVo.get(k).getProductAmount()){
							ordersVo.get(i).setQuantityCheck(1);
						}
						if(ordersVo.get(i).getOrderStat()==4){//주문상태가 배송중이고 배송상태는 배송완료일때 주문상태를 전체배송완료로 바꿔주기 위한 로직
							if(ordersVo.get(k).getDeliveryStat()==3){
								stat += 1;
							}
							if(stat==orderNoCount.get(j).getOrderNoCount()){
								updateOrderStat(ordersVo.get(i).getOrderNo(),5);
								selectOrdersAll(usersVo);
							}
						}
					}
					i += orderNoCount.get(j).getOrderNoCount();
				}
			}
		}
		return ordersVo;
	}
	
	//해당주문의 orderStat 변경
	@Override
	public boolean updateOrderStat(int orderNo, int orderStat)throws Exception{
		int stat = 0;
		int stat2 = 0;
		List<OrdersVo> vo = null;
		
		if(orderStat==2){
			vo = ordersDao.selectByPrdOpNo(orderNo);
			for(int i=0; i<vo.size(); i++){
				int updateAmount = vo.get(i).getProductAmount()-vo.get(i).getBuyAmount();
				stat += productOptionDao.udtPrdAmount(new ProductOptionVo(vo.get(i).getProductOptionNo(),updateAmount));
			}
			
			if(stat>0){
				 stat2 = ordersDao.updateOrderStat(new OrdersVo(orderNo, orderStat));
			}
		}
		else{
			stat2 = ordersDao.updateOrderStat(new OrdersVo(orderNo, orderStat));
		}
		
		if(stat2==1){
			return true;
		}
		return false;
	}
	
	//해당주문의 각 상품의 deliveryStat 변경
		@Override
		public boolean udtDeliveryStat(int orderNo, int productOptionNo, int deliveryStat)throws Exception{
			int stat = 0;
			
			if(deliveryStat==2){
				ordersDao.updateOrderStat(new OrdersVo(orderNo, 4));
			}
			stat=orderProductDao.udtDeliveryStat(new OrderProductVo(orderNo, productOptionNo, deliveryStat));
			
			if(stat==1){
				return true;
			}
			return false;
		}
	
	//해당주문 삭제
	@Override
	public boolean deleteOrder(int orderNo)throws Exception{
		int stat = 0;
		int stat1 = 0;
		
		stat = ordersDao.deleteOrder(orderNo);
		if(stat==1){
			stat1 = orderProductDao.deleteOrderProduct(orderNo);
		}
		
		if(stat1>0){
			return true;
		}
		return false;
	}
}
