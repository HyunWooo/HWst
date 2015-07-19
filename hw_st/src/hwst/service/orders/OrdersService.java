package hwst.service.orders;

import java.util.List;

public interface OrdersService {

	boolean insertOrders(List<Integer> productOptionNo, List<Integer> buyAmount,
					List<Integer> totalPrice, String receiverName, String phone,
					String postCode, String address, int checkoutInfo, int userNo,
					int grade, String message, String allTotalPrice,
					String discountPrice, String discountedTotalPrice) throws Exception;
	
	
}
