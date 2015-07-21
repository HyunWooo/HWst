package hwst.dao.orders;

import hwst.domain.orders.PaymentVo;
import hwst.util.DBUtil;

import org.apache.ibatis.session.SqlSession;
import org.springframework.stereotype.Repository;

@Repository("paymentDao")
public class PaymentDaoImpl  implements PaymentDao {
	
	//주문정보 insert
	@Override
	public int insertPayment(PaymentVo payVo)throws Exception{
		SqlSession session = null;
		int stat = 0;
		try {
			session = DBUtil.getSqlSession();
			stat = session.insert("orders.insertPayment",payVo);
		} finally {
			DBUtil.closeSqlSession(session);
		}
		return stat;
	}
	
}
