package hwst.dao.product;

import hwst.domain.product.ProductVo;
import hwst.util.DBUtil;

import java.util.List;

import org.apache.ibatis.session.SqlSession;
import org.springframework.stereotype.Repository;

@Repository("productDao")
public class ProductDaoImpl  implements ProductDao {
	
	//전체상품조회
	@Override
	public List<ProductVo> selectProductAll() {
		SqlSession session = null;
		List<ProductVo> list = null;
		try {
			session = DBUtil.getSqlSession();
			list = session.selectList("product.selectProductAll");
		} finally {
			DBUtil.closeSqlSession(session);
		}
		return list;
	}
	
	//전체상품 최저가조회
		@Override
		public List<ProductVo> selectPrdLow() {
			SqlSession session = null;
			List<ProductVo> list = null;
			try {
				session = DBUtil.getSqlSession();
				list = session.selectList("product.selectPrdLow");
			} finally {
				DBUtil.closeSqlSession(session);
			}
			return list;
		}
		
	//전체상품 키워드검색
	@Override
	public List<ProductVo> selectProductByKeyword(String keyword) {
		SqlSession session = null;
		List<ProductVo> list = null;
		try {
			session = DBUtil.getSqlSession();
			list = session.selectList("product.selectProductByKeyword", keyword);
		} finally {
			DBUtil.closeSqlSession(session);
		}
		return list;
	}
	
	//전체상품 카테고리별 검색
	@Override
	public List<ProductVo> selectProductByCategory(int categoryNo) {
		SqlSession session = null;
		List<ProductVo> list = null;
		try {
			session = DBUtil.getSqlSession();
			list = session.selectList("product.selectProductByCategory", categoryNo);
		} finally {
			DBUtil.closeSqlSession(session);
		}
		return list;
	}
	
	//상품상세정보 조회
	@Override
	public ProductVo selectProductDetails(int productNo) {
		SqlSession session = null;
		ProductVo productVo = null;
		try {
			session = DBUtil.getSqlSession();
			productVo = session.selectOne("product.selectProductDetails", productNo);
		} finally {
			DBUtil.closeSqlSession(session);
		}
		return productVo;
	}

	//상품상세정보 조회
	@Override
	public int selectProductNo(ProductVo prdVo) {
		SqlSession session = null;
		int productNo = 0;
		try {
			session = DBUtil.getSqlSession();
			productNo = session.selectOne("product.selectProductNo", prdVo);
		} finally {
			DBUtil.closeSqlSession(session);
		}
		return productNo;
	}
	//상품 추가
	@Override
	public int insertPrd(ProductVo prdVo) {
		SqlSession session = null;
		int stat = 0;
		try {
			session = DBUtil.getSqlSession();
			stat = session.insert("product.insertPrd", prdVo);
		} finally {
			DBUtil.closeSqlSession(session);
		}
		return stat;
	}
}
