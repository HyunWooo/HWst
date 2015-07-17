package hwst.service.order;

import hwst.dao.order.OrderDao;
import hwst.domain.order.OrderVo;

import java.util.List;

import javax.annotation.Resource;

import org.springframework.stereotype.Service;

@Service("orderService")
public class OrderServiceImpl implements OrderService {

	@Resource(name="orderDao")
	private OrderDao orderDao;
	
	//카테고리정보 조회
	@Override
	public List<OrderVo> selectCategory(){
		return orderDao.selectCategory();
	}
	
	//상위카테고리정보 조회
	@Override
	public List<OrderVo> selectUpCategory(){
		return orderDao.selectUpCategory();
	}
	
}
