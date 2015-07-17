package hwst.service.product;

import hwst.dao.product.ProductDao;
import hwst.domain.product.ProductVo;

import java.util.List;

import javax.annotation.Resource;

import org.springframework.stereotype.Service;

@Service("productService")
public class ProductServiceImpl implements ProductService {

	@Resource(name="productDao")
	private ProductDao productDao;
	
	//전체상품정보 조회
	@Override
	public List<ProductVo> selectProductAll() {
		return productDao.selectProductAll();
	}
	
	//전체상품 키워드검색 조회
	@Override
	public List<ProductVo> selectProductByKeyword(String keyword){
		return productDao.selectProductByKeyword(keyword);
	}
	
	//전체상품 카테고리검색 조회
	@Override
	public List<ProductVo> selectProductByCategory(int categoryNo){
		return productDao.selectProductByCategory(categoryNo);
	}
	
	//개별상품정보 조회
	@Override
	public ProductVo selectProductDetails(int productNo){
		return productDao.selectProductDetails(productNo);
	}
}
