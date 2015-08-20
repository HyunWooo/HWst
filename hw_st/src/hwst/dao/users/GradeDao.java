package hwst.dao.users;

import hwst.domain.users.GradeVo;

import java.util.List;

public interface GradeDao {

	List<GradeVo> selectGradeList();
}
