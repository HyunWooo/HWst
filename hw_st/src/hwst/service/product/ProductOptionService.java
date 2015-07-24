package hwst.service.product;

import hwst.domain.product.ProductOptionVo;

import java.util.List;

public interface ProductOptionService {

	List<ProductOptionVo> selectProductOptionAll(int productNo)throws Exception;
	List<ProductOptionVo> selectProductOptionByPoNo(List<Integer> productOptionNo, List<Integer> buyAmount)throws Exception;
	List<ProductOptionVo> selectRegisterPrdAll(int userNo)throws Exception;
	boolean udtPrdQuantity(ProductOptionVo prdOption)throws Exception;
	List<ProductOptionVo> selectPrdOpByPrdNo(int productNo)throws Exception;
	boolean insertPrdOption(List<Integer> productNo, List<String> plusPOName,
			List<Integer> plusOP, List<Integer> plusAddPrice,
			List<Integer> plusProductAmount, List<Integer> optionValue, int userNo)throws Exception;
	boolean delPrdOption(int productOptionNo)throws Exception;
	boolean insertPrdOptionB(int productNo, List<String> plusPOName,
			List<Integer> plusOP, List<Integer> plusAddPrice,
			List<Integer> plusProductAmount, List<Integer> optionValue,
			int userNo) throws Exception;
	boolean udtPrdOpAll(ProductOptionVo prdOption)throws Exception;
}
