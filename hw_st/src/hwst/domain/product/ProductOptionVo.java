package hwst.domain.product;

import java.util.Date;


public class ProductOptionVo extends ProductVo{
	private int productOptionNo;
	private int productNo;
	private int optionProcedure;
	private int addPrice;
	private int productAmount;
	private String productOptionName;
	private int optionStat;
	private Date recentUpdateTime;
	private int recentUpdateUserNo;
	private int userNo;
	private int categoryNo;
	private int buyAmount;
	private String name;
	private int basicPrice;
	private int eachPrice;
	private int productNoCount;
	
	
	public ProductOptionVo(){}
	
	public ProductOptionVo(int productOptionNo, int userNo){
		this.productOptionNo = productOptionNo;
		this.userNo = userNo;
	}
	
	public ProductOptionVo(int productNo, String productOptionName, int optionProcedure, int addPrice,
			int productAmount, int optionStat, int userNo) {
		super();
		this.productNo = productNo;
		this.optionProcedure = optionProcedure;
		this.addPrice = addPrice;
		this.productAmount = productAmount;
		this.productOptionName = productOptionName;
		this.optionStat = optionStat;
		this.userNo = userNo;
	}

	public ProductOptionVo(int productOptionNo, int productNo,
			int optionProcedure, int addPrice, int productAmount,
			String productOptionName, int optionStat, Date recentUpdateTime,
			int recentUpdateUserNo, int buyAmount, int categoryNo, String name, int basicPrice, int eachPrice, int productNoCount) {
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
		this.buyAmount = buyAmount;
		this.categoryNo = categoryNo;
		this.name = name;
		this.basicPrice = basicPrice;
		this.eachPrice = eachPrice;
		this.productNoCount = productNoCount;
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
	
	
	public int getProductNoCount() {
		return productNoCount;
	}

	public void setProductNoCount(int productNoCount) {
		this.productNoCount = productNoCount;
	}

	public Date getRecentUpdateTime() {
		return recentUpdateTime;
	}
	public void setRecentUpdateTime(Date recentUpdateTime) {
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

	
	public int getBuyAmount() {
		return buyAmount;
	}

	public void setBuyAmount(int buyAmount) {
		this.buyAmount = buyAmount;
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

	public int getEachPrice() {
		return eachPrice;
	}

	public void setEachPrice(int eachPrice) {
		this.eachPrice = eachPrice;
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
		builder.append(", userNo=");
		builder.append(userNo);
		builder.append(", categoryNo=");
		builder.append(categoryNo);
		builder.append(", buyAmount=");
		builder.append(buyAmount);
		builder.append(", name=");
		builder.append(name);
		builder.append(", basicPrice=");
		builder.append(basicPrice);
		builder.append(", eachPrice=");
		builder.append(eachPrice);
		builder.append(", productNoCount=");
		builder.append(productNoCount);
		builder.append(", getStat()=");
		builder.append(getStat());
		builder.append(", getDetails()=");
		builder.append(getDetails());
		builder.append(", getOpTotalNum()=");
		builder.append(getOpTotalNum());
		builder.append(", getRegisTime()=");
		builder.append(getRegisTime());
		builder.append("]");
		return builder.toString();
	}


	


	
	
	
}
