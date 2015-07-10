package hwst.dao;

import hwst.domain.ProductOptionVo;
import hwst.util.DBUtil;

import java.util.List;

import org.apache.ibatis.session.SqlSession;
import org.springframework.stereotype.Repository;

@Repository("productOptionDao")
public class ProductOptionDaoImpl  implements ProductOptionDao {
	
	@Override
	public List<ProductOptionVo> selectProductOptionAll(int productNo){
		SqlSession session = null;
		List<ProductOptionVo> list = null;
		try {
			session = DBUtil.getSqlSession();
			list = session.selectList("productOption.selectProductOptionAll",productNo);
		} finally {
			DBUtil.closeSqlSession(session);
		}
		return list;
	}
}
