package hwst.dao;

import hwst.domain.ProductVo;

import java.util.List;

public interface ProductDao {
	List<ProductVo> selectProductAll();
	List<ProductVo> selectProductByKeyword(String keyword);
	List<ProductVo> selectProductByCategory(int categoryNo);
	ProductVo selectProductDetails(int productNo);
}
