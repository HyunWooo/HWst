package hwst.dao.category;

import java.util.List;

import hwst.domain.category.CategoryVo;

public interface CategoryDao {
	List<CategoryVo> selectCategory();
	List<CategoryVo> selectUpCategory();
}
