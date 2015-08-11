package hwst.dao.orders;

import hwst.domain.orders.PaymentVo;

import org.apache.ibatis.session.SqlSession;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

@Repository("paymentDao")
public class PaymentDaoImpl  implements PaymentDao {
	
	@Autowired
	private SqlSession sqlSession;
	
	
	//주문정보 insert
	@Override
	public int insertPayment(PaymentVo payVo){
		return sqlSession.insert("orders.insertPayment",payVo);
	}
	
}
