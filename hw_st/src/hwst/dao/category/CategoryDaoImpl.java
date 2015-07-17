package hwst.dao.category;

import hwst.domain.category.CategoryVo;
import hwst.util.DBUtil;

import java.util.List;

import org.apache.ibatis.session.SqlSession;
import org.springframework.stereotype.Repository;

@Repository("categoryDao")
public class CategoryDaoImpl  implements CategoryDao {
	
	//카테고리정보 조회
	@Override
	public List<CategoryVo> selectCategory(){
		SqlSession session = null;
		List<CategoryVo> list = null;
		try {
			session = DBUtil.getSqlSession();
			list = session.selectList("category.selectCategory");
		} finally {
			DBUtil.closeSqlSession(session);
		}
		return list;
	}
	
	//상위카테고리정보 조회
	@Override
	public List<CategoryVo> selectUpCategory(){
		SqlSession session = null;
		List<CategoryVo> list = null;
		try {
			session = DBUtil.getSqlSession();
			list = session.selectList("category.selectUpCategory");
		} finally {
			DBUtil.closeSqlSession(session);
		}
		return list;
	}
}
