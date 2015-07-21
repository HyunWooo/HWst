package hwst.dao.product;

import hwst.domain.product.ProductOptionVo;

import java.util.List;

public interface ProductOptionDao {
	List<ProductOptionVo> selectProductOptionAll(int productNo)throws Exception;
	List<ProductOptionVo> selectPOByPoNo(List<Integer> productOptionNo)throws Exception;
	int udtPrdAmount(ProductOptionVo productOptionVo)throws Exception;
}
