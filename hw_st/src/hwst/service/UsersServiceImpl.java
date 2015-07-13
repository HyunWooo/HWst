package hwst.service;

import hwst.dao.users.UsersDao;
import hwst.domain.users.SellerVo;
import hwst.domain.users.UsersVo;

import java.sql.SQLException;

import javax.annotation.Resource;

import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

@Service("usersService")
public class UsersServiceImpl implements UsersService {

	@Resource(name = "usersDao")
	private UsersDao usersDao;


	@Override
	public String checkUsersId(String id) throws SQLException{
		int chkNo = 0;
		String chk = "아이디 사용가능";//아이디 사용가능

		chkNo = usersDao.selectOneUserNo(id);
		if (chkNo > 0) {
			chk = "이미 사용하고있는 아이디입니다";//아이디 중복
		}

		return chk;
	}

	@Override
	public UsersVo loginUsers(UsersVo vo) throws SQLException{
		UsersVo uVo = null;
		uVo = usersDao.selectOneUser(vo);

		if (uVo == null) {
			return null;
		} else if (uVo.getUserSection() == 1) {
			return usersDao.selectOneBuyer(vo);
		} else if (uVo.getUserSection() == 2) {
			return usersDao.selectOneSeller(uVo.getUserNo());
		} else if (uVo.getUserSection() == 3) {
			return usersDao.selectOneAdmin(vo);
		} else {
			return null;
		}
	}
	
	@Override
	public UsersVo selectUserOne(int userNo) throws SQLException{
			return usersDao.selectOneSeller(userNo);
	}

	@Transactional
	@Override
	public boolean signupBuyer(UsersVo vo) throws SQLException{
		boolean flag1 = false;
		boolean flag2 = false;
		int result1 = 0;
		int result2 = 0;
		int result3 = 0;
		
		
		result1 = usersDao.insertUsers(vo);
		result3 = usersDao.selectOneUserNo(vo.getId());
		result2 = usersDao.insertBuyer(result3);  
		
		

		flag1 = result1 > 0 ? true : false;
		flag2 = result2 > 0 ? true : false;

		if (flag1 == true && flag2 == true) {
			return true;
		} else {
			return false;
		}
	}

	@Override
	public boolean signupSeller(SellerVo vo) throws SQLException{
		boolean flag1 = false;
		boolean flag2 = false;
		int result1 = 0;
		int result2 = 0;
		int userNo = 0;
		SellerVo sVo = new SellerVo();

		result1 = usersDao.insertUsers(vo);
		userNo = usersDao.selectOneUserNo(vo.getId());
		sVo.setUserNo(userNo);
		sVo.setBankName(vo.getBankName());
		sVo.setAccountNo(vo.getAccountNo());
		System.out.println(sVo + "++sSignup sVo");
		result2 = usersDao.insertSeller(sVo);

		flag1 = result1 > 0 ? true : false;
		flag2 = result2 > 0 ? true : false;

		if (flag1 == true && flag2 == true) {
			return true;
		} else {
			return false;
		}
	}

	@Override
	public boolean updateUsers(UsersVo vo) throws SQLException{
		boolean flag = false;
		int result = 0;
		result = usersDao.updateUsers(vo);

		flag = result > 0 ? true : false;

		if (flag == true) {
			return true;
		} else {
			return false;
		}
	}

	@Override
	public boolean deleteUsers(int userNo, int userSection) throws SQLException{
		boolean flag1 = false;
		boolean flag2 = false;
		int result1 = 0;
		int result2 = 0;
		
		if(userSection==1){
			result1 = usersDao.updateBuyerLog(userNo);
			result2 = usersDao.updateUsersLog(userNo);
	
			flag1 = result1 > 0 ? true : false;
			flag2 = result2 > 0 ? true : false;
	
			if (flag1 == true && flag2 == true) {
				return true;
			} else {
				return false;
			}
		}
		else if(userSection==2){
			result1 = usersDao.updateSellerLog(userNo);
			result2 = usersDao.updateUsersLog(userNo);
	
			flag1 = result1 > 0 ? true : false;
			flag2 = result2 > 0 ? true : false;
	
			if (flag1 == true && flag2 == true) {
				return true;
			} else {
				return false;
			}
			
		}else{
			return false;
		}
		
		
	}

}