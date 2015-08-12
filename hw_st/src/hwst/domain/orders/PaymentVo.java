package hwst.domain.orders;

import org.apache.commons.lang.builder.ToStringBuilder;
import org.apache.commons.lang.builder.ToStringStyle;


public class PaymentVo {
	private int orderNo;
	private int checkoutInfo;
	private int depositYN;
	private String refundBankName;
	private String refundAccountNo;

	public PaymentVo(){}
	
	public PaymentVo(int orderNo, int checkoutInfo){
		this.orderNo = orderNo;
		this.checkoutInfo = checkoutInfo;
	}

	public PaymentVo(int orderNo, int checkoutInfo, int depositYN,
			String refundBankName, String refundAccountNo) {
		super();
		this.orderNo = orderNo;
		this.checkoutInfo = checkoutInfo;
		this.depositYN = depositYN;
		this.refundBankName = refundBankName;
		this.refundAccountNo = refundAccountNo;
	}

	public int getOrderNo() {
		return orderNo;
	}

	public void setOrderNo(int orderNo) {
		this.orderNo = orderNo;
	}

	public int getCheckoutInfo() {
		return checkoutInfo;
	}

	public void setCheckoutInfo(int checkoutInfo) {
		this.checkoutInfo = checkoutInfo;
	}

	public int getDepositYN() {
		return depositYN;
	}

	public void setDepositYN(int depositYN) {
		this.depositYN = depositYN;
	}

	public String getRefundBankName() {
		return refundBankName;
	}

	public void setRefundBankName(String refundBankName) {
		this.refundBankName = refundBankName;
	}

	public String getRefundAccountNo() {
		return refundAccountNo;
	}

	public void setRefundAccountNo(String refundAccountNo) {
		this.refundAccountNo = refundAccountNo;
	}

	@Override
	public String toString() {
		return ToStringBuilder.reflectionToString(
				this, ToStringStyle.MULTI_LINE_STYLE
				);
	}
	
	
	
}