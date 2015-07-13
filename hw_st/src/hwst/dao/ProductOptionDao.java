package hwst.dao;

import hwst.domain.ProductOptionVo;

import java.util.List;

public interface ProductOptionDao {
	List<ProductOptionVo> selectProductOptionAll(int productNo);
}
