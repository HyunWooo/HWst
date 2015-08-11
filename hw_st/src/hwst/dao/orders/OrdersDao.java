package hwst.dao.orders;

import java.util.List;

import hwst.domain.orders.OrdersVo;

public interface OrdersDao {
	int insertOrders(OrdersVo ordersVo);
	int selectOrderNoByUserNo(int userNo);
	List<OrdersVo> selectOrdersAll(int userNo);
	List<OrdersVo> selectOrderNoGroupCount(int userNo);
	int updateOrderStat(OrdersVo ordersVo);
	int deleteOrder(int orderNo);
	List<OrdersVo> selectSellerOrdersAll(int userNo);
	List<OrdersVo> selectSellerGroupCount(int userNo);
	List<OrdersVo> selectByPrdOpNo(int orderNo);
}
