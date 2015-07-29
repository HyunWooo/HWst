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
	
	
	/* DB에 하나의 주문에 존재하는 상품개수를 못넣는이유
	 * 1. 해당 칼럼 전체에 상품개수를 넣는다면 jsp에서 뿌려줄 때 각 주문번호 별로 구분짓는 무언가가 또 필요하다
	 * 2. db에 해당 주문번호의 첫번째 상품옵션 정보에 상품개수를 넣고, 해당주문번호의 나머지 상품옵션들의 상품개수칼럼에는 null값는다고 가정 시, 
	 * 		desc/asc 상황에 따라 순서가 뒤틀리면 의미가 없어짐
	 * 3. 결국 그렇다면 불러올 때 속성값으로만 처리를 해주어야 한다.
	 */
	/*for(int num=0; num<ordersVoList.size(); num++){		//ordersVo를 OrderNo 별로 group한 orderNoCount를 가지고 각 group의 개수를 해당 group의 첫번째 데이터의 orderNoCount속성에 set한다
		for(int countNum=0; countNum<orderNoCount.size(); countNum++){//향상된for문
			//if(ordersVoList.get(i).getOrderNo()==orderNoCount.get(j).getOrderNo()){ //주문번호가 같을때 해당 주문번호 group에 해당하는 개수를 set해준다
			if(ordersVoList.get(num).isEqualsOrderNo(ordersVoList.get(num),orderNoCount.get(countNum))){ //주문번호가 같을때 해당 주문번호 group에 해당하는 개수를 set해준다
				ordersVoList.get(num).setOrderNoCount(orderNoCount.get(countNum).getOrderNoCount());
				int stat=0;
				for(int k=num; k<num+orderNoCount.get(countNum).getOrderNoCount(); k++){	//이 때 group에 속하는 각 주문상품들의 재고수량과 구매수량을 체크하여 구매수량이 더 많을경우 QuantityCheck에 값'1'을 set한다. 후에 값'1'이 존재할 경우 '재고부족'으로 화면에 표시된다.
					if(ordersVoList.get(k).getBuyAmount()>ordersVoList.get(k).getProductAmount()){
						ordersVoList.get(num).setQuantityCheck(1);
					}
					if(ordersVoList.get(num).getOrderStat()==4){//주문상태가 배송중이고 배송상태는 배송완료일때 주문상태를 전체배송완료로 바꿔주기 위한 로직
						if(ordersVoList.get(k).getDeliveryStat()==3){
							stat += 1;
						}
						if(stat==orderNoCount.get(countNum).getOrderNoCount()){
							updateOrderStat(ordersVoList.get(num).getOrderNo(),5);
							selectOrdersAll(usersVo);
						}
					}
				}
				num += orderNoCount.get(countNum).getOrderNoCount();
			}
		}
	}*/
	//주문정보 불러오기
	@Override
	public List<OrdersVo> selectOrdersAll(UsersVo usersVo)throws Exception{
		List<OrdersVo> ordersVoList = null;
		List<OrdersVo> orderNoCount = null;
		
		switch(usersVo.getUserSection()){
			case 1: 
				ordersVoList = ordersDao.selectOrdersAll(usersVo.getUserNo());
				orderNoCount = ordersDao.selectOrderNoGroupCount(usersVo.getUserNo());
				break;
			case 2:
				ordersVoList = ordersDao.selectSellerOrdersAll(usersVo.getUserNo());
				orderNoCount = ordersDao.selectSellerGroupCount(usersVo.getUserNo());
				break;
		}
		
		for(int num = 0; num < ordersVoList.size();){		//ordersVo를 OrderNo 별로 group한 orderNoCount를 가지고 각 group의 개수를 해당 group의 첫번째 데이터의 orderNoCount속성에 set한다
			OrdersVo eachOrder = ordersVoList.get(num);
			
			for(int countNum=0; countNum < orderNoCount.size(); countNum++){
				OrdersVo orderCount = orderNoCount.get(countNum);
				
				if(isEqualsOrderNo(eachOrder,orderCount)){ //주문번호가 같을때 해당 주문번호 group에 해당하는 개수를 set해준다
					eachOrder.setOrderNoCount(orderCount.getOrderNoCount());
					num += orderCount.getOrderNoCount();
					break;
				}
			}
		}
		
		
		/*for(int amountNum = num; amountNum < num + eachOrder.getOrderNoCount(); amountNum++){	//이 때 group에 속하는 각 주문상품들의 재고수량과 구매수량을 체크하여 구매수량이 더 많을경우 QuantityCheck에 값'1'을 set한다. 후에 값'1'이 존재할 경우 '재고부족'으로 화면에 표시된다.
		OrdersVo groupOrder = ordersVoList.get(amountNum);
			
		if(checkLackOfAmount(groupOrder)){
				eachOrder.setQuantityCheck(1);
		}
		}*/
		for(OrdersVo oVo : ordersVoList){ //주문수량이 재고수량보다 클 경우 QuantityCheck에 값'1'을 set한다. 후에 값'1'이 존재할 경우 '재고부족'으로 화면에 표시된다.
			if(checkLackOfAmount(oVo)){
				oVo.setQuantityCheck(1);
			}
		}
		
		return ordersVoList;
	}
	
	//해당주문의 orderStat 변경
	@Override
	public boolean updateOrderStat(int orderNo, int orderStat)throws Exception{
		int stat = 0;
		int stat2 = 0;
		List<OrdersVo> vo = null;
		
		if(orderStat==2){
			vo = ordersDao.selectByPrdOpNo(orderNo);
			for(int i=0; i<vo.size(); i++){//재고수량 - 상품수량 업데이트 수행
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
		boolean result = false;
		
		stat = orderProductDao.udtDeliveryStat(new OrderProductVo(orderNo, productOptionNo, deliveryStat));
		
		if(stat==1){
			result = checkUpDeliveryStat(orderNo,deliveryStat);
		
			switch(deliveryStat){
				case 2:
					if(result==true){
						return true;
					}
					break;
					
				case 3:
					return true;
			}
		}
		return false;
	}
	
	//deliveryStat이 변경 될 시점에 각 deliveryStat을 체크하여 조건을 충족하면 orderStat을 변경하는 메소드
	@Override
	public boolean checkUpDeliveryStat(int orderNo, int deliveryStat)throws Exception{
		List<OrderProductVo> productList = null;
		int CompleteDelivery = 0;
		int stat = 0;
		
		switch(deliveryStat){
			case 2: //deliveryStat이 배송중 상태일 경우 orderStat을 배송중으로 변경하는 로직
				stat = ordersDao.updateOrderStat(new OrdersVo(orderNo, 4));
				if(stat == 1){
					return true;
				}
				break;
				
			case 3: //deliveryStat이 배송완료 상태일 경우, 해당 orderNo에 해당하는 전체상품옵션의 deliveryStat이 모두 배송완료인지 체크한 후 orderStat을 전체배송완료로 변경하는 로직
				productList = orderProductDao.selectDeliveryStat(orderNo);

				for(OrderProductVo eachProduct :productList){ //해당상품옵션의 deliveryStat이 배송완료일 경우 CompleteDelivery에 1을 더해준다.
					if(eachProduct.getDeliveryStat() == 3){
						CompleteDelivery += 1;
					}
				}
				
				if(CompleteDelivery==productList.size()){ //모든 상품옵션이 배송완료상태일 경우 해당 주문의 orderStat을 전체배송완료로 변경
					stat = ordersDao.updateOrderStat(new OrdersVo(orderNo, 5));
					if(stat == 1){
						return true;
					}
				}
				break;
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
	
	//두 OrdersVo객체의 주문번호가 같은지 체크하는 메소드
	@Override
	public boolean isEqualsOrderNo(OrdersVo orderVo,OrdersVo orderNoCount){
		if(orderVo.getOrderNo() == orderNoCount.getOrderNo()){
			return true;
		}
		return false;
	}
	
	//해당 상품옵션의 수량부족 체크
	@Override
	public boolean checkLackOfAmount(OrdersVo groupOrder){
		if(groupOrder.getBuyAmount() <= groupOrder.getProductAmount()){
			return true;
		}
		return false;
	}
	
	
}
