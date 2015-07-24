package hwst.service.product;

import hwst.dao.product.ProductOptionDao;
import hwst.domain.product.ProductOptionVo;
import hwst.service.product.ProductOptionService;

import java.util.List;

import javax.annotation.Resource;

import org.springframework.stereotype.Service;

@Service("productOptionService")
public class ProductOptionServiceImpl implements ProductOptionService {

	@Resource(name="productOptionDao")
	private ProductOptionDao productOptionDao;
	
	
	//해당상품의 활성화상태의 상품옵션정보 조회
	@Override
	public List<ProductOptionVo> selectProductOptionAll(int productNo)throws Exception{
		return productOptionDao.selectProductOptionAll(productNo);
	}
	
	//상품번호로 해당상품옵션데이터 select (활성/비활성 전부)
		@Override
		public List<ProductOptionVo> selectPrdOpByPrdNo(int productNo)throws Exception{
			 return productOptionDao.selectPrdOpByPrdNo(productNo);
		}
	
	//상품옵션번호로 상품옵션데이터 select
	@Override
	public List<ProductOptionVo> selectProductOptionByPoNo(List<Integer> productOptionNo,List<Integer> buyAmount)throws Exception{
		List<ProductOptionVo> list = productOptionDao.selectPOByPoNo(productOptionNo);
		for(int i = 0; i<list.size(); i++){
				list.get(i).setBuyAmount(buyAmount.get(i));
		}
		 return list;
	}
	
	//해당 판매자가 등록한 상품정보 select
	@Override
	public List<ProductOptionVo> selectRegisterPrdAll(int userNo)throws Exception{
		List<ProductOptionVo> productOptionVo = null;
		List<ProductOptionVo> productNoCount = null;	
		productOptionVo = productOptionDao.selectRegisterPrdAll(userNo);
		productNoCount = productOptionDao.selectPrdNoGroupCnt(userNo);
		
		for(int i=0; i<productOptionVo.size(); i++){		//ordersVo를 OrderNo 별로 group한 orderNoCount를 가지고 각 group의 개수를 해당 group의 첫번째 데이터의 orderNoCount속성에 set한다
			for(int j=0; j<productNoCount.size(); j++){
				if(productOptionVo.get(i).getProductNo()==productNoCount.get(j).getProductNo()){ //주문번호가 같을때 해당 주문번호 group에 해당하는 개수를 set해준다
					productOptionVo.get(i).setProductNoCount(productNoCount.get(j).getProductNoCount());
					i += productNoCount.get(j).getProductNoCount();
				}
			}
		}
		return productOptionVo;
	}
		
	//해당상품옵션의 재고수량 변경
	@Override
	public boolean udtPrdQuantity(ProductOptionVo prdOption)throws Exception{
		int stat = 0;
		
		stat = productOptionDao.udtPrdAmount(prdOption);
		
		if(stat==1){
			return true;
		}
		return false;
	}
	
	//해당상품옵션의 정보 변경
	@Override
	public boolean udtPrdOpAll(ProductOptionVo prdOption)throws Exception{
		int stat = 0;
		
		stat = productOptionDao.udtPrdOpAll(prdOption);
		
		if(stat==1){
			return true;
		}
		return false;
	}
	
	//상품옵션 추가
	@Override
	public boolean insertPrdOption(List<Integer> productNo, List<String> productOptionName,
		List<Integer> optionProcedure, List<Integer> addPrice,
		List<Integer> productAmount, List<Integer> optionStat, int userNo)throws Exception{
		
		int stat = 0;
		for(int i=0; i<productNo.size(); i++){
			stat += productOptionDao.insertPrdOption(new ProductOptionVo(productNo.get(i), productOptionName.get(i), optionProcedure.get(i), addPrice.get(i),productAmount.get(i),optionStat.get(i),userNo));
		}
		if(stat==productNo.size()){
			return true;
		}
		return false;
	}
	//상품옵션 추가
		@Override
		public boolean insertPrdOptionB(int productNo, List<String> productOptionName,
			List<Integer> optionProcedure, List<Integer> addPrice,
			List<Integer> productAmount, List<Integer> optionStat,
			int userNo)throws Exception{
			
			int stat = 0;
			for(int i=0; i<productOptionName.size(); i++){
				stat += productOptionDao.insertPrdOption(new ProductOptionVo(productNo, productOptionName.get(i), optionProcedure.get(i), addPrice.get(i),productAmount.get(i),optionStat.get(i),userNo));
			}
			if(stat==productOptionName.size()){
				return true;
			}
			return false;
		}
	
	//해당상품옵션 삭제
	@Override
	public boolean delPrdOption(int productOptionNo)throws Exception{
		int stat = 0;
		stat =productOptionDao.delPrdOption(productOptionNo);
		if(stat==1){
			return true;
		}
		return false;
	}
	
}
