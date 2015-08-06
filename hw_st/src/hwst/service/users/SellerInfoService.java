package hwst.service.users;

import hwst.dao.users.UsersDao;
import hwst.domain.users.UsersVo;

import javax.annotation.Resource;

import org.springframework.stereotype.Service;

@Service("sellerInfoService")
public class SellerInfoService implements UserInfoService{

	@Resource(name = "usersDao")
	UsersDao usersDao;
	
	@Override
	public UsersVo selectUserInfo(UsersVo uVo)throws Exception{
		return usersDao.selectOneSeller(uVo.getUserNo());
	}
	
	@Override
	public int updateUsersLog(int userNo)throws Exception{
		return usersDao.updateSellerLog(userNo);
	}
}
