package hwst.dao.orders;

import hwst.domain.orders.OrderProductVo;

public interface OrderProductDao {
	int insertOrderProduct(OrderProductVo opVo)throws Exception;
}
