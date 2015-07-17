package hwst.service.cart;

import hwst.domain.cart.CartVo;

import java.util.List;

public interface CartService {

	List<CartVo> selectCartAll(int userNo) throws Exception;
	boolean insertCart(List<Integer> productOptionNo,int userNo,List<Integer> buyAmount)throws Exception;
	boolean deleteCart(int cartNo) throws Exception;
	boolean updateCartAmountByCartNo(List<Integer> cartNo, List<Integer> buyAmount, int updateBuyAmountStat) throws Exception;
	List<CartVo> selectCartBySelectedCartList(List<Integer> cartNo) throws Exception;

	
}
