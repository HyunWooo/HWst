package hwst.service.users;

import hwst.domain.users.UsersEnum.UserSection;
import hwst.domain.users.UsersVo;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.stereotype.Service;

@Service("usersServiceFactory")
public class UsersServiceFactory {
	
	//@Resource(name = "buyerInfoService")
	@Autowired
	@Qualifier("buyerInfoService")
	private  BuyerInfoService buyerInfoService;

	//@Resource(name = "sellerInfoService")
	@Autowired
	@Qualifier("sellerInfoService")
	private  SellerInfoService sellerInfoService;
	
	//@Resource(name = "adminInfoService")
	@Autowired
	@Qualifier("adminInfoService")
	private  AdminInfoService adminInfoService;
	
	
	
	//로그인 회원별 분기
	public   UserInfoService getUserInfo(UsersVo uVo)throws Exception{
		UserInfoService buyerInfoService = new BuyerInfoService();
		switch (uVo.getUserSection()){
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
	
	
	//삭제시 회원별 분기
	public  int deleteUser(int userNo, UserSection userSection)throws Exception{
		switch(userSection){
			case BUYER:
				return buyerInfoService.updateUsersLog(userNo);
			case SELLER:
				return sellerInfoService.updateUsersLog(userNo);
			default:
				return 0;
		}
	}
}
