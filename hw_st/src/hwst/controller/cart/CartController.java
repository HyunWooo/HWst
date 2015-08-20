package hwst.controller.cart;

import hwst.domain.cart.CartVo;
import hwst.domain.users.UsersVo;
import hwst.service.cart.CartService;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import javax.annotation.Resource;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpSession;

import org.apache.log4j.Logger;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.servlet.ModelAndView;

@Controller
public class CartController {
	
	Logger logger = Logger.getLogger(this.getClass());
	
	@Resource(name="cartService")
    private CartService cartService;
	
	
	//모든장바구니 보기
	@RequestMapping(value="allCartView.do", method = RequestMethod.GET)
	public ModelAndView selectCartAll(HttpSession session, HttpServletRequest request){
		List<CartVo> list = null;
		ModelAndView mv = new ModelAndView();
		UsersVo vo = (UsersVo)session.getAttribute("userLoginInfo");
		
		if(vo==null){
			mv.setViewName("users/login");
			return mv;
		}
		
		int userNo = vo.getUserNo();
		logger.info("안녕하세요! userNo "+ userNo + "입니다.");
		
		try {
			list = cartService.selectCartAll(userNo);
		} catch (Exception e) {
			e.printStackTrace();
		}
		logger.info("안녕하세요!"+ list + "입니다.");
		
		mv.addObject("list", list);	
		mv.setViewName("/cart/cart");
		session.setAttribute("productViewStat", "all");
		return mv;
	}
	
	//체크박스로 선택한 장바구니 or 전체장바구니정보 select  
	@SuppressWarnings("unchecked")
	@RequestMapping(value="selectBySelectedCartList.do", method = RequestMethod.POST)
	public ModelAndView selectBySelectedCartList(@RequestParam("cartNo")List<Integer> cartNo, HttpSession session, HttpServletRequest request){
		
		Map<String, Object> mp = new HashMap<String, Object>();
		List<Integer> deletedCarts = new ArrayList<Integer>();
		List<CartVo> list = null;
		ModelAndView mv = new ModelAndView();
		UsersVo vo = (UsersVo)session.getAttribute("userLoginInfo");

		if(vo==null){
			mv.setViewName("users/login");
			return mv;
		}
		
		logger.info("안녕하세요! cartNo "+ cartNo + "입니다.");
		
		try {
			mp = cartService.selectCartInfo(cartNo);
			list = (List<CartVo>) mp.get("CartList");
			deletedCarts = (List<Integer>) mp.get("DeletedCartList");
		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		logger.info("안녕하세요!"+ list + "입니다.");
		
		mv.addObject("list", list);
		mv.addObject("DeletedCartList",deletedCarts);
		mv.setViewName("orders/order");
		session.setAttribute("productViewStat", "yes");
		return mv;
	}
	
	
	//장바구니 추가
	@RequestMapping(value="insertCart.do", method = RequestMethod.POST)
	public ModelAndView insertCart(HttpSession session, HttpServletRequest request,
		@RequestParam("productOptionNo") List<Integer> productOptionNo, 
	    @RequestParam("buyAmount")List<Integer> buyAmount,  int userNo){
		boolean stat = false;
		
		try {
			stat = cartService.insertCart(productOptionNo, userNo, buyAmount);
		} catch (Exception e) {
			e.printStackTrace();
		}
		logger.info("안녕하세요!"+ stat + "입니다.");
		ModelAndView mv = new ModelAndView();
		mv.setViewName("redirect:"+request.getHeader("referer"));
		session.setAttribute("insertCartStat", stat);
		return mv;
	}
	
	//장바구니 삭제
	@RequestMapping(value="deleteCart.do", method = RequestMethod.POST)
	public ModelAndView deleteCart(int cartNo, HttpSession session, HttpServletRequest request){
		logger.info("안녕하세요! cartNo "+ cartNo + "입니다.");
		boolean stat = false;
		
		try {
			stat = cartService.deleteCart(cartNo);
		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		logger.info("안녕하세요!"+ stat + "입니다.");
		ModelAndView mv = new ModelAndView();
		mv.setViewName("redirect:allCartView.do");
		session.setAttribute("deleteCartStat", stat);
		return mv;
	}
	
	//장바구니 수량 수정
	@RequestMapping(value="updateCartAmount.do", method = RequestMethod.POST)
	public ModelAndView updateCartAmount(HttpSession session, HttpServletRequest request,CartVo cartVo){
		logger.info("안녕하세요! updateBuyAmountStat "+ cartVo + "입니다.");
		boolean stat = false;
		
		try {
			stat = cartService.updateCartAmount(cartVo);
		} catch (Exception e) {
			e.printStackTrace();
		}
		logger.info("안녕하세요!"+ stat + "입니다.");
		ModelAndView mv = new ModelAndView();
		mv.setViewName("redirect:allCartView.do");
		session.setAttribute("updateCartAmountByCartNo", stat);
		return mv;
	}
	



}
