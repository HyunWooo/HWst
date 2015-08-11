package hwst.dao.orders;

import hwst.domain.orders.OrderProductVo;

import java.util.List;

public interface OrderProductDao {
	int insertOrderProduct(OrderProductVo opVo);
	int deleteOrderProduct(int orderNo);
	int udtDeliveryStat(OrderProductVo orderProductVo);
	List<OrderProductVo> selectDeliveryStat(int orderNo);
}
