package hwst.dao.users;

import hwst.domain.users.GradeVo;

import java.util.List;

import org.apache.ibatis.session.SqlSession;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

@Repository("gradeDao")
public class GradeDaoImpl implements GradeDao {

	@Autowired
	private SqlSession sqlSession;
	
	public List<GradeVo> selectGradeList(){
		return sqlSession.selectList("grade.selectGradeList");
	};
	
}
