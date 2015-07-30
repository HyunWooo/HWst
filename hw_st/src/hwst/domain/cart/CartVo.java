package hwst.domain.cart;



public class CartVo {

		private int cartNo;
		private int productOptionNo;
		private int userNo;
		private int buyAmount;
		private String cartTime;
		private int categoryNo;
		private int productNo;
		private String name;
		private String productOptionName;
		private int productAmount;
		private int addPrice;
		private int basicPrice;
		private int eachPrice;
		
		
		public CartVo(){}
		
		public CartVo(int cartNo, int buyAmount) {
			this.cartNo = cartNo;
			this.buyAmount = buyAmount;
		}
		
		public CartVo(int productOptionNo, int userNo, int buyAmount) {
			this.productOptionNo = productOptionNo;
			this.userNo = userNo;
			this.buyAmount = buyAmount;
		}

		public CartVo(int cartNo, int productOptionNo, int userNo, int buyAmount,
				String cartTime, int categoryNo, int productNo, String name, String productOptionName,
				int productAmount, int addPrice, int basicPrice, int eachPrice) {
			super();
			this.cartNo = cartNo;
			this.productOptionNo = productOptionNo;
			this.userNo = userNo;
			this.buyAmount = buyAmount;
			this.cartTime = cartTime;
			this.categoryNo = categoryNo;
			this.productNo = productNo;
			this.name = name;
			this.productOptionName = productOptionName;
			this.productAmount = productAmount;
			this.addPrice = addPrice;
			this.basicPrice = basicPrice;
			this.eachPrice = eachPrice;
		}

		public int getCartNo() {
			return cartNo;
		}

		public void setCartNo(int cartNo) {
			this.cartNo = cartNo;
		}

		public int getProductOptionNo() {
			return productOptionNo;
		}

		public void setProductOptionNo(int productOptionNo) {
			this.productOptionNo = productOptionNo;
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
		
		public void setBuyAmount(CartVo cart1, CartVo cart2) {
			int buyAmount = cart1.getBuyAmount() + cart2.getBuyAmount();
			this.buyAmount = buyAmount;
		}

		public String getCartTime() {
			return cartTime;
		}

		public void setCartTime(String cartTime) {
			this.cartTime = cartTime;
		}
		
		public int getCategoryNo() {
			return categoryNo;
		}

		public void setCategoryNo(int categoryNo) {
			this.categoryNo = categoryNo;
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

		public String getProductOptionName() {
			return productOptionName;
		}

		public void setProductOptionName(String productOptionName) {
			this.productOptionName = productOptionName;
		}

		public int getProductAmount() {
			return productAmount;
		}

		public void setProductAmount(int productAmount) {
			this.productAmount = productAmount;
		}

		public int getAddPrice() {
			return addPrice;
		}

		public void setAddPrice(int addPrice) {
			this.addPrice = addPrice;
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
			builder.append("CartVo [cartNo=");
			builder.append(cartNo);
			builder.append(", productOptionNo=");
			builder.append(productOptionNo);
			builder.append(", userNo=");
			builder.append(userNo);
			builder.append(", buyAmount=");
			builder.append(buyAmount);
			builder.append(", cartTime=");
			builder.append(cartTime);
			builder.append(", categoryNo=");
			builder.append(categoryNo);
			builder.append(", productNo=");
			builder.append(productNo);
			builder.append(", name=");
			builder.append(name);
			builder.append(", productOptionName=");
			builder.append(productOptionName);
			builder.append(", productAmount=");
			builder.append(productAmount);
			builder.append(", addPrice=");
			builder.append(addPrice);
			builder.append(", basicPrice=");
			builder.append(basicPrice);
			builder.append(", eachPrice=");
			builder.append(eachPrice);
			builder.append("]");
			return builder.toString();
		}

	



}
