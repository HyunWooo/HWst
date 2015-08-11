package hwst.dao.cart;

import hwst.domain.cart.CartVo;

import java.util.List;

public interface CartDao {
	List<CartVo> selectCartAll(int userNo);
	int insertCart(CartVo cVo);
	int deleteCart(int cartNo);
	int updateCartAmount(CartVo cartVo);
	List<CartVo> selectCartInfo(List<Integer> cartNo);
	int deleteCartOrder(List<Integer> deletedCart);
	
}