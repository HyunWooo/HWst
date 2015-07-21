package hwst.service.orders;

import hwst.domain.orders.OrdersVo;
import hwst.domain.users.UsersVo;

import java.util.List;

public interface OrdersService {

	boolean insertOrders(OrdersVo ordersVo, List<Integer> productOptionNo, List<Integer> buyAmount,
					List<Integer> totalPrice, int checkoutInfo, String fromCart) throws Exception;
	List<OrdersVo> selectOrdersAll(UsersVo vo)throws Exception;
	boolean updateOrderStat(int orderNo, int orderStat)throws Exception;
	boolean deleteOrder(int orderNo)throws Exception;
	boolean udtDeliveryStat(int orderNo, int productOptionNo, int deliveryStat)throws Exception;
	
}
