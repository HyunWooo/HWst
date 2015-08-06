package hwst.service.users;

import hwst.dao.users.UsersDao;
import hwst.domain.users.UsersVo;

import javax.annotation.Resource;

import org.springframework.stereotype.Service;

@Service("adminInfoService")
public class AdminInfoService implements UserInfoService{

	@Resource(name = "usersDao")
	UsersDao usersDao;
	
	@Override
	public UsersVo selectUserInfo(UsersVo uVo)throws Exception{
		return usersDao.selectOneAdmin(uVo);
	}
	
	@Override
	public int updateUsersLog(int userNo)throws Exception{
		return usersDao.updateAdminLog(userNo);
	}
}
