package hwst.dao.orders;

import java.util.List;

import hwst.domain.orders.OrdersVo;

public interface OrdersDao {
	int insertOrders(OrdersVo ordersVo)throws Exception;
	int selectOrderNoByUserNo(int userNo)throws Exception;
	List<OrdersVo> selectOrdersAll(int userNo)throws Exception;
	List<OrdersVo> selectOrderNoGroupCount(int userNo)throws Exception;
	int updateOrderStat(OrdersVo ordersVo)throws Exception;
	int deleteOrder(int orderNo)throws Exception;
	List<OrdersVo> selectSellerOrdersAll(int userNo)throws Exception;
	List<OrdersVo> selectSellerGroupCount(int userNo)throws Exception;
	List<OrdersVo> selectByPrdOpNo(int orderNo)throws Exception;
}
