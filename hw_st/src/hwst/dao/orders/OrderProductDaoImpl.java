package hwst.dao.orders;

import hwst.domain.orders.OrderProductVo;
import hwst.util.DBUtil;

import java.util.List;

import org.apache.ibatis.session.SqlSession;
import org.springframework.stereotype.Repository;

@Repository("orderProductDao")
public class OrderProductDaoImpl  implements OrderProductDao {
	
	//주문정보 insert
	@Override
	public int insertOrderProduct(OrderProductVo opVo){
		SqlSession session = null;
		int stat = 0;
		try {
			session = DBUtil.getSqlSession();
			stat = session.insert("orders.insertOrderProduct",opVo);
		} finally {
			DBUtil.closeSqlSession(session);
		}
		return stat;
	}
	
	//주문정보 delete
	@Override
	public int deleteOrderProduct(int orderNo){
		SqlSession session = null;
		int stat = 0;
		try {
			session = DBUtil.getSqlSession();
			stat = session.update("orders.deleteOrderProduct",orderNo);
		} finally {
			DBUtil.closeSqlSession(session);
		}
		return stat;
	}
	
	
	//주문의 각 상품의 deliveryStat 갱신
	@Override
	public int udtDeliveryStat(OrderProductVo orderProductVo){
		SqlSession session = null;
		int stat = 0;
		try {
			session = DBUtil.getSqlSession();
			stat = session.update("orders.udtDeliveryStat",orderProductVo);
		} finally {
			DBUtil.closeSqlSession(session);
		}
		return stat;
	}
	
	//주문번호에 해당하는 상품옵션들의 deliveryStat select해오는것
	@Override
	public List<OrderProductVo> selectDeliveryStat(int orderNo)throws Exception{
		SqlSession session = null;
		List<OrderProductVo> opVo = null;
		try {
			session = DBUtil.getSqlSession();
			opVo = session.selectList("orders.selectDeliveryStat", orderNo);
		} finally {
			DBUtil.closeSqlSession(session);
		}
		return opVo;
	}

}
