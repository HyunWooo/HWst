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
	public List<ProductVo> selectProductAll()throws Exception {
		return productDao.selectProductAll();
	}
	
	//전체상품 최저가 조회
	@Override
	public List<ProductVo> selectPrdLow()throws Exception {
		return productDao.selectPrdLow();
	}
		
	//전체상품 키워드검색 조회
	@Override
	public List<ProductVo> selectProductByKeyword(String keyword)throws Exception{
		return productDao.selectProductByKeyword(keyword);
	}
	
	//전체상품 카테고리검색 조회
	@Override
	public List<ProductVo> selectProductByCategory(int categoryNo)throws Exception{
		return productDao.selectProductByCategory(categoryNo);
	}
	
	//개별상품정보 조회
	@Override
	public ProductVo selectProductDetails(int productNo)throws Exception{
		return productDao.selectProductDetails(productNo);
	}
	
	//상품등록 후 productNo조회
		@Override
		public int insertPrd(ProductVo prdVo)throws Exception{
			int stat = 0; 
			int productNo = 0;
			
			stat = productDao.insertPrd(prdVo);
			
			if(stat==1){
				productNo = productDao.selectProductNo(prdVo);
			}
			
			return productNo;
		}
	
	
}
