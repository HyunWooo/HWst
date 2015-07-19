package hwst.dao.orders;

import hwst.domain.orders.OrdersVo;

public interface OrdersDao {
	int insertOrders(OrdersVo ordersVo)throws Exception;
	int selectOneOrderNoByUserNoAndTime(int userNo)throws Exception;
}
