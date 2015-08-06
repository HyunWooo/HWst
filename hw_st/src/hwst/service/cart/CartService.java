package hwst.service.cart;

import hwst.domain.cart.CartVo;

import java.util.List;
import java.util.Map;

public interface CartService {

	List<CartVo> selectCartAll(int userNo) throws Exception;
	boolean insertCart(List<Integer> productOptionNo,int userNo,List<Integer> buyAmount)throws Exception;
	boolean deleteCart(int cartNo) throws Exception;
	boolean updateCartAmount(CartVo cartVo) throws Exception;
	Map<String, Object> selectCartInfo(List<Integer> cartNo) throws Exception;

	
}
