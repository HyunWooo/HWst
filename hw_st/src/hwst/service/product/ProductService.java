package hwst.service.product;

import hwst.domain.product.ProductVo;

import java.util.List;

public interface ProductService {

	List<ProductVo> selectProductAll();
	List<ProductVo> selectProductByKeyword(String keyword);
	List<ProductVo> selectProductByCategory(int categoryNo);
	ProductVo selectProductDetails(int productNo);
}
