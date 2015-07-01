package model.dao;

import java.util.List;

import model.domain.ProVo;

import org.apache.ibatis.session.SqlSession;
import org.springframework.stereotype.Repository;

import util.DBUtil;

@Repository("pDao")
public class ProDaoImpl  implements ProDao {
	@Override
	public List<ProVo> proSelect() {
		SqlSession session = null;
		List<ProVo> list = null;
		try {
			session = DBUtil.getSqlSession();
			list = session.selectList("pro.selectAll");
			System.out.println("ProDaoImpl¿« list" + list);
		} finally {
			DBUtil.closeSqlSession(session);
		}
		return list;
	}
}
