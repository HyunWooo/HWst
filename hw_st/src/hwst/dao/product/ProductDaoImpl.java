package hwst.dao.product;

import hwst.domain.product.ProductVo;

import java.util.List;

import org.apache.ibatis.session.SqlSession;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

@Repository("productDao")
public class ProductDaoImpl  implements ProductDao {

	@Autowired
	private SqlSession sqlSession;
	
	
	//전체상품조회
	@Override
	public List<ProductVo> selectProductAll() {
		return sqlSession.selectList("product.selectProductAll");
	}
	 
	//전체상품 최저가조회
	@Override
	public List<ProductVo> selectPrdLow() {
		return sqlSession.selectList("product.selectPrdLow");
	}
		
	//전체상품 키워드검색
	@Override
	public List<ProductVo> selectProductByKeyword(String keyword) {
		return sqlSession.selectList("product.selectProductByKeyword", keyword);
	}
	
	//전체상품 카테고리별 검색
	@Override
	public List<ProductVo> selectProductByCategory(int categoryNo) {
		return sqlSession.selectList("product.selectProductByCategory", categoryNo);
	}
	
	//상품상세정보 조회
	@Override
	public ProductVo selectProductDetails(int productNo) {
		return sqlSession.selectOne("product.selectProductDetails", productNo);
	}

	//상품상세정보 조회
	@Override
	public int selectProductNo(ProductVo prdVo) {
		return sqlSession.selectOne("product.selectProductNo", prdVo);
	}
	//상품 추가
	@Override
	public int insertPrd(ProductVo prdVo) {
		return sqlSession.insert("product.insertPrd", prdVo);
	}
}
