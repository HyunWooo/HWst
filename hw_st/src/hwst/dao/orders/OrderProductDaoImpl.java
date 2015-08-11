package hwst.dao.orders;

import hwst.domain.orders.OrderProductVo;

import java.util.List;

import org.apache.ibatis.session.SqlSession;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

@Repository("orderProductDao")
public class OrderProductDaoImpl  implements OrderProductDao {
	
	@Autowired
	private SqlSession sqlSession;
	
	
	//주문정보 insert
	@Override
	public int insertOrderProduct(OrderProductVo opVo){
		return sqlSession.insert("orders.insertOrderProduct",opVo);
	}
	
	//주문정보 delete
	@Override
	public int deleteOrderProduct(int orderNo){
		return sqlSession.update("orders.deleteOrderProduct",orderNo);
	}
	
	//주문의 각 상품의 deliveryStat 갱신
	@Override
	public int udtDeliveryStat(OrderProductVo orderProductVo){
		return sqlSession.update("orders.udtDeliveryStat",orderProductVo);
	}
	
	//주문번호에 해당하는 상품옵션들의 deliveryStat select해오는것
	@Override
	public List<OrderProductVo> selectDeliveryStat(int orderNo){
		return sqlSession.selectList("orders.selectDeliveryStat", orderNo);
	}

}
