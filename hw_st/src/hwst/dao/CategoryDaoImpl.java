package hwst.dao;

import hwst.domain.CategoryVo;
import hwst.util.DBUtil;

import java.util.List;

import org.apache.ibatis.session.SqlSession;
import org.springframework.stereotype.Repository;

@Repository("categoryDao")
public class CategoryDaoImpl  implements CategoryDao {
	
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
