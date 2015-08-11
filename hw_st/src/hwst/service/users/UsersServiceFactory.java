package hwst.service.users;

import hwst.domain.users.UsersEnum.UserSection;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.stereotype.Service;

@Service("usersServiceFactory")
public class UsersServiceFactory {
	
	@Autowired
	@Qualifier("buyerInfoService")
	private  UserInfoService buyerInfoService;

	@Autowired
	@Qualifier("sellerInfoService")
	private  UserInfoService sellerInfoService;
	
	@Autowired
	@Qualifier("adminInfoService")
	private  UserInfoService adminInfoService;
	
	
	
	//회원별 분기
	public UserInfoService getUserInfo(UserSection userSection)throws Exception{
		switch (userSection){
			case BUYER: //구매자 로그인
				return buyerInfoService;
			case SELLER: //판매자 로그인
				return sellerInfoService;
			case ADMIN: //관리자 로그인
				return adminInfoService;
			default:
				return null;
		}
		
	}
	
}
