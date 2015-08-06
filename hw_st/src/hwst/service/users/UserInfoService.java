package hwst.service.users;

import hwst.domain.users.UsersVo;

public interface UserInfoService {

	public UsersVo selectUserInfo(UsersVo usersVo)throws Exception;
	public int updateUsersLog(int userNo)throws Exception;
}
