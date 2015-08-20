package hwst.service.orders;

import hwst.common.CommonMethod;
import hwst.dao.cart.CartDao;
import hwst.dao.orders.OrderProductDao;
import hwst.dao.orders.OrdersDao;
import hwst.dao.orders.PaymentDao;
import hwst.dao.product.ProductOptionDao;
import hwst.dao.users.GradeDao;
import hwst.dao.users.UsersDao;
import hwst.domain.orders.OrderProductVo;
import hwst.domain.orders.OrdersEnum;
import hwst.domain.orders.OrdersEnum.DeliveryStat;
import hwst.domain.orders.OrdersEnum.OrderStat;
import hwst.domain.orders.OrdersVo;
import hwst.domain.orders.PaymentVo;
import hwst.domain.product.ProductOptionVo;
import hwst.domain.users.BuyerVo;
import hwst.domain.users.GradeVo;
import hwst.domain.users.UsersEnum.Grade;
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
	
	@Resource(name="gradeDao")
	private GradeDao gradeDao;
	
	@Resource(name="usersDao")
	private UsersDao usersDao;
	
	
	//주문정보 Insert
	@Override
	public boolean insertOrders(OrdersVo ordersVo, List<Integer> productOptionNo, List<Integer> buyAmount,
			List<Integer> totalPrice, List<Integer> deletedCart, int checkoutInfo,String fromCart) throws Exception{
		int successCount = 0;
		
		if(CommonMethod.isSuccessOneCUD(ordersDao.insertOrders(ordersVo))){
			int orderNo= ordersDao.selectOrderNoByUserNo(ordersVo.getUserNo());
			
			for(int num=0; num<productOptionNo.size(); num++){ //주문상품정보 insert
				OrderProductVo opVo = new OrderProductVo(orderNo, productOptionNo.get(num), buyAmount.get(num), totalPrice.get(num), ordersVo.getUserNo());
				successCount += orderProductDao.insertOrderProduct(opVo);
			}
			
			if(CommonMethod.isEqualValues(successCount, productOptionNo.size())){ //결제 데이터 insert
				successCount = paymentDao.insertPayment(new PaymentVo(orderNo, checkoutInfo));
			}
			
			//장바구니에서 주문한 거라면 해당장바구니항목 삭제
			if(CommonMethod.isSuccessOneCUD(successCount) && fromCart=="yes"){
				return CommonMethod.isSuccessOneCUD(cartDao.deleteCartOrder(deletedCart));
			}
			
		}
		return false;
	}
	
	
	/* DB에 하나의 주문에 존재하는 상품개수를 못넣는이유
	 * 1. 해당 칼럼 전체에 상품개수를 넣는다면 jsp에서 뿌려줄 때 각 주문번호 별로 구분짓는 무언가가 또 필요하다
	 * 2. db에 해당 주문번호의 첫번째 상품옵션 정보에 상품개수를 넣고, 해당주문번호의 나머지 상품옵션들의 상품개수칼럼에는 null값는다고 가정 시, 
	 * 		desc/asc 상황에 따라 순서가 뒤틀리면 의미가 없어짐
	 * 3. 결국 그렇다면 불러올 때 속성값으로만 처리를 해주어야 한다.
	 */
	//주문정보 불러오기
	@Override
	public List<OrdersVo> selectOrdersAll(UsersVo usersVo)throws Exception{
		List<OrdersVo> ordersVoList = null;
		List<OrdersVo> orderNoCount = null;
		
		switch(usersVo.getUserSection()){
			case BUYER: 
				ordersVoList = ordersDao.selectOrdersAll(usersVo.getUserNo());
				orderNoCount = ordersDao.selectOrderNoGroupCount(usersVo.getUserNo());
				break;
			case SELLER:
				ordersVoList = ordersDao.selectSellerOrdersAll(usersVo.getUserNo());
				orderNoCount = ordersDao.selectSellerGroupCount(usersVo.getUserNo());
				break;
			case ADMIN:
				break;
			case UNREGISTER:
				break;
			default:
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
		
		checkQuantity(ordersVoList);
		
		return ordersVoList;
	}


	//해당주문의 orderStat 변경
	@Override
	public boolean updateOrderStat(int orderNo, OrderStat orderStat)throws Exception{
		int stat = 0;
		List<OrdersVo> oVo = null;
		
		if(CommonMethod.isEqualValues(orderStat, OrderStat.COMPLETEPAYMENT)){
			oVo = ordersDao.selectByPrdOpNo(orderNo);
			
			for(int num=0, size = oVo.size(); num < size; num++){//재고수량 - 상품수량 업데이트 수행
				int updateAmount = oVo.get(num).getProductAmount()-oVo.get(num).getBuyAmount();
				stat += productOptionDao.udtPrdAmount(new ProductOptionVo(oVo.get(num).getProductOptionNo(),updateAmount));
			}
			
			if(CommonMethod.isSuccessManyCUD(stat, oVo.size())){
				 return CommonMethod.isSuccessOneCUD(ordersDao.updateOrderStat(new OrdersVo(orderNo, orderStat)));
			}
		}
		else{
			return CommonMethod.isSuccessOneCUD(ordersDao.updateOrderStat(new OrdersVo(orderNo, orderStat)));
		}
		
		return false;
	}
	
	
	//해당주문의 각 상품의 deliveryStat 변경
	@Override
	public boolean udtDeliveryStat(int orderNo, int productOptionNo, DeliveryStat deliveryStat, Grade grade, int userNo)throws Exception{
		if(CommonMethod.isSuccessOneCUD(orderProductDao.udtDeliveryStat(new OrderProductVo(orderNo, productOptionNo, deliveryStat)))){
		   System.out.println(deliveryStat);
			switch(deliveryStat){
				case DELIVERING:
					return checkUpDeliveryStat(orderNo, deliveryStat, grade, userNo);
				case DELIVERYALLCOMPLETE:
					return checkUpDeliveryStat(orderNo, deliveryStat, grade, userNo);
				default:
					break;
			}
		}
		return false;
	}
	
	//해당주문의 각 상품의 deliveryStat 변경 (SELLER용)
	@Override
	public boolean udtDeliveryStatS(int orderNo, int productOptionNo, DeliveryStat deliveryStat)throws Exception{
		if(CommonMethod.isSuccessOneCUD(orderProductDao.udtDeliveryStat(new OrderProductVo(orderNo, productOptionNo, deliveryStat)))){
		   System.out.println(deliveryStat);
			switch(deliveryStat){
				case DELIVERING:
					return checkUpDeliveryStatS(orderNo, deliveryStat);
				case DELIVERYALLCOMPLETE:
					return checkUpDeliveryStatS(orderNo, deliveryStat);
				default:
					break;
			}
		}
		return false;
	}
	
	
	//deliveryStat이 변경 될 시점에 각 deliveryStat을 체크하여 조건을 충족하면 orderStat을 변경하는 메소드
	@Override
	public boolean checkUpDeliveryStat(int orderNo, DeliveryStat deliveryStat, Grade grade, int userNo)throws Exception{
		switch(deliveryStat){
			case DELIVERING: //deliveryStat이 배송중 상태일 경우 orderStat을 배송중으로 변경하는 로직
				return CommonMethod.isSuccessOneCUD(ordersDao.updateOrderStat(new OrdersVo(orderNo, OrdersEnum.OrderStat.DELIVERING)));
				
			case DELIVERYALLCOMPLETE: //deliveryStat이 배송완료 상태일 경우, 해당 orderNo에 해당하는 전체상품옵션의 deliveryStat이 모두 배송완료인지 체크한 후 orderStat을 전체배송완료로 변경하는 로직
				checkDeliveryComplete(orderNo, orderProductDao.selectDeliveryStat(orderNo), grade, userNo);
				return true;			
						
			default:
				return false;
		}
	}
	
	//deliveryStat이 변경 될 시점에 각 deliveryStat을 체크하여 조건을 충족하면 orderStat을 변경하는 메소드
	public boolean checkUpDeliveryStatS(int orderNo, DeliveryStat deliveryStat)throws Exception{
		switch(deliveryStat){
			case DELIVERING: //deliveryStat이 배송중 상태일 경우 orderStat을 배송중으로 변경하는 로직
				return CommonMethod.isSuccessOneCUD(ordersDao.updateOrderStat(new OrdersVo(orderNo, OrdersEnum.OrderStat.DELIVERING)));
				
			case DELIVERYALLCOMPLETE: //deliveryStat이 배송완료 상태일 경우, 해당 orderNo에 해당하는 전체상품옵션의 deliveryStat이 모두 배송완료인지 체크한 후 orderStat을 전체배송완료로 변경하는 로직
				checkDeliveryCompleteS(orderNo, orderProductDao.selectDeliveryStat(orderNo));
				return true;			
						
			default:
				return false;
		}
	}
	
	
	//해당주문 삭제
	@Override
	public boolean deleteOrder(int orderNo)throws Exception{
		
		if(CommonMethod.isSuccessOneCUD(ordersDao.deleteOrder(orderNo))){
			orderProductDao.deleteOrderProduct(orderNo);
			return true;
		}

		return false;
	}
	
	
	
	
	//두 OrdersVo객체의 주문번호가 같은지 체크하는 메소드
	public boolean isEqualsOrderNo(OrdersVo orderVo,OrdersVo orderNoCount){
		if(CommonMethod.isEqualValues(orderVo.getOrderNo(), orderNoCount.getOrderNo())){
			return true;
		}
		return false;
	}
	
	
	//해당 상품옵션의 수량부족 체크
	private void checkQuantity(List<OrdersVo> ordersVoList) {
		for(int num = 0; num<ordersVoList.size(); num++){
			checkLackOfAmount(ordersVoList, num);
		}
	}
	
	//수량부족한 해당 주문번호의 QuantityCheck값을 1로 설정하기
	public void checkLackOfAmount(List<OrdersVo> ordersVoList, int num){
		if(ordersVoList.get(num).getBuyAmount() > ordersVoList.get(num).getProductAmount()){
			for(int inNum=0; inNum<ordersVoList.size(); inNum++){
				if(CommonMethod.isEqualValues(ordersVoList.get(inNum).getOrderNo(), ordersVoList.get(num).getOrderNo())){
					ordersVoList.get(inNum).setQuantityCheck(1);  //주문수량이 재고수량보다 클 경우 QuantityCheck에 값'1'을 set한다. 후에 값'1'이 존재할 경우 '재고부족'으로 화면에 표시된다.
				}
			}
		}
	}
		
	//deliveryStat이 배송완료 상태일 경우, 해당 orderNo에 해당하는 전체상품옵션의 deliveryStat이 모두 배송완료인지 체크한 후 orderStat을 전체배송완료로 변경하는 로직
	private boolean checkDeliveryComplete(int orderNo, List<OrderProductVo> productList, Grade grade, int userNo) throws Exception{
		int completeDelivery = 0;
		for(OrderProductVo eachProduct :productList){ //해당상품옵션의 deliveryStat이 배송완료일 경우 CompleteDelivery에 1을 더해준다.
			if(CommonMethod.isEqualValues(eachProduct.getDeliveryStat(),DeliveryStat.DELIVERYALLCOMPLETE)){
				completeDelivery += 1;
			}
		}
		if(CommonMethod.isEqualValues(completeDelivery, productList.size())){ //모든 상품옵션이 배송완료상태일 경우 해당 주문의 orderStat을 전체배송완료로 변경
			checkGradeUp(grade, userNo);
			return CommonMethod.isSuccessOneCUD(ordersDao.updateOrderStat(new OrdersVo(orderNo, OrderStat.DELIVERYALLCOMPLETE)));
		}
		
		return false;
	}
	
	//deliveryStat이 배송완료 상태일 경우, 해당 orderNo에 해당하는 전체상품옵션의 deliveryStat이 모두 배송완료인지 체크한 후 orderStat을 전체배송완료로 변경하는 로직
	private boolean checkDeliveryCompleteS(int orderNo, List<OrderProductVo> productList) throws Exception{
		int completeDelivery = 0;
		for(OrderProductVo eachProduct :productList){ //해당상품옵션의 deliveryStat이 배송완료일 경우 CompleteDelivery에 1을 더해준다.
			if(CommonMethod.isEqualValues(eachProduct.getDeliveryStat(),DeliveryStat.DELIVERYALLCOMPLETE)){
				completeDelivery += 1;
			}
		}
		if(CommonMethod.isEqualValues(completeDelivery, productList.size())){ //모든 상품옵션이 배송완료상태일 경우 해당 주문의 orderStat을 전체배송완료로 변경
			return CommonMethod.isSuccessOneCUD(ordersDao.updateOrderStat(new OrdersVo(orderNo, OrderStat.DELIVERYALLCOMPLETE)));
		}
		
		return false;
	}


	private void checkGradeUp(Grade grade, int userNo) {
		OrdersVo oVo = ordersDao.selectGradeFulfill(userNo);
		List<GradeVo> gVo = gradeDao.selectGradeList();
		BuyerVo buyerVo = new BuyerVo();
		buyerVo.setUserNo(userNo);
		GradeVo silver = gVo.get(1);
		GradeVo gold = gVo.get(2);
		
		switch(grade){
		case GENERAL:
			checkGradeStat(oVo,silver, buyerVo);
			break;
		case SILVER:
			checkGradeStat(oVo,gold, buyerVo);
			break;
		case GOLD:
			break;
		default:
			break;
		}
	}


	private void checkGradeStat(OrdersVo oVo, GradeVo gVo, BuyerVo buyerVo) {
		System.out.println("왔다갑니다");
		if(oVo.getOrderCount() >= gVo.getOrderCount() && oVo.getSumPayment() >= gVo.getSumPayment()){
			buyerVo.setGrade(gVo.getGrading());
			usersDao.updateGrade(buyerVo);
		}
		
	} 
	
}
