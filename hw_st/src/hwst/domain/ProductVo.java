package hwst.domain;


public class ProductVo{
	private int productNo;
	private int userNo;
	private int categoryNo;
	private String name;
	private int basicPrice;
	private int stat;
	private String details;
	private int opTotalNum;
	private String regisTime;
	private String recentUpdateTime;
	private int recentUpdateUserNo;
	
	public ProductVo(){}
	public ProductVo(int productNo, int userNo, int categoryNo, String name,
			int basicPrice, int stat, String details, int opTotalNum,
			String regisTime, String recentUpdateTime, int recentUpdateUserNo) {
		super();
		this.productNo = productNo;
		this.userNo = userNo;
		this.categoryNo = categoryNo;
		this.name = name;
		this.basicPrice = basicPrice;
		this.stat = stat;
		this.details = details;
		this.opTotalNum = opTotalNum;
		this.regisTime = regisTime;
		this.recentUpdateTime = recentUpdateTime;
		this.recentUpdateUserNo = recentUpdateUserNo;
	}
	public int getProductNo() {
		return productNo;
	}
	public void setProductNo(int productNo) {
		this.productNo = productNo;
	}
	public int getUserNo() {
		return userNo;
	}
	public void setUserNo(int userNo) {
		this.userNo = userNo;
	}
	public int getCategoryNo() {
		return categoryNo;
	}
	public void setCategoryNo(int categoryNo) {
		this.categoryNo = categoryNo;
	}
	public String getName() {
		return name;
	}
	public void setName(String name) {
		this.name = name;
	}
	public int getBasicPrice() {
		return basicPrice;
	}
	public void setBasicPrice(int basicPrice) {
		this.basicPrice = basicPrice;
	}
	public int getStat() {
		return stat;
	}
	public void setStat(int stat) {
		this.stat = stat;
	}
	public String getDetails() {
		return details;
	}
	public void setDetails(String details) {
		this.details = details;
	}
	public int getOpTotalNum() {
		return opTotalNum;
	}
	public void setOpTotalNum(int opTotalNum) {
		this.opTotalNum = opTotalNum;
	}
	public String getRegisTime() {
		return regisTime;
	}
	public void setRegisTime(String regisTime) {
		this.regisTime = regisTime;
	}
	public String getRecentUpdateTime() {
		return recentUpdateTime;
	}
	public void setRecentUpdateTime(String recentUpdateTime) {
		this.recentUpdateTime = recentUpdateTime;
	}
	public int getRecentUpdateUserNo() {
		return recentUpdateUserNo;
	}
	public void setRecentUpdateUserNo(int recentUpdateUserNo) {
		this.recentUpdateUserNo = recentUpdateUserNo;
	}
	@Override
	public String toString() {
		StringBuilder builder = new StringBuilder();
		builder.append("ProductVo [productNo=");
		builder.append(productNo);
		builder.append(", userNo=");
		builder.append(userNo);
		builder.append(", categoryNo=");
		builder.append(categoryNo);
		builder.append(", name=");
		builder.append(name);
		builder.append(", basicPrice=");
		builder.append(basicPrice);
		builder.append(", stat=");
		builder.append(stat);
		builder.append(", details=");
		builder.append(details);
		builder.append(", opTotalNum=");
		builder.append(opTotalNum);
		builder.append(", regisTime=");
		builder.append(regisTime);
		builder.append(", recentUpdateTime=");
		builder.append(recentUpdateTime);
		builder.append(", recentUpdateUserNo=");
		builder.append(recentUpdateUserNo);
		builder.append("]");
		return builder.toString();
	}
	
	


	
}
