package hwst.service.product;

import hwst.dao.product.ProductOptionDao;
import hwst.domain.product.ProductOptionVo;

import java.util.List;

import javax.annotation.Resource;

import org.springframework.stereotype.Service;

@Service("productOptionService")
public class ProductOptionServiceImpl implements ProductOptionService {

	@Resource(name="productOptionDao")
	private ProductOptionDao productOptionDao;
	
	
	//해당상품의 상품옵션정보 조회
	@Override
	public List<ProductOptionVo> selectProductOptionAll(int productNo)throws Exception{
		return productOptionDao.selectProductOptionAll(productNo);
	}
	
	
	@Override
	public List<ProductOptionVo> selectProductOptionByPoNo(List<Integer> productOptionNo,List<Integer> buyAmount)throws Exception{
		List<ProductOptionVo> list = productOptionDao.selectPOByPoNo(productOptionNo);
		for(int i = 0; i<list.size(); i++){
				list.get(i).setBuyAmount(buyAmount.get(i));
		}
		 System.out.println(list);
		 return list;
	}
	
	
}
