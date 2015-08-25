package hwst.domain.users;

import hwst.domain.users.Grade;

import org.apache.commons.lang.builder.ToStringBuilder;
import org.apache.commons.lang.builder.ToStringStyle;

public class GradeVo {


	private Grade grading;
	private String gradeName;
	private int discountPercent;
	private int sumPayment;
	private int orderCount;
	
	public GradeVo(){};
	
	public GradeVo(Grade grading, String gradeName, int discountPercent,
			int sumPayment, int orderCount) {
		super();
		this.grading = grading;
		this.gradeName = gradeName;
		this.discountPercent = discountPercent;
		this.sumPayment = sumPayment;
		this.orderCount = orderCount;
	}

	public Grade getGrading() {
		return grading;
	}

	public void setGrading(Grade grading) {
		this.grading = grading;
	}

	public String getGradeName() {
		return gradeName;
	}

	public void setGradeName(String gradeName) {
		this.gradeName = gradeName;
	}

	public int getDiscountPercent() {
		return discountPercent;
	}

	public void setDiscountPercent(int discountPercent) {
		this.discountPercent = discountPercent;
	}

	public int getSumPayment() {
		return sumPayment;
	}

	public void setSumPayment(int sumPayment) {
		this.sumPayment = sumPayment;
	}

	public int getOrderCount() {
		return orderCount;
	}

	public void setOrderCount(int orderCount) {
		this.orderCount = orderCount;
	}
	
	@Override
	public String toString() {
		return ToStringBuilder.reflectionToString(
				this, ToStringStyle.MULTI_LINE_STYLE
				);
	}
	
	
}
