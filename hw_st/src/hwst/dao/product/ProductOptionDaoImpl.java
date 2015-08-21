package hwst.dao.product;

import hwst.domain.product.ProductOptionVo;

import java.util.List;
import java.util.Map;

import org.apache.ibatis.session.SqlSession;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

@Repository("productOptionDao")
public class ProductOptionDaoImpl  implements ProductOptionDao {
	
	@Autowired
	private SqlSession sqlSession;
	
	
	//해당상품의 활성화된 상품옵션정보 조회
	@Override
	public List<ProductOptionVo> selectProductOptionAll(int productNo){
		return sqlSession.selectList("productOption.selectProductOptionAll",productNo);
	}
	
	//해당상품의 활성화,비활성화된 모든 상품옵션정보 조회
	@Override
	public List<ProductOptionVo> selectPrdOpByPrdNo(int productNo){
		return sqlSession.selectList("productOption.selectPrdOpByPrdNo",productNo);
	}
	
	//List타입의 상품옵션번호로 정보조회
	@Override
	public List<ProductOptionVo> selectPOByPoNo(List<Integer> productOptionNo){
		return sqlSession.selectList("productOption.selectPOByPoNo",productOptionNo);
	}
	
	//Map타입으로 상품번호 그룹별 갯수를 받아옴
	@Override
	public Map<Integer, Integer> selectPrdGroupCount(int userNo){
		return sqlSession.selectMap("productOption.selectPrdGroupCount", userNo, "productNo");
	}
	
	//해당OrderNo의 주문수량을 해당상품재고에서 차감
	@Override
	public int udtPrdAmount(ProductOptionVo productOptionVo){
		return sqlSession.update("productOption.udtPrdAmount",productOptionVo);
	}
	
	//해당OrderNo의 주문수량을 해당상품재고에서 차감
	@Override
	public int udtPrdOpAll(ProductOptionVo prdOption){
		return sqlSession.update("productOption.udtPrdOpAll",prdOption);
	}
	
	//판매자별 등록상품정보 select
	@Override
	public List<ProductOptionVo> selectRegisterPrdAll(int userNo) {
		return sqlSession.selectList("productOption.selectRegisterPrdAll", userNo);
	}
	
	//상품옵션 추가
	@Override
	public int insertPrdOption(ProductOptionVo productOptionVo){
		return sqlSession.insert("productOption.insertPrdOption", productOptionVo);
	}
	
	//해당 상품옵션번호 삭제
	@Override
	public int delPrdOption(int productOptionNo){
		return sqlSession.delete("productOption.delPrdOption", productOptionNo);
	}
}
