package hwst.dao.users;

import hwst.domain.users.AdminVo;
import hwst.domain.users.BuyerVo;
import hwst.domain.users.SellerVo;
import hwst.domain.users.UsersVo;
import hwst.util.DBUtil;

import java.sql.SQLException;
import java.util.List;

import org.apache.ibatis.session.SqlSession;
import org.apache.log4j.Logger;
import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;

@Repository("usersDao")
public class UsersDaoImpl implements UsersDao {
	
	Logger logger = Logger.getLogger(this.getClass());

	
	//전체회원 조회
	@Override
	public List<UsersVo> usersSelect() throws SQLException{
		SqlSession session = null;
		List<UsersVo> list = null;
		try {
			session = DBUtil.getSqlSession();
			list = session.selectList("users.selectAll");
		} finally {
			DBUtil.closeSqlSession(session);
		}
		return list;
	}



	
	//id로 userNo만 추출
	@Override
	public int selectOneUserNo(String id){
		SqlSession session = null;
		int userNo = 0;
		try {
			session = DBUtil.getSqlSession();
			userNo = session.selectOne("users.selectOneUserNo", id);
		} catch(Exception e){
		}
		finally {
			DBUtil.closeSqlSession(session);
		}
		return userNo;
	}
	
	//id,pw로 해당회원의 회원정보 조회
	@Override
	public UsersVo selectOneUser(UsersVo vo)throws Exception{
		SqlSession session = null;
		UsersVo uVo = null;
		try {
			session = DBUtil.getSqlSession();
			logger.info("안녕하세요!"+ vo + "입니다.");
			uVo = session.selectOne("users.loginUsers",vo);
		} catch(Exception e){
		}
		finally {
			DBUtil.closeSqlSession(session);
		}
		return uVo;
	}
	
	//해당회원의 구매자정보 조회
	@Override
	public BuyerVo selectOneBuyer(UsersVo vo){
		System.out.println("오지도않잖아");
		SqlSession session = null;
		BuyerVo bVo = null;
		try {
			session = DBUtil.getSqlSession();
			bVo = session.selectOne("users.selectOneBuyer", vo);
			System.out.println(bVo);
		} finally {
			DBUtil.closeSqlSession(session);
		}
		return bVo;
	}
	
	//해당회원의 판매자정보 조회
	@Override
	public SellerVo selectOneSeller(int userNo){
		SqlSession session = null;
		SellerVo sVo = null;
		try {
			session = DBUtil.getSqlSession();
			sVo = session.selectOne("users.selectOneSeller", userNo);
		} finally {
			DBUtil.closeSqlSession(session);
		}
		return sVo;
	}
	
	//해당회원의 관리자정보 조회
	@Override
	public AdminVo selectOneAdmin(UsersVo vo){
		SqlSession session = null;
		AdminVo aVo = null;
		try {
			session = DBUtil.getSqlSession();
			aVo = session.selectOne("users.selectOneAdmin", vo);
		} catch(Exception e){
		}
		finally {
			DBUtil.closeSqlSession(session);
		}
		return aVo;
	}
	
	//회원가입
	@Transactional
	@Override
	public int insertUsers(UsersVo vo) {
		SqlSession session = null;
		int result = 0;
		try {
			session = DBUtil.getSqlSession();
			result = session.insert("users.insertUsers", vo);
		} finally {
			DBUtil.closeSqlSession(session);
		}
		return result;
	}
	
	//구매자정보 입력
	@Transactional
	@Override
	public int insertBuyer(int userNo){
		SqlSession session = null;
		int result = 0;
		try {
			session = DBUtil.getSqlSession();
			result = session.insert("users.insertBuyer", userNo);
		} catch(Exception e){
		}finally {
			DBUtil.closeSqlSession(session);
		}
		return result;
	}
	
	//판매자정보 입력
	@Override
	public int insertSeller(SellerVo sVo){
		SqlSession session = null;
		int result = 0;
		try {
			session = DBUtil.getSqlSession();
			result = session.insert("users.insertSeller", sVo);
		}finally {
			DBUtil.closeSqlSession(session);
		}
		return result;
	}
		
	//회원공통정보 수정
	@Override
	public int updateUsers(UsersVo vo) {
		SqlSession session = null;
		int result = 0;
		try {
			session = DBUtil.getSqlSession();
			result = session.update("users.updateUsers", vo);

		} finally {
			DBUtil.closeSqlSession(session);
		}
		return result;
	}
	
	//회원 탈퇴
	//구매자 회원탈퇴(정보변경)
	@Override
	public int updateBuyerLog(int userNo){
		SqlSession session = null;
		int result = 0;
		try {
			session = DBUtil.getSqlSession();
			result = session.update("users.updateBuyerLog", userNo);
		} finally {
			DBUtil.closeSqlSession(session);
		}
		return result;
	}
	
	//판매자 회원탈퇴(정보변경)
	@Override
	public int updateSellerLog(int userNo){
		SqlSession session = null;
		int result = 0;
		try {
			session = DBUtil.getSqlSession();
			result = session.update("users.updateSellerLog", userNo);
		} finally {
			DBUtil.closeSqlSession(session);
		}
		return result;
	}
	
	//관리자 회원탈퇴(정보변경)
		@Override
		public int updateAdminLog(int userNo){
			SqlSession session = null;
			int result = 0;
			try {
				session = DBUtil.getSqlSession();
				result = session.update("users.updateAdminLog", userNo);
			} finally {
				DBUtil.closeSqlSession(session);
			}
			return result;
		}
	
	//공통회원 회원탈퇴(정보변경)
	@Override
	public int updateUsersLog(int userNo){
		SqlSession session = null;
		int result = 0;
		try {
			session = DBUtil.getSqlSession();
			result = session.update("users.updateUsersLog", userNo);
		} finally {
			DBUtil.closeSqlSession(session);
		}
		return result;
	}
	
}
