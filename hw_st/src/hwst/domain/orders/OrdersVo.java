package hwst.domain.orders;

import java.util.Date;

public class OrdersVo {
	private int orderNo;
	private int userNo;
	private Date orderTime;
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
	private Date recentUpdateTime;
	private int recentUpdateUserNo;
	private int productOptionNo;
	private String productOptionName;
	private int productNo;
	private String name;
	private int buyAmount;
	private int totalPrice;
	private int categoryNo;
	private int orderNoCount;
	private int productStat;
	private int deliveryStat;
	private int productAmount;
	private String userName;
	private String id;
	private int quantityCheck;
	
	public OrdersVo(){}
	
	public OrdersVo(int orderNo, int orderStat){
		this.orderNo = orderNo;
		this.orderStat = orderStat;
	}
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

	
	public OrdersVo(int orderNo, int userNo, Date orderTime,
			String receiverName, String phone, String postCode, String address,
			String message, int grade, int orderStat, String allTotalPrice,
			String discountPrice, String discountedTotalPrice,
			Date recentUpdateTime, int recentUpdateUserNo, int productOptionNo,
			String productOptionName, int productNo, String name,
			int buyAmount, int totalPrice, int categoryNo, int orderNoCount,
			int productStat, int deliveryStat, int productAmount,
			String userName, String id, int quantityCheck) {
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
		this.productOptionNo = productOptionNo;
		this.productOptionName = productOptionName;
		this.productNo = productNo;
		this.name = name;
		this.buyAmount = buyAmount;
		this.totalPrice = totalPrice;
		this.categoryNo = categoryNo;
		this.orderNoCount = orderNoCount;
		this.productStat = productStat;
		this.deliveryStat = deliveryStat;
		this.productAmount = productAmount;
		this.userName = userName;
		this.id = id;
		this.quantityCheck = quantityCheck;
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

	public Date getOrderTime() {
		return orderTime;
	}

	public void setOrderTime(Date orderTime) {
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
	
	

	public int getProductOptionNo() {
		return productOptionNo;
	}

	public void setProductOptionNo(int productOptionNo) {
		this.productOptionNo = productOptionNo;
	}

	public String getProductOptionName() {
		return productOptionName;
	}

	public void setProductOptionName(String productOptionName) {
		this.productOptionName = productOptionName;
	}

	public int getProductNo() {
		return productNo;
	}

	public void setProductNo(int productNo) {
		this.productNo = productNo;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public int getBuyAmount() {
		return buyAmount;
	}

	public void setBuyAmount(int buyAmount) {
		this.buyAmount = buyAmount;
	}

	public int getTotalPrice() {
		return totalPrice;
	}

	public void setTotalPrice(int totalPrice) {
		this.totalPrice = totalPrice;
	}

	public int getCategoryNo() {
		return categoryNo;
	}

	public void setCategoryNo(int categoryNo) {
		this.categoryNo = categoryNo;
	}
	
	

	public int getOrderNoCount() {
		return orderNoCount;
	}

	public void setOrderNoCount(int orderNoCount) {
		this.orderNoCount = orderNoCount;
	}

	
	public int getProductStat() {
		return productStat;
	}

	public void setProductStat(int productStat) {
		this.productStat = productStat;
	}

	public int getDeliveryStat() {
		return deliveryStat;
	}

	public void setDeliveryStat(int deliveryStat) {
		this.deliveryStat = deliveryStat;
	}
	
	

	public int getProductAmount() {
		return productAmount;
	}

	public void setProductAmount(int productAmount) {
		this.productAmount = productAmount;
	}

	public String getUserName() {
		return userName;
	}

	public void setUserName(String userName) {
		this.userName = userName;
	}

	public String getId() {
		return id;
	}

	public void setId(String id) {
		this.id = id;
	}

	

	public int getQuantityCheck() {
		return quantityCheck;
	}

	public void setQuantityCheck(int quantityCheck) {
		this.quantityCheck = quantityCheck;
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
		builder.append(", productOptionNo=");
		builder.append(productOptionNo);
		builder.append(", productOptionName=");
		builder.append(productOptionName);
		builder.append(", productNo=");
		builder.append(productNo);
		builder.append(", name=");
		builder.append(name);
		builder.append(", buyAmount=");
		builder.append(buyAmount);
		builder.append(", totalPrice=");
		builder.append(totalPrice);
		builder.append(", categoryNo=");
		builder.append(categoryNo);
		builder.append(", orderNoCount=");
		builder.append(orderNoCount);
		builder.append(", productStat=");
		builder.append(productStat);
		builder.append(", deliveryStat=");
		builder.append(deliveryStat);
		builder.append(", productAmount=");
		builder.append(productAmount);
		builder.append(", userName=");
		builder.append(userName);
		builder.append(", id=");
		builder.append(id);
		builder.append(", quantityCheck=");
		builder.append(quantityCheck);
		builder.append("]");
		return builder.toString();
	}






}