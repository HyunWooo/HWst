package hwst.dao.product;

import hwst.domain.product.ProductOptionVo;
import hwst.util.DBUtil;

import java.util.List;

import org.apache.ibatis.session.SqlSession;
import org.springframework.stereotype.Repository;

@Repository("productOptionDao")
public class ProductOptionDaoImpl  implements ProductOptionDao {
	
	//해당상품의 상품옵션정보 조회
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
