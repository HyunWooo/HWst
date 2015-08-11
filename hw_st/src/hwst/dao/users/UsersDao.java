package hwst.dao.users;

import hwst.domain.users.AdminVo;
import hwst.domain.users.BuyerVo;
import hwst.domain.users.SellerVo;
import hwst.domain.users.UsersVo;

import java.util.List;

public interface UsersDao {
	int insertUsers(UsersVo vo);
	List<UsersVo> usersSelect();
	
	UsersVo selectOneUser(UsersVo vo);
	BuyerVo selectOneBuyer(UsersVo vo);
	SellerVo selectOneSeller(int userNo);
	AdminVo selectOneAdmin(UsersVo vo);
	int insertBuyer(int userNo);
	int insertSeller(SellerVo sVo);
	int selectOneUserNo(String id);
	int updateUsers(UsersVo vo);
	int updateBuyerLog(int userNo);
	int updateUsersLog(int userNo);
	int updateSellerLog(int userNo);
	int updateAdminLog(int userNo);
}