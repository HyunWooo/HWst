package hwst.domain.product;


public class ProductOptionVo{
	private int productOptionNo;
	private int productNo;
	private int optionProcedure;
	private int addPrice;
	private int productAmount;
	private String productOptionName;
	private int optionStat;
	private String recentUpdateTime;
	private int recentUpdateUserNo;
	private int userNo;
	
	public ProductOptionVo(){}
	
	public ProductOptionVo(int productOptionNo, int userNo){
		this.productOptionNo = productOptionNo;
		this.userNo = userNo;
	}
	
	public ProductOptionVo(int productOptionNo, int productNo,
			int optionProcedure, int addPrice, int productAmount,
			String productOptionName, int optionStat, String recentUpdateTime,
			int recentUpdateUserNo) {
		super();
		this.productOptionNo = productOptionNo;
		this.productNo = productNo;
		this.optionProcedure = optionProcedure;
		this.addPrice = addPrice;
		this.productAmount = productAmount;
		this.productOptionName = productOptionName;
		this.optionStat = optionStat;
		this.recentUpdateTime = recentUpdateTime;
		this.recentUpdateUserNo = recentUpdateUserNo;
	}
	public int getProductOptionNo() {
		return productOptionNo;
	}
	public void setProductOptionNo(int productOptionNo) {
		this.productOptionNo = productOptionNo;
	}
	public int getProductNo() {
		return productNo;
	}
	public void setProductNo(int productNo) {
		this.productNo = productNo;
	}
	public int getOptionProcedure() {
		return optionProcedure;
	}
	public void setOptionProcedure(int optionProcedure) {
		this.optionProcedure = optionProcedure;
	}
	public int getAddPrice() {
		return addPrice;
	}
	public void setAddPrice(int addPrice) {
		this.addPrice = addPrice;
	}
	public int getProductAmount() {
		return productAmount;
	}
	public void setProductAmount(int productAmount) {
		this.productAmount = productAmount;
	}
	public String getProductOptionName() {
		return productOptionName;
	}
	public void setProductOptionName(String productOptionName) {
		this.productOptionName = productOptionName;
	}
	public int getOptionStat() {
		return optionStat;
	}
	public void setOptionStat(int optionStat) {
		this.optionStat = optionStat;
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
	
	public int getUserNo() {
		return userNo;
	}

	public void setUserNo(int userNo) {
		this.userNo = userNo;
	}

	@Override
	public String toString() {
		StringBuilder builder = new StringBuilder();
		builder.append("ProductOptionVo [productOptionNo=");
		builder.append(productOptionNo);
		builder.append(", productNo=");
		builder.append(productNo);
		builder.append(", optionProcedure=");
		builder.append(optionProcedure);
		builder.append(", addPrice=");
		builder.append(addPrice);
		builder.append(", productAmount=");
		builder.append(productAmount);
		builder.append(", productOptionName=");
		builder.append(productOptionName);
		builder.append(", optionStat=");
		builder.append(optionStat);
		builder.append(", recentUpdateTime=");
		builder.append(recentUpdateTime);
		builder.append(", recentUpdateUserNo=");
		builder.append(recentUpdateUserNo);
		builder.append("]");
		return builder.toString();
	}

	
	
	
}
