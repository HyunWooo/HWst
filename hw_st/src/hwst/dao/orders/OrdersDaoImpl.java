package hwst.dao.orders;

import hwst.domain.orders.OrdersVo;
import hwst.util.DBUtil;

import org.apache.ibatis.session.SqlSession;
import org.springframework.stereotype.Repository;

@Repository("ordersDao")
public class OrdersDaoImpl  implements OrdersDao {
	
	//주문정보 insert
	@Override
	public int insertOrders(OrdersVo ordersVo){
		SqlSession session = null;
		int stat = 0;
		try {
			System.out.println(ordersVo + "ordersVo");
			session = DBUtil.getSqlSession();
			stat = session.insert("orders.insertOrders",ordersVo);
		} finally {
			DBUtil.closeSqlSession(session);
		}
		return stat;
	}
	
	//가장최근에 insert한 유저번호의 주문번호 select
	@Override
	public int selectOneOrderNoByUserNoAndTime(int userNo){
		SqlSession session = null;
		int orderNo = 0;
		try {
			session = DBUtil.getSqlSession();
			orderNo = session.selectOne("orders.selectOneOrderNoByUserNoAndTime", userNo);
		} finally {
			DBUtil.closeSqlSession(session);
		}
		return orderNo;
	}
	
}
