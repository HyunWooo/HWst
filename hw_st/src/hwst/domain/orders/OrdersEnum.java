package hwst.domain.orders;

public class OrdersEnum {

	public enum OrderStat{
		DELETEDORDER(1),
		DEPOSITWATING(2),
		COMPLETEPAYMENT(3), 
		DELIVERYREADY(4),
		DELIVERING(5),
		DELIVERYALLCOMPLETE(6),
		SELLINGPRICEREFUND(7);
		
		
		private int value;
 
        private OrderStat(int value) {
                this.value = value;
        }

		public int getValue() {
			return value;
		}
	}
	
	public enum DeliveryStat{
		DISPATCHREADY(1),
		DELIVERING(2),
		DELIVERYALLCOMPLETE(3);
		
		private int value;
 
        private DeliveryStat(int value) {
                this.value = value;
        }

		public int getValue() {
			return value;
		}
	}
}
