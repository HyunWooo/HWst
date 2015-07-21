package hwst.dao.orders;

import hwst.domain.orders.OrderProductVo;

public interface OrderProductDao {
	int insertOrderProduct(OrderProductVo opVo)throws Exception;
	int deleteOrderProduct(int orderNo)throws Exception;
	int udtDeliveryStat(OrderProductVo orderProductVo)throws Exception;
}
