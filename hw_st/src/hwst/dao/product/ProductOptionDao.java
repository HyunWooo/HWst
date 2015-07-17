package hwst.dao.product;

import hwst.domain.product.ProductOptionVo;

import java.util.List;

public interface ProductOptionDao {
	List<ProductOptionVo> selectProductOptionAll(int productNo);
}
