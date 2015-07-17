package hwst.service.order;

import hwst.domain.order.OrderVo;

import java.util.List;

public interface OrderService {

	List<OrderVo> selectCategory();
	List<OrderVo> selectUpCategory();
}
