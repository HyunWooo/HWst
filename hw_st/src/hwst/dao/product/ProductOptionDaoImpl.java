package hwst.dao.product;

import hwst.domain.product.ProductOptionVo;
import hwst.util.DBUtil;

import java.util.List;

import org.apache.ibatis.session.SqlSession;
import org.springframework.stereotype.Repository;

@Repository("productOptionDao")
public class ProductOptionDaoImpl  implements ProductOptionDao {
	
	//해당상품의 상품옵션정보 조회
	@Override
	public List<ProductOptionVo> selectProductOptionAll(int productNo)throws Exception{
		SqlSession session = null;
		List<ProductOptionVo> list = null;
		try {
			session = DBUtil.getSqlSession();
			list = session.selectList("productOption.selectProductOptionAll",productNo);
		} finally {
			DBUtil.closeSqlSession(session);
		}
		return list;
	}
	
	//List타입의 상품옵션번호로 정보조회
	@Override
	public List<ProductOptionVo> selectPOByPoNo(List<Integer> productOptionNo)throws Exception{
		SqlSession session = null;
		List<ProductOptionVo> list = null;
		try {
			session = DBUtil.getSqlSession();
			list = session.selectList("productOption.selectPOByPoNo",productOptionNo);
		} finally {
			DBUtil.closeSqlSession(session);
		}
		return list;
	}
	
		//해당OrderNo의 주문수량을 해당상품재고에서 차감
		@Override
		public int udtPrdAmount(ProductOptionVo productOptionVo)throws Exception{
			SqlSession session = null;
			int stat = 0;
			try {
				session = DBUtil.getSqlSession();
				stat = session.update("productOption.udtPrdAmount",productOptionVo);
			} finally {
				DBUtil.closeSqlSession(session);
			}
			return stat;
		}
}
