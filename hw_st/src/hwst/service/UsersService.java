package hwst.service;

import hwst.domain.users.SellerVo;
import hwst.domain.users.UsersVo;

import java.sql.SQLException;

public interface UsersService {
	boolean updateUsers(UsersVo vo) throws SQLException;
	boolean deleteUsers(int userNo, int userSection) throws SQLException;
	String checkUsersId(String id) throws SQLException;
	UsersVo loginUsers(UsersVo vo) throws SQLException;
	boolean signupBuyer(UsersVo user) throws SQLException;
	boolean signupSeller(SellerVo vo) throws SQLException;
	UsersVo selectUserOne(int userNo) throws SQLException;
}
