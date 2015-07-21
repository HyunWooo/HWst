package hwst.domain.orders;

import java.util.Date;

public class OrderProductVo extends OrdersVo{
	private int orderNo;
	private int productOptionNo;
	private int buyAmount;
	private int totalPrice;
	private int productStat;
	private int deliveryStat;
	private Date deliveryDate;
	private Date recentUpdateTime;
	private int recentUpdateUserNo;
	
	public OrderProductVo(){}
	
	public OrderProductVo(int orderNo, int productOptionNo, int deliveryStat){
		this.orderNo = orderNo;
		this.productOptionNo = productOptionNo;
		this.deliveryStat = deliveryStat;
	}
	
	public OrderProductVo(int orderNo, int productOptionNo, int buyAmount, int totalPrice, int recentUpdateUserNo){
		this.orderNo = orderNo;
		this.productOptionNo = productOptionNo;
		this.buyAmount = buyAmount;
		this.totalPrice = totalPrice;
		this.recentUpdateUserNo = recentUpdateUserNo;
	}

	public OrderProductVo(int orderNo, int productOptionNo, int buyAmount,
			int totalPrice, int productStat, int deliveryStat,
			Date deliveryDate, Date recentUpdateTime, int recentUpdateUserNo) {
		super();
		this.orderNo = orderNo;
		this.productOptionNo = productOptionNo;
		this.buyAmount = buyAmount;
		this.totalPrice = totalPrice;
		this.productStat = productStat;
		this.deliveryStat = deliveryStat;
		this.deliveryDate = deliveryDate;
		this.recentUpdateTime = recentUpdateTime;
		this.recentUpdateUserNo = recentUpdateUserNo;
	}

	public int getOrderNo() {
		return orderNo;
	}

	public void setOrderNo(int orderNo) {
		this.orderNo = orderNo;
	}

	public int getProductOptionNo() {
		return productOptionNo;
	}

	public void setProductOptionNo(int productOptionNo) {
		this.productOptionNo = productOptionNo;
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

	public Date getDeliveryDate() {
		return deliveryDate;
	}

	public void setDeliveryDate(Date deliveryDate) {
		this.deliveryDate = deliveryDate;
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
		StringBuilder builder = new StringBuilder();
		builder.append("OrderProductVo [orderNo=");
		builder.append(orderNo);
		builder.append(", productOptionNo=");
		builder.append(productOptionNo);
		builder.append(", buyAmount=");
		builder.append(buyAmount);
		builder.append(", totalPrice=");
		builder.append(totalPrice);
		builder.append(", productStat=");
		builder.append(productStat);
		builder.append(", deliveryStat=");
		builder.append(deliveryStat);
		builder.append(", deliveryDate=");
		builder.append(deliveryDate);
		builder.append(", recentUpdateTime=");
		builder.append(recentUpdateTime);
		builder.append(", recentUpdateUserNo=");
		builder.append(recentUpdateUserNo);
		builder.append("]");
		return builder.toString();
	}

}