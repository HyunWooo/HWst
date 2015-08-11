package hwst.dao.product;

import hwst.domain.product.ProductVo;

import java.util.List;

public interface ProductDao {
	List<ProductVo> selectProductAll();
	List<ProductVo> selectProductByKeyword(String keyword);
	List<ProductVo> selectProductByCategory(int categoryNo);
	ProductVo selectProductDetails(int productNo);
	int insertPrd(ProductVo prdVo);
	int selectProductNo(ProductVo prdVo);
	List<ProductVo> selectPrdLow();
}
