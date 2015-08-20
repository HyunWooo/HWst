package hwst.service.users;


public class UsersServiceImplCopy{
/*@Service("usersService")
public class UsersServiceImplCopy implements UsersService {

	@Resource(name = "usersDao")
	private UsersDao usersDao;

	//회원가입시 아이디 중복 체크
	@Override
	public String checkUsersId(String id) throws Exception{
		String chk = "아이디 사용가능";//아이디 사용가능

		if (usersDao.selectOneUserNo(id) > 0) {
			chk = "이미 사용하고있는 아이디입니다";//아이디 중복
		}

		return chk;
	}

	//로그인
		@Override
		public UsersVo loginUsers(UsersVo vo) throws Exception{
			UsersVo uVo = usersDao.selectOneUser(vo);
			switch (uVo.getUserSection()){
				case BUYER: //구매자 로그인
					return usersDao.selectOneBuyer(vo);
				case SELLER: //판매자 로그인
					return usersDao.selectOneSeller(uVo.getUserNo());
				case ADMIN: //관리자 로그인
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
	//@Transactional(propagation = Propagation.REQUIRED,isolation = Isolation.DEFAULT ,rollbackFor = {Exception.class,SQLException.class} ,readOnly = false)
	@Override
	public boolean signupBuyer(UsersVo vo) throws Exception{
		return flagCheck(usersDao.insertUsers(vo), usersDao.insertBuyer(usersDao.selectOneUserNo(vo.getId())));
	
	}

	//판매자 회원가입
	@Override
	public boolean signupSeller(SellerVo vo) throws Exception{
		SellerVo sVo = new SellerVo();

		sVo.setUserNo(usersDao.selectOneUserNo(vo.getId()));
		sVo.setBankName(vo.getBankName());
		sVo.setAccountNo(vo.getAccountNo());

		return flagCheck(usersDao.insertUsers(vo), usersDao.insertSeller(sVo));
	}

	//회원정보변경
	@Override
	public boolean updateUsers(UsersVo vo) throws Exception{
		if (usersDao.updateUsers(vo) > 0) {
			return true;
		}
		return false;
	}

	//회원탈퇴
	@Override
	public boolean deleteUsers(int userNo, UserSection userSection) throws Exception{
		return flagCheck(UsersServiceFactory.deleteUser(userNo, userSection), usersDao.updateUsersLog(userNo));
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
	}*/

}