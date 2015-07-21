package hwst.service.product;

import hwst.domain.product.ProductOptionVo;

import java.util.List;

public interface ProductOptionService {

	List<ProductOptionVo> selectProductOptionAll(int productNo)throws Exception;
	List<ProductOptionVo> selectProductOptionByPoNo(List<Integer> productOptionNo, List<Integer> buyAmount)throws Exception;
}
