package hwst.dao.category;

import hwst.domain.category.CategoryVo;

import java.util.List;

import org.apache.ibatis.session.SqlSession;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

@Repository("categoryDao")
public class CategoryDaoImpl  implements CategoryDao {
	
	@Autowired
	private SqlSession sqlSession;
	
	
	//카테고리정보 조회
	@Override
	public List<CategoryVo> selectCategory(){
		return sqlSession.selectList("category.selectCategory");
	}
	
	//상위카테고리정보 조회
	@Override
	public List<CategoryVo> selectUpCategory(){
		return sqlSession.selectList("category.selectUpCategory");
	}
}
