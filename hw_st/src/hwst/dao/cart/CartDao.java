package hwst.dao.cart;

import hwst.domain.cart.CartVo;
import hwst.domain.product.ProductOptionVo;

import java.sql.SQLException;
import java.util.List;

public interface CartDao {
	List<CartVo> selectCartAll(int userNo) throws SQLException;
	int insertCart(CartVo cVo) throws SQLException;
	int deleteCart(int cartNo) throws SQLException;
	int updateCartAmountByCartNo(CartVo cartVo) throws SQLException;
	List<CartVo> selectCartBySelectedCartList(List<Integer> cartNo) throws SQLException;
	int deleteCartByOrderComplete(ProductOptionVo productOptionVo) throws Exception;
	
	
}