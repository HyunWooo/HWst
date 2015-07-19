package hwst.domain.orders;

public class OrdersVo {
	private int orderNo;
	private int userNo;
	private String orderTime;
	private String receiverName;
	private String phone;
	private String postCode;
	private String address;
	private String message;
	private int grade;
	private int orderStat;	
	private String allTotalPrice;
	private String discountPrice;
	private String discountedTotalPrice;
	private String recentUpdateTime;
	private int recentUpdateUserNo;
	
	public OrdersVo(){}
	
	public OrdersVo(int userNo, String receiverName, String phone, String postCode, String address, String message, int grade, String allTotalPrice, String discountPrice, String discountedTotalPrice){
		this.userNo = userNo;
		this.receiverName = receiverName;
		this.phone = phone;
		this.postCode = postCode;
		this.address = address;
		this.message = message;
		this.grade = grade;
		this.allTotalPrice = allTotalPrice;
		this.discountPrice = discountPrice;
		this.discountedTotalPrice = discountedTotalPrice;
	}

	public OrdersVo(int orderNo, int userNo, String orderTime,
			String receiverName, String phone, String postCode, String address,
			String message, int grade, int orderStat, String allTotalPrice,
			String discountPrice, String discountedTotalPrice,
			String recentUpdateTime, int recentUpdateUserNo) {
		super();
		this.orderNo = orderNo;
		this.userNo = userNo;
		this.orderTime = orderTime;
		this.receiverName = receiverName;
		this.phone = phone;
		this.postCode = postCode;
		this.address = address;
		this.message = message;
		this.grade = grade;
		this.orderStat = orderStat;
		this.allTotalPrice = allTotalPrice;
		this.discountPrice = discountPrice;
		this.discountedTotalPrice = discountedTotalPrice;
		this.recentUpdateTime = recentUpdateTime;
		this.recentUpdateUserNo = recentUpdateUserNo;
	}

	public int getOrderNo() {
		return orderNo;
	}

	public void setOrderNo(int orderNo) {
		this.orderNo = orderNo;
	}

	public int getUserNo() {
		return userNo;
	}

	public void setUserNo(int userNo) {
		this.userNo = userNo;
	}

	public String getOrderTime() {
		return orderTime;
	}

	public void setOrderTime(String orderTime) {
		this.orderTime = orderTime;
	}

	public String getReceiverName() {
		return receiverName;
	}

	public void setReceiverName(String receiverName) {
		this.receiverName = receiverName;
	}

	public String getPhone() {
		return phone;
	}

	public void setPhone(String phone) {
		this.phone = phone;
	}

	public String getPostCode() {
		return postCode;
	}

	public void setPostCode(String postCode) {
		this.postCode = postCode;
	}

	public String getAddress() {
		return address;
	}

	public void setAddress(String address) {
		this.address = address;
	}

	public String getMessage() {
		return message;
	}

	public void setMessage(String message) {
		this.message = message;
	}

	public int getGrade() {
		return grade;
	}

	public void setGrade(int grade) {
		this.grade = grade;
	}

	public int getOrderStat() {
		return orderStat;
	}

	public void setOrderStat(int orderStat) {
		this.orderStat = orderStat;
	}

	public String getAllTotalPrice() {
		return allTotalPrice;
	}

	public void setAllTotalPrice(String allTotalPrice) {
		this.allTotalPrice = allTotalPrice;
	}

	public String getDiscountPrice() {
		return discountPrice;
	}

	public void setDiscountPrice(String discountPrice) {
		this.discountPrice = discountPrice;
	}

	public String getDiscountedTotalPrice() {
		return discountedTotalPrice;
	}

	public void setDiscountedTotalPrice(String discountedTotalPrice) {
		this.discountedTotalPrice = discountedTotalPrice;
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
		builder.append("OrdersVo [orderNo=");
		builder.append(orderNo);
		builder.append(", userNo=");
		builder.append(userNo);
		builder.append(", orderTime=");
		builder.append(orderTime);
		builder.append(", receiverName=");
		builder.append(receiverName);
		builder.append(", phone=");
		builder.append(phone);
		builder.append(", postCode=");
		builder.append(postCode);
		builder.append(", address=");
		builder.append(address);
		builder.append(", message=");
		builder.append(message);
		builder.append(", grade=");
		builder.append(grade);
		builder.append(", orderStat=");
		builder.append(orderStat);
		builder.append(", allTotalPrice=");
		builder.append(allTotalPrice);
		builder.append(", discountPrice=");
		builder.append(discountPrice);
		builder.append(", discountedTotalPrice=");
		builder.append(discountedTotalPrice);
		builder.append(", recentUpdateTime=");
		builder.append(recentUpdateTime);
		builder.append(", recentUpdateUserNo=");
		builder.append(recentUpdateUserNo);
		builder.append("]");
		return builder.toString();
	}

}