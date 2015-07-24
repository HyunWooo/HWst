package hwst.controller.users;

import hwst.domain.users.SellerVo;
import hwst.domain.users.UsersVo;
import hwst.service.users.UsersService;

import javax.annotation.Resource;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpSession;

import org.springframework.http.HttpHeaders;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.servlet.ModelAndView;

@Controller
public class UsersController {
	 
	
	@Resource(name="usersService")
    private UsersService usersService;

	//id중복체크
	@RequestMapping("checkId.do")
	@ResponseBody
	public ResponseEntity<String> usersIdCheck(String id){
		String checkMsg = null;
		try {
			checkMsg = usersService.checkUsersId(id);
		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		HttpHeaders resHeader = new HttpHeaders();
		resHeader.add("Content-Type", "text/html;charset=UTF-8");
		ResponseEntity<String> resultMsg = new ResponseEntity<String>(checkMsg, resHeader, HttpStatus.OK);
		return resultMsg;
	}

	// 로그인
    @RequestMapping(value="loginProcess.do", method = RequestMethod.POST)
    public ModelAndView loginProcess(UsersVo user, HttpSession session, HttpServletRequest request) {
        ModelAndView mav = new ModelAndView();
        UsersVo loginUser = null;
		try {
			loginUser = usersService.loginUsers(user);
		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		if(loginUser==null){
			session.setAttribute("loginFail", "Y");
        	mav.setViewName("redirect:login.do");
		}
		else if (loginUser.getUserSection() == 1) {
            session.setAttribute("userLoginInfo", loginUser);
            mav.setViewName("redirect:index.do");
        }
        else if(loginUser.getUserSection() == 2){
        	session.setAttribute("userLoginInfo", loginUser);
            mav.setViewName("redirect:orderManagement.do");
        }
        else if(loginUser.getUserSection() == 3){
        	session.setAttribute("userLoginInfo", loginUser);
            mav.setViewName("redirect:index.do");
        }
        else{
        	session.setAttribute("loginFail", "Y");
        	mav.setViewName("redirect:login.do");
        }
        return mav;
        
    }
    
    //로그아웃
    @RequestMapping(value="logoutProcess.do")
    public ModelAndView logoutProcess(HttpSession session){
    	ModelAndView mav = new ModelAndView();
    	mav.setViewName("redirect:index.do");
    	session.invalidate();
    	return mav;
    }
    
	 // 구매자 회원가입
    @RequestMapping(value="signupBuyerProcess.do", method = RequestMethod.POST)
    public ModelAndView signupBuyerProcess(UsersVo vo,HttpSession session) {
    	ModelAndView mav = new ModelAndView();
    	mav.setViewName("redirect:signupBuyer.do");
    	boolean flag = false;
		try {
			flag = usersService.signupBuyer(vo);
		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
        if (flag != false) {
            session.setAttribute("signupProcess", "Y");
        }else{
        	session.setAttribute("signupProcess", "N");
        }
        return mav;
    }
    
	 // 판매자 회원가입
    @RequestMapping(value="signupSellerProcess.do", method = RequestMethod.POST)
    public ModelAndView signupSellerProcess(SellerVo sVo,HttpSession session) {
    	ModelAndView mav = new ModelAndView();
    	mav.setViewName("redirect:signupSeller.do");
    	boolean flag = false;
		try {
			flag = usersService.signupSeller(sVo);
		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
        if (flag != false) {
            session.setAttribute("signupProcess", "Y");
        }else{
        	session.setAttribute("signupProcess", "N");
        }
        return mav;
    }
    
    //회원정보변경
    @RequestMapping(value="updateUsersInfoProcess.do", method = RequestMethod.POST)
    public ModelAndView updateUsersInfoProcess(UsersVo vo,HttpSession session) {
    	ModelAndView mav = new ModelAndView();
    	mav.setViewName("redirect:userManagement.do");
    	boolean flag = false;
		try {
			flag = usersService.updateUsers(vo);
		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
        if (flag != false) {
            session.setAttribute("uUpdateProcess", "Y");
        }else{
        	session.setAttribute("uUpdateProcess", "N");
        }
        return mav;
    }
    
    //회원탈퇴
    @RequestMapping("deleteUsersProcess.do")
	public ModelAndView deleteUsers(UsersVo vo, HttpSession session) {
    	ModelAndView mav = new ModelAndView();
    	mav.setViewName("redirect:userManagement.do");
    	boolean flag = false;
		try {
			flag = usersService.deleteUsers(vo.getUserNo(),vo.getUserSection());
		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
        if (flag != false) {
            session.setAttribute("deleteUsersProcess", "Y");
        }else{
        	session.setAttribute("deleteUsersProcess", "N");
        }
        return mav;
    }
    
    
    
    
    @RequestMapping(value="index.do")
    public String showIndex(HttpSession session){
    	return "common/index";
    }
    
    @RequestMapping(value="login.do",method = {RequestMethod.GET, RequestMethod.POST})
    public String login(){
    	return "users/login";
    }
    
    @RequestMapping(value="chooseSignup.do")
    public String chooseSignup(){
    	return "users/chooseSignup";
    }
    
    @RequestMapping(value="signupSeller.do")
    public String sSignup(){
    	return "users/sSignup";
    }
    
    @RequestMapping(value="signupBuyer.do")
    public String bSignup(){
    	return "users/bSignup";
    }
    
    @RequestMapping(value="userManagement.do")
    public String userManagement(){
    	return "users/userManagement";
    }
    
    @RequestMapping(value="contact_us.do")
    public String contactUs(){
    	return "common/contact_us";
    }
    
}