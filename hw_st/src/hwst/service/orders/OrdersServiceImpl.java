package hwst.service.orders;

import hwst.dao.cart.CartDao;
import hwst.dao.orders.OrderProductDao;
import hwst.dao.orders.OrdersDao;
import hwst.dao.orders.PaymentDao;
import hwst.domain.orders.OrderProductVo;
import hwst.domain.orders.OrdersVo;
import hwst.domain.orders.PaymentVo;
import hwst.domain.product.ProductOptionVo;

import java.util.List;

import javax.annotation.Resource;

import org.springframework.stereotype.Service;

@Service("ordersService")
public class OrdersServiceImpl implements OrdersService {

	@Resource(name="ordersDao")
	private OrdersDao ordersDao;
	
	@Resource(name="orderProductDao")
	private OrderProductDao orderProductDao;
	
	@Resource(name="paymentDao")
	private PaymentDao paymentDao;
	
	@Resource(name="cartDao")
	private CartDao cartDao;
	
	//주문정보 Insert
	@Override
	public boolean insertOrders(List<Integer> productOptionNo, List<Integer> buyAmount,
			List<Integer> totalPrice, String receiverName, String phone,
			String postCode, String address, int checkoutInfo, int userNo,
			int grade, String message, String allTotalPrice,
			String discountPrice, String discountedTotalPrice) throws Exception{
		System.out.println(userNo);
		System.out.println(receiverName);
		int stat2 = 0;
		int stat3 = 0;
		int stat4 = 0;
		
		
		OrdersVo ordersVo = new OrdersVo(userNo, receiverName, phone, postCode, address, message, grade, allTotalPrice, discountPrice, discountedTotalPrice);
		System.out.println("service의 ordersVo"+ordersVo);
		int stat = ordersDao.insertOrders(ordersVo);
		if(stat==1){
			int orderNo= ordersDao.selectOneOrderNoByUserNoAndTime(userNo);
			
			for(int i=0; i<productOptionNo.size(); i++){
				OrderProductVo opVo = new OrderProductVo(orderNo, productOptionNo.get(i), buyAmount.get(i), totalPrice.get(i), userNo);
				stat2 += orderProductDao.insertOrderProduct(opVo);
			}
			if(stat2==productOptionNo.size()){
				stat3 = paymentDao.insertPayment(new PaymentVo(orderNo, checkoutInfo));
			}
			if(stat3==1){
				for(int i=0; i<productOptionNo.size(); i++){
					ProductOptionVo productOptionVo = new ProductOptionVo(productOptionNo.get(i),userNo);
					stat4 = cartDao.deleteCartByOrderComplete(productOptionVo);
				}
					
			}
			
		}
		
		if(stat4>0){
			return true;
		}
		else{
			return false;
		}
		
	}
	
}
