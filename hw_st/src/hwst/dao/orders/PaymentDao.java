package hwst.dao.orders;

import hwst.domain.orders.PaymentVo;

public interface PaymentDao {
	int insertPayment(PaymentVo payVo);
}
