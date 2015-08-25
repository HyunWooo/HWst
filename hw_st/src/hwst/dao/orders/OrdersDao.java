package hwst.dao.orders;

import java.util.List;
import java.util.Map;

import hwst.domain.orders.OrdersVo;

public interface OrdersDao {
	int insertOrders(OrdersVo ordersVo);
	int selectOrderNoByUserNo(int userNo);
	List<OrdersVo> selectOrdersAll(int userNo);
	int updateOrderStat(OrdersVo ordersVo);
	int deleteOrder(int orderNo);
	List<OrdersVo> selectSellerOrdersAll(int userNo);
	Map<Integer, Integer> selectSellerOrdGroupCnt(int userNo);
	List<OrdersVo> selectByPrdOpNo(int orderNo);
	OrdersVo selectGradeFulfill(int userNo);
	Map<Integer, Integer> selectBuyerOrdGroupCnt(int userNo);
}
