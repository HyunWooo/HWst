package hwst.dao.order;

import hwst.domain.order.OrderVo;
import hwst.util.DBUtil;

import java.util.List;

import org.apache.ibatis.session.SqlSession;
import org.springframework.stereotype.Repository;

@Repository("orderDao")
public class OrderDaoImpl  implements OrderDao {
	
	//카테고리정보 조회
	@Override
	public List<OrderVo> selectCategory(){
		SqlSession session = null;
		List<OrderVo> list = null;
		try {
			session = DBUtil.getSqlSession();
			list = session.selectList("order.selectCategory");
		} finally {
			DBUtil.closeSqlSession(session);
		}
		return list;
	}
	
	//상위카테고리정보 조회
	@Override
	public List<OrderVo> selectUpCategory(){
		SqlSession session = null;
		List<OrderVo> list = null;
		try {
			session = DBUtil.getSqlSession();
			list = session.selectList("order.selectUpCategory");
		} finally {
			DBUtil.closeSqlSession(session);
		}
		return list;
	}
}
