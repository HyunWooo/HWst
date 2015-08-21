package hwst.service.product;

import hwst.common.CommonMethod;
import hwst.dao.product.ProductOptionDao;
import hwst.domain.product.ProductOptionVo;

import java.util.List;
import java.util.Map;

import javax.annotation.Resource;

import org.apache.log4j.Logger;
import org.springframework.stereotype.Service;

@Service("productOptionService")
public class ProductOptionServiceImpl implements ProductOptionService {

	@Resource(name="productOptionDao")
	private ProductOptionDao productOptionDao;
	Logger logger = Logger.getLogger(this.getClass());
	
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
		List<ProductOptionVo> poList = productOptionDao.selectPOByPoNo(productOptionNo);
		
		for(int poNo = 0; poNo<poList.size(); poNo++){
			poList.get(poNo).setBuyAmount(buyAmount.get(poNo));
		}
		return poList;
	}
	
	//해당 판매자가 등록한 상품정보 select
	@Override
	public List<ProductOptionVo> selectRegisterPrdAll(int userNo)throws Exception{
		return productOptionDao.selectRegisterPrdAll(userNo);
	}
	
	//상품번호로 그룹맺은 뒤 해당 그룹별 갯수를 count
	@Override
	public Map<Integer, Integer> selectPrdGroupCount(int userNo)throws Exception{
		return productOptionDao.selectPrdGroupCount(userNo);
	}
		
	//해당상품옵션의 재고수량 변경
	@Override
	public boolean udtPrdQuantity(ProductOptionVo prdOption)throws Exception{
		return CommonMethod.isSuccessOneCUD(productOptionDao.udtPrdAmount(prdOption));
	}
	
	//해당상품옵션의 정보 변경
	@Override
	public boolean udtPrdOpAll(ProductOptionVo prdOption)throws Exception{
		return CommonMethod.isSuccessOneCUD(productOptionDao.udtPrdOpAll(prdOption));
	}
	
	//상품옵션만 바로 추가하는 로직
	@Override
	public boolean insertPrdOption(List<Integer> productNo, List<String> productOptionName,
		List<Integer> optionProcedure, List<Integer> addPrice,
		List<Integer> productAmount, List<Integer> optionStat, int userNo)throws Exception{
		int stat = 0;

		for(int num=0; num<productNo.size(); num++){
			stat += productOptionDao.insertPrdOption(new ProductOptionVo(productNo.get(num), productOptionName.get(num), optionProcedure.get(num), addPrice.get(num),productAmount.get(num),optionStat.get(num),userNo));
		}
		
		return CommonMethod.isEqualValues(stat, productNo.size());
		}
	
	//상품추가 시 상품옵션 추가하는 로직
	@Override
	public boolean insertPrdOptionB(int productNo, List<String> productOptionName,
		List<Integer> optionProcedure, List<Integer> addPrice,
		List<Integer> productAmount, List<Integer> optionStat,
		int userNo)throws Exception{
		int stat = 0;
		
		for(int num=0; num<productOptionName.size(); num++){
			stat += productOptionDao.insertPrdOption(new ProductOptionVo(productNo, productOptionName.get(num), optionProcedure.get(num), addPrice.get(num),productAmount.get(num),optionStat.get(num),userNo));
		}
		
		return CommonMethod.isEqualValues(stat, productOptionName.size());
	}
	
	//해당상품옵션 삭제
	@Override
	public boolean delPrdOption(int productOptionNo)throws Exception{
		return CommonMethod.isSuccessOneCUD(productOptionDao.delPrdOption(productOptionNo));
	}
	
	
	
	//두 OrdersVo객체의 주문번호가 같은지 체크하는 메소드
	public boolean isEqualsPrdNo(ProductOptionVo productOptionVo,ProductOptionVo productNoCount){
		return CommonMethod.isEqualValues(productOptionVo.getProductNo(), productNoCount.getProductNo());
	}
	
}
