package hwst.domain.category;

import java.io.Serializable;

import org.apache.commons.lang.builder.ToStringBuilder;
import org.apache.commons.lang.builder.ToStringStyle;

public class CategoryVo implements Serializable {

	/**
	 * 
	 */
	private static final long serialVersionUID = -6125819855024933998L;
	
	private int categoryNo;
	private int upCategoryNo;
	private String categoryName;
	private String recentUpdateTime;
	private int recentUpdateUserNo;
	private String upCategoryName;
	
	
	public CategoryVo(){}
	public CategoryVo(int categoryNo, int upCategoryNo, String categoryName,
			String recentUpdateTime, int recentUpdateUserNo, String upCategoryName) {
		super();
		this.categoryNo = categoryNo;
		this.upCategoryNo = upCategoryNo;
		this.categoryName = categoryName;
		this.recentUpdateTime = recentUpdateTime;
		this.recentUpdateUserNo = recentUpdateUserNo;
		this.upCategoryName = upCategoryName;
	}
	public int getCategoryNo() {
		return categoryNo;
	}
	public void setCategoryNo(int categoryNo) {
		this.categoryNo = categoryNo;
	}
	public int getUpCategoryNo() {
		return upCategoryNo;
	}
	public void setUpCategoryNo(int upCategoryNo) {
		this.upCategoryNo = upCategoryNo;
	}
	public String getCategoryName() {
		return categoryName;
	}
	public void setCategoryName(String categoryName) {
		this.categoryName = categoryName;
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
	public String getUpCategoryName() {
		return upCategoryName;
	}
	public void setUpCategoryName(String upCategoryName) {
		this.upCategoryName = upCategoryName;
	}
	
	
	@Override
	public String toString() {
		return ToStringBuilder.reflectionToString(
				this, ToStringStyle.MULTI_LINE_STYLE
				);
	}
	
	
}
