package hwst.dao.users;

import hwst.domain.users.AdminVo;
import hwst.domain.users.BuyerVo;
import hwst.domain.users.SellerVo;
import hwst.domain.users.UsersVo;

import java.util.List;

import org.apache.ibatis.session.SqlSession;
import org.apache.log4j.Logger;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;

@Repository("usersDao")
public class UsersDaoImpl implements UsersDao {
	
	@Autowired
	private SqlSession sqlSession;
	Logger logger = Logger.getLogger(this.getClass());

	
	//전체회원 조회
	@Override
	public List<UsersVo> usersSelect(){
		return sqlSession.selectList("users.selectAll");
	}

	//id로 userNo만 추출
	@Override
	public int selectOneUserNo(String id){
		return sqlSession.selectOne("users.selectOneUserNo", id);
	}
	
	//id,pw로 해당회원의 회원정보 조회
	@Override
	public UsersVo selectOneUser(UsersVo vo){
		return sqlSession.selectOne("users.loginUsers",vo);
	}
	
	//해당회원의 구매자정보 조회
	@Override
	public BuyerVo selectOneBuyer(UsersVo vo){
		return sqlSession.selectOne("users.selectOneBuyer", vo);
	}
	
	//해당회원의 판매자정보 조회
	@Override
	public SellerVo selectOneSeller(int userNo){
		return sqlSession.selectOne("users.selectOneSeller", userNo);
	}
	
	//해당회원의 관리자정보 조회
	@Override
	public AdminVo selectOneAdmin(UsersVo vo){
		return sqlSession.selectOne("users.selectOneAdmin", vo);
	}
	
	//회원가입
	@Transactional
	@Override
	public int insertUsers(UsersVo vo) {
		return sqlSession.insert("users.insertUsers", vo);
	}
	
	//구매자정보 입력
	@Transactional
	@Override
	public int insertBuyer(int userNo){
		return sqlSession.insert("users.insertBuyer", userNo);
	}
	
	//판매자정보 입력
	@Override
	public int insertSeller(SellerVo sVo){
		return sqlSession.insert("users.insertSeller", sVo);
	}
		
	//회원공통정보 수정
	@Override
	public int updateUsers(UsersVo vo) {
		return sqlSession.update("users.updateUsers", vo);
	}
	
	//회원 탈퇴
	//구매자 회원탈퇴(정보변경)
	@Override
	public int updateBuyerLog(int userNo){
		return sqlSession.update("users.updateBuyerLog", userNo);
	}
	
	//판매자 회원탈퇴(정보변경)
	@Override
	public int updateSellerLog(int userNo){
		return sqlSession.update("users.updateSellerLog", userNo);
	}
	
	//관리자 회원탈퇴(정보변경)
	@Override
	public int updateAdminLog(int userNo){
		return sqlSession.update("users.updateAdminLog", userNo);
	}
	
	//공통회원 회원탈퇴(정보변경)
	@Override
	public int updateUsersLog(int userNo){
		return sqlSession.update("users.updateUsersLog", userNo);
	}
	
}
