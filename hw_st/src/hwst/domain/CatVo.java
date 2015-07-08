package hwst.domain;

public class CatVo {

	private int catCode;
	private int upCatCode;
	private String catName;
	
	
	public CatVo(){}
	
	public CatVo(int catCode, int upCatCode, String catName) {
		super();
		this.catCode = catCode;
		this.upCatCode = upCatCode;
		this.catName = catName;
	}


	public int getCatCode() {
		return catCode;
	}


	public void setCatCode(int catCode) {
		this.catCode = catCode;
	}


	public int getUpCatCode() {
		return upCatCode;
	}


	public void setUpCatCode(int upCatCode) {
		this.upCatCode = upCatCode;
	}


	public String getCatName() {
		return catName;
	}


	public void setCatName(String catName) {
		this.catName = catName;
	}


	@Override
	public String toString() {
		StringBuilder builder = new StringBuilder();
		builder.append("CatVo [catCode=");
		builder.append(catCode);
		builder.append(", upCatCode=");
		builder.append(upCatCode);
		builder.append(", catName=");
		builder.append(catName);
		builder.append("]");
		return builder.toString();
	}
	
	
	
}
