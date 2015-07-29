package hwst.dao.orders;

import hwst.domain.orders.OrderProductVo;

import java.util.List;

public interface OrderProductDao {
	int insertOrderProduct(OrderProductVo opVo)throws Exception;
	int deleteOrderProduct(int orderNo)throws Exception;
	int udtDeliveryStat(OrderProductVo orderProductVo)throws Exception;
	List<OrderProductVo> selectDeliveryStat(int orderNo)throws Exception;
}
