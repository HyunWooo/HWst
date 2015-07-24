package hwst.dao.product;

import hwst.domain.product.ProductOptionVo;

import java.util.List;

public interface ProductOptionDao {
	List<ProductOptionVo> selectProductOptionAll(int productNo)throws Exception;
	List<ProductOptionVo> selectPOByPoNo(List<Integer> productOptionNo)throws Exception;
	List<ProductOptionVo> selectRegisterPrdAll(int userNo)throws Exception;
	List<ProductOptionVo> selectPrdNoGroupCnt(int userNo)throws Exception;
	int udtPrdAmount(ProductOptionVo productOptionVo)throws Exception;
	List<ProductOptionVo> selectPrdOpByPrdNo(int productNo)throws Exception;
	int insertPrdOption(ProductOptionVo productOptionVo)throws Exception;
	int delPrdOption(int productOptionNo)throws Exception;
	int udtPrdOpAll(ProductOptionVo prdOption)throws Exception;
}
