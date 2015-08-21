package hwst.dao.product;

import hwst.domain.product.ProductOptionVo;

import java.util.List;
import java.util.Map;

public interface ProductOptionDao {
	List<ProductOptionVo> selectProductOptionAll(int productNo);
	List<ProductOptionVo> selectPOByPoNo(List<Integer> productOptionNo);
	List<ProductOptionVo> selectRegisterPrdAll(int userNo);
	List<ProductOptionVo> selectPrdOpByPrdNo(int productNo);
	Map<Integer, Integer> selectPrdGroupCount(int userNo);
	int udtPrdAmount(ProductOptionVo productOptionVo);
	int udtPrdOpAll(ProductOptionVo prdOption);
	int insertPrdOption(ProductOptionVo productOptionVo);
	int delPrdOption(int productOptionNo);
	
	
}
