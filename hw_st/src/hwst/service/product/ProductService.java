package hwst.service.product;

import hwst.domain.product.ProductVo;

import java.util.List;

public interface ProductService {

	List<ProductVo> selectProductAll()throws Exception;
	List<ProductVo> selectProductByKeyword(String keyword)throws Exception;
	List<ProductVo> selectProductByCategory(int categoryNo)throws Exception;
	ProductVo selectProductDetails(int productNo)throws Exception;
	int insertPrd(ProductVo prdVo)throws Exception;
	List<ProductVo> selectPrdLow()throws Exception;
}
