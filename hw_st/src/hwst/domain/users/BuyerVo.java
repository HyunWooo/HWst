package hwst.domain.users;

public class BuyerVo extends UsersVo{

	int grade;
	int discountPercent;
	String udtGradeTime;
	
	
	public BuyerVo() {
		super();
		// TODO Auto-generated constructor stub
	}
	public BuyerVo(int userNo, String id, String pw, String name, String phone,
			int userSection, String postCode, String address) {
		super(userNo, id, pw, name, phone, address, postCode, userSection);
		// TODO Auto-generated constructor stub
	}
	
	public int getGrade() {
		return grade;
	}
	public void setGrade(int grade) {
		this.grade = grade;
	}
	public String getUdtGradeTime() {
		return udtGradeTime;
	}
	public void setUdtGradeTime(String udtGradeTime) {
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
		StringBuilder builder = new StringBuilder();
		builder.append("BuyerVo [grade=");
		builder.append(grade);
		builder.append(", discountPercent=");
		builder.append(discountPercent);
		builder.append(", udtGradeTime=");
		builder.append(udtGradeTime);
		builder.append(", getId()=");
		builder.append(getId());
		builder.append(", getPw()=");
		builder.append(getPw());
		builder.append(", getName()=");
		builder.append(getName());
		builder.append(", getPhone()=");
		builder.append(getPhone());
		builder.append(", getPostCode()=");
		builder.append(getPostCode());
		builder.append(", getUserNo()=");
		builder.append(getUserNo());
		builder.append(", getAddress()=");
		builder.append(getAddress());
		builder.append(", getUserSection()=");
		builder.append(getUserSection());
		builder.append("]");
		return builder.toString();
	}

}
