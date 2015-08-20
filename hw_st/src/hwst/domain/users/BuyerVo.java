package hwst.domain.users;

import hwst.domain.users.UsersEnum.Grade;
import hwst.domain.users.UsersEnum.UserSection;

import java.util.Date;

import org.apache.commons.lang.builder.ToStringBuilder;
import org.apache.commons.lang.builder.ToStringStyle;

public class BuyerVo extends UsersVo{

	Grade grade;
	int discountPercent;
	Date udtGradeTime;
	
	
	public BuyerVo() {
		super();
	}
	public BuyerVo(int userNo, String id, String pw, String name, String phone,
			UserSection userSection, String postCode, String address) {
		super(userNo, id, pw, name, phone, address, postCode, userSection);
	}
	
	public Grade getGrade() {
		return grade;
	}
	public void setGrade(Grade grade) {
		this.grade = grade;
	}
	public Date getUdtGradeTime() {
		return udtGradeTime;
	}
	public void setUdtGradeTime(Date udtGradeTime) {
		this.udtGradeTime = udtGradeTime;
	}
	public int getDiscountPercent() {
		return discountPercent;
	}
	public void setDiscountPercent(int discountPercent) {
		this.discountPercent = discountPercent;
	}
	
	@Override
	public String toString() {
		return ToStringBuilder.reflectionToString(
				this, ToStringStyle.MULTI_LINE_STYLE
				);
	}

}
