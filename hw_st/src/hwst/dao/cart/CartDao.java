package hwst.dao.cart;

import hwst.domain.cart.CartVo;

import java.sql.SQLException;
import java.util.List;

public interface CartDao {
	List<CartVo> selectCartAll(int userNo) throws SQLException;
	int insertCart(CartVo cVo) throws SQLException;
	int deleteCart(int cartNo) throws SQLException;
	int updateCartAmount(CartVo cartVo) throws SQLException;
	List<CartVo> selectCartInfo(List<Integer> cartNo) throws SQLException;
	int deleteCartOrder(List<Integer> deletedCart) throws Exception;
	
	
}