package hwst.service.category;

import hwst.domain.category.CategoryVo;

import java.util.List;

public interface CategoryService {

	List<CategoryVo> selectCategory();
	List<CategoryVo> selectUpCategory();
}
