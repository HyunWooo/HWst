package hwst.dao.cart;

import hwst.domain.cart.CartVo;
import hwst.domain.product.ProductOptionVo;
import hwst.util.DBUtil;

import java.sql.SQLException;
import java.util.List;

import org.apache.ibatis.session.SqlSession;
import org.apache.log4j.Logger;
import org.springframework.stereotype.Repository;

@Repository("cartDao")
public class CartDaoImpl implements CartDao {
	
	Logger logger = Logger.getLogger(this.getClass());

	//회원별 모든장바구니정보 보기
	@Override
	public List<CartVo> selectCartAll(int userNo) throws SQLException{
		SqlSession session = null;
		List<CartVo> list = null;
		try {
			session = DBUtil.getSqlSession();
			list = session.selectList("cart.selectCartAll", userNo);
		} finally {
			DBUtil.closeSqlSession(session);
		}
		return list;
	}
	
	//장바구니에서 선택된 장바구니 or 전체선택된 장바구니의 정보 select 
	@Override
	public List<CartVo> selectCartBySelectedCartList(List<Integer> cartNo)throws SQLException{
		SqlSession session = null;
		List<CartVo> list = null;
		try {
			session = DBUtil.getSqlSession();
			list = session.selectList("cart.selectCartBySelectedCartList", cartNo);
			System.out.println(list);
		} finally {
			DBUtil.closeSqlSession(session);
		}
		return list;
	}
	

	//장바구니항목 추가
	@Override
	public int insertCart(CartVo cVo) throws SQLException{
		SqlSession session = null;
		int stat = 0;
		try {
			session = DBUtil.getSqlSession();
			stat = session.insert("cart.insertCart",cVo);
		} finally {
			DBUtil.closeSqlSession(session);
		}
		return stat;
	}

	//장바구니항목 삭제
	@Override
	public int deleteCart(int cartNo)throws SQLException{
		SqlSession session = null;
		int stat = 0;
		try {
			session = DBUtil.getSqlSession();
			stat = session.delete("cart.deleteCart",cartNo);
		} finally {
			DBUtil.closeSqlSession(session);
		}
		return stat;
	}
	
	//장바구니항목 수량 수정
	@Override
	public int updateCartAmountByCartNo(CartVo cartVo)throws SQLException{
		SqlSession session = null;
		int stat = 0;
		try {
			session = DBUtil.getSqlSession();
			stat = session.update("cart.updateCartAmountByCartNo",cartVo);
		} finally {
			DBUtil.closeSqlSession(session);
		}
		return stat;
	}
	
	@Override
	public int deleteCartByOrderComplete(ProductOptionVo productOptionVo)throws Exception{
		SqlSession session = null;
		int stat = 0;
		try {
			session = DBUtil.getSqlSession();
			stat = session.delete("cart.deleteCartByOrderComplete",productOptionVo);
		} finally {
			DBUtil.closeSqlSession(session);
		}
		return stat;
	}
	
}
