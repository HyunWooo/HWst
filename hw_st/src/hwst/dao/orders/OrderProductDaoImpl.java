package hwst.dao.orders;

import hwst.domain.orders.OrderProductVo;
import hwst.util.DBUtil;

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
	
	
}
