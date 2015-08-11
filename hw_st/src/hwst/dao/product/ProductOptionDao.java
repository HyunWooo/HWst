package hwst.dao.product;

import hwst.domain.product.ProductOptionVo;

import java.util.List;

public interface ProductOptionDao {
	List<ProductOptionVo> selectProductOptionAll(int productNo);
	List<ProductOptionVo> selectPOByPoNo(List<Integer> productOptionNo);
	List<ProductOptionVo> selectRegisterPrdAll(int userNo);
	List<ProductOptionVo> selectPrdNoGroupCnt(int userNo);
	int udtPrdAmount(ProductOptionVo productOptionVo);
	List<ProductOptionVo> selectPrdOpByPrdNo(int productNo);
	int insertPrdOption(ProductOptionVo productOptionVo);
	int delPrdOption(int productOptionNo);
	int udtPrdOpAll(ProductOptionVo prdOption);
}
