package hwst.domain.product;

import java.util.Date;

import org.apache.commons.lang.builder.ToStringBuilder;
import org.apache.commons.lang.builder.ToStringStyle;


public class ProductVo{
	private int productNo;
	private int userNo;
	private int categoryNo;
	private String name;
	private int basicPrice;
	private int stat;
	private String details;
	private int opTotalNum;
	private Date regisTime;
	private Date recentUpdateTime;
	private int recentUpdateUserNo;
	
	public ProductVo(){}
	public ProductVo(int productNo, int userNo, int categoryNo, String name,
			int basicPrice, int stat, String details, int opTotalNum,
			Date regisTime, Date recentUpdateTime, int recentUpdateUserNo) {
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
	public Date getRegisTime() {
		return regisTime;
	}
	public void setRegisTime(Date regisTime) {
		this.regisTime = regisTime;
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
	
	@Override
	public String toString() {
		return ToStringBuilder.reflectionToString(
				this, ToStringStyle.MULTI_LINE_STYLE
				);
	}
	
}
