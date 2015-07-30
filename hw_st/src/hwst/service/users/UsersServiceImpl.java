package hwst.service.users;

import hwst.dao.users.UsersDao;
import hwst.domain.users.SellerVo;
import hwst.domain.users.UsersVo;

import java.sql.SQLException;

import javax.annotation.Resource;

import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Isolation;
import org.springframework.transaction.annotation.Propagation;
import org.springframework.transaction.annotation.Transactional;

@Service("usersService")
public class UsersServiceImpl implements UsersService {

	@Resource(name = "usersDao")
	private UsersDao usersDao;

	//회원가입시 아이디 중복 체크
	@Override
	public String checkUsersId(String id) throws Exception{
		int chkNo = 0;
		String chk = "아이디 사용가능";//아이디 사용가능

		chkNo = usersDao.selectOneUserNo(id);
		if (chkNo > 0) {
			chk = "이미 사용하고있는 아이디입니다";//아이디 중복
		}

		return chk;
	}

	//로그인
	@Override
	public UsersVo loginUsers(UsersVo vo) throws Exception{
		UsersVo uVo = usersDao.selectOneUser(vo);
		switch (uVo.getUserSection()){
			case 1: //구매자 로그인
				return usersDao.selectOneBuyer(vo);
			case 2: //판매자 로그인
				return usersDao.selectOneSeller(uVo.getUserNo());
			case 3: //관리자 로그인
				return usersDao.selectOneAdmin(vo);
			default:
				return null;
		}
	}
	
	//userNo로 판매자정보 가져오기
	@Override
	public UsersVo selectUserOne(int userNo) throws Exception{
			return usersDao.selectOneSeller(userNo);
	}

	//회원가입
	//구매자 회원가입
	@Transactional(propagation = Propagation.REQUIRED,isolation = Isolation.DEFAULT ,rollbackFor = {Exception.class,SQLException.class} ,readOnly = false)
	@Override
	public boolean signupBuyer(UsersVo vo) throws Exception{
		int result1 = 0;
		int result2 = 0;
		int result3 = 0;
		
		result1 = usersDao.insertUsers(vo);
		result3 = usersDao.selectOneUserNo(vo.getId());
		result2 = usersDao.insertBuyer(result3);  

		return flagCheck(result1, result2);
	
	}

	//판매자 회원가입
	@Override
	public boolean signupSeller(SellerVo vo) throws Exception{
		int result1 = 0;
		int result2 = 0;
		int userNo = 0;
		SellerVo sVo = new SellerVo();

		result1 = usersDao.insertUsers(vo);
		userNo = usersDao.selectOneUserNo(vo.getId());
		sVo.setUserNo(userNo);
		sVo.setBankName(vo.getBankName());
		sVo.setAccountNo(vo.getAccountNo());
		result2 = usersDao.insertSeller(sVo);

		return flagCheck(result1, result2);
	}

	//회원정보변경
	@Override
	public boolean updateUsers(UsersVo vo) throws Exception{
		int result = 0;
		result = usersDao.updateUsers(vo);

		if (result > 0) {
			return true;
		}
		return false;
	}

	//회원탈퇴
	@Override
	public boolean deleteUsers(int userNo, int userSection) throws Exception{
		int result1 = 0;
		int result2 = 0;
		
		result1 = deleteUser(userNo, userSection);
		result2 = usersDao.updateUsersLog(userNo);
		
		return flagCheck(result1, result2);
	}
	
	
	
	//값 체크 후 T/F반환
	public boolean flagCheck(int result1, int result2){
		boolean flag1 = false;
		boolean flag2 = false;
		flag1 = result1 > 0 ? true : false;
		flag2 = result2 > 0 ? true : false;
		
		if (flag1 == true && flag2 == true) {
			return true;
		}
		
		return false;
	}

	//userSection별로 해당 고객정보 삭제로 변경
	public int deleteUser(int userNo, int userSection)throws Exception{
		switch(userSection){
			case 1:
				return usersDao.updateBuyerLog(userNo);
			case 2:
				return usersDao.updateUsersLog(userNo);
			default:
				return 0;
		}
	}
}