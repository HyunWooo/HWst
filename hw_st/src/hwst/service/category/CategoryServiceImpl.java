package hwst.service.category;

import java.util.List;

import hwst.dao.category.CategoryDao;
import hwst.domain.category.CategoryVo;

import javax.annotation.Resource;

import org.springframework.stereotype.Service;

@Service("categoryService")
public class CategoryServiceImpl implements CategoryService {

	@Resource(name="categoryDao")
	private CategoryDao categoryDao;
	
	//카테고리정보 조회
	@Override
	public List<CategoryVo> selectCategory(){
		return categoryDao.selectCategory();
	}
	
	//상위카테고리정보 조회
	@Override
	public List<CategoryVo> selectUpCategory(){
		return categoryDao.selectUpCategory();
	}
	
}
