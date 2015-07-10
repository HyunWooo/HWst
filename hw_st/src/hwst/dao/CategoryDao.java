package hwst.dao;

import java.util.List;

import hwst.domain.CategoryVo;

public interface CategoryDao {
	List<CategoryVo> selectCategory();
	List<CategoryVo> selectUpCategory();
}
