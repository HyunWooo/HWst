package hwst.dao.order;

import hwst.domain.order.OrderVo;

import java.util.List;

public interface OrderDao {
	List<OrderVo> selectCategory();
	List<OrderVo> selectUpCategory();
}
