package hwst.service;

import hwst.domain.CategoryVo;

import java.util.List;

public interface CategoryService {

	List<CategoryVo> selectCategory();
	List<CategoryVo> selectUpCategory();
}
