package hwst.service.users;

import hwst.dao.users.UsersDao;
import hwst.dao.users.UsersDaoImpl;
import hwst.domain.users.UsersVo;

import javax.annotation.Resource;

import org.springframework.stereotype.Service;

@Service("buyerInfoService")
public class BuyerInfoService implements UserInfoService{

	@Resource(name = "usersDao")
	private UsersDao usersDao;
	
	@Override
	public UsersVo selectUserInfo(UsersVo uVo)throws Exception{
		UsersDao usersDao = new UsersDaoImpl();
		return usersDao.selectOneBuyer(uVo);
	}
	
	@Override
	public int updateUsersLog(int userNo)throws Exception{
		return usersDao.updateBuyerLog(userNo);
	}
}
