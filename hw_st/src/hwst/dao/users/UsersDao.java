package hwst.dao.users;

import hwst.domain.users.AdminVo;
import hwst.domain.users.BuyerVo;
import hwst.domain.users.SellerVo;
import hwst.domain.users.UsersVo;

import java.sql.SQLException;
import java.util.List;

public interface UsersDao {
	int insertUsers(UsersVo vo) throws SQLException;
	List<UsersVo> usersSelect() throws SQLException;
	
	UsersVo selectOneUser(UsersVo vo) throws SQLException;
	BuyerVo selectOneBuyer(UsersVo vo) throws SQLException;
	SellerVo selectOneSeller(int i) throws SQLException;
	AdminVo selectOneAdmin(UsersVo vo) throws SQLException;
	int insertBuyer(int userNo) throws SQLException;
	int insertSeller(SellerVo sVo) throws SQLException;
	int selectOneUserNo(String id) throws SQLException;
	int updateUsers(UsersVo vo) throws SQLException;
	int updateBuyerLog(int userNo) throws SQLException;
	int updateUsersLog(int userNo) throws SQLException;
	int updateSellerLog(int userNo) throws SQLException;
}