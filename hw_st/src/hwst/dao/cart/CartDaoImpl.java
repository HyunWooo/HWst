package hwst.dao.cart;

import hwst.domain.cart.CartVo;

import java.util.List;

import org.apache.ibatis.session.SqlSession;
import org.apache.log4j.Logger;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

@Repository("cartDao")
public class CartDaoImpl implements CartDao{
	
	@Autowired
	private SqlSession sqlSession;
	Logger logger = Logger.getLogger(this.getClass());
	
	
	//회원별 모든장바구니정보 보기
	@Override
	public List<CartVo> selectCartAll(int userNo){
		return sqlSession.selectList("cart.selectCartAll", userNo);
		
	}
	
	//장바구니에서 선택된 장바구니 or 전체선택된 장바구니의 정보 select 
	@Override
	public List<CartVo> selectCartInfo(List<Integer> cartNo){
		return sqlSession.selectList("cart.selectCartInfo", cartNo);
	}
	

	//장바구니항목 추가
	@Override
	public int insertCart(CartVo cVo){
		return sqlSession.insert("cart.insertCart",cVo);
	}

	//장바구니항목 삭제
	@Override
	public int deleteCart(int cartNo){
		return sqlSession.delete("cart.deleteCart",cartNo);
	}
	
	//장바구니항목 수량 수정
	@Override
	public int updateCartAmount(CartVo cartVo){
		return sqlSession.update("cart.updateCartAmount",cartVo);
	}
	
	//장바구니에서 주문된 장바구니항목 삭제
	@Override
	public int deleteCartOrder(List<Integer> deletedCart){
		return sqlSession.delete("cart.deleteCartOrder", deletedCart);
	}
	
	
}
