package hwst.service.product;

import hwst.domain.product.ProductOptionVo;

import java.util.List;

public interface ProductOptionService {

	List<ProductOptionVo> selectProductOptionAll(int productNo);
}
