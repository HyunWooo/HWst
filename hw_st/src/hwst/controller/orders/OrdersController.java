package hwst.controller.orders;

import hwst.domain.orders.OrdersVo;
import hwst.domain.users.UsersEnum.UserSection;
import hwst.domain.users.UsersVo;
import hwst.service.orders.OrdersService;

import java.util.List;

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
public class OrdersController {

	Logger logger = Logger.getLogger(this.getClass());
	
	@Resource(name="ordersService")
    private OrdersService ordersService;
	
	//주문등록
	@RequestMapping(value="insertOrders.do", method = RequestMethod.POST)
	public ModelAndView insertOrders(HttpSession session, HttpServletRequest request,
			@RequestParam("productOptionNo") List<Integer> productOptionNo, 
			@RequestParam("buyAmount") List<Integer> buyAmount,
			@RequestParam("totalPrice") List<Integer> totalPrice,
			@RequestParam("receiverName") String receiverName, 
			@RequestParam("phone") String phone, 
			@RequestParam("postCode") String postCode, 
			@RequestParam("address") String address, 
			@RequestParam("checkout_Info") int checkoutInfo,
			@RequestParam("userNo") int userNo,
			@RequestParam("grade") int grade,
			@RequestParam("message") String message,
			@RequestParam("allTotalPrice") String allTotalPrice,
			@RequestParam("discountPrice") String discountPrice,
			@RequestParam("discountedTotalPrice") String discountedTotalPrice){
		
		
		boolean stat = false;
		
		try {
			String fromCart = (String)session.getAttribute("productViewStat");
			OrdersVo ordersVo = new OrdersVo(userNo, receiverName, phone, postCode, address, message, grade, allTotalPrice, discountPrice, discountedTotalPrice);
			stat = ordersService.insertOrders(ordersVo,productOptionNo, buyAmount, totalPrice, checkoutInfo, fromCart);
		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
		ModelAndView mv = new ModelAndView();
		mv.setViewName("redirect:orderComplete.do");
		session.setAttribute("insertOrdersStat", stat);
		
		return mv;
	}

	//해당 userNo의 주문내역을 조회
	@RequestMapping(value="orderManagement.do")
    public ModelAndView selectOrdersAll(HttpSession session, HttpServletRequest request){
		List<OrdersVo> list = null;
		ModelAndView mv = new ModelAndView();
		UsersVo vo = (UsersVo)session.getAttribute("userLoginInfo");
		
		if(vo==null){
			mv.setViewName("users/login");
			return mv;
		}
		logger.info("안녕하세요! userNo "+ vo.getUserNo() + "입니다.");
		
		try {
			list = ordersService.selectOrdersAll(vo);
		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		logger.info("안녕하세요!"+ list + "입니다.");
		
		mv.addObject("list", list);
		
		//구매자,판매자별로 setViewName 분기해야됨
		if(vo.getUserSection() == UserSection.BUYER){
			mv.setViewName("/orders/buyerOrderManagement");
		}
		else if(vo.getUserSection() == UserSection.SELLER){
			mv.setViewName("/orders/sellerOrderManagement");
		}
		
		return mv;
	}
	
	//해당 OrderNo의 주문상태를 변경
	@RequestMapping(value="updateOrderStat.do", method = RequestMethod.POST)
    public ModelAndView updateOrderStat(int orderNo, int orderStat, HttpSession session, HttpServletRequest request){
		boolean stat=false;
		ModelAndView mv = new ModelAndView();
		
		mv.setViewName("common/404");
		
		try {
			stat = ordersService.updateOrderStat(orderNo,orderStat);
		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		if(stat==true){
				mv.setViewName("redirect:orderManagement.do");
		}
		return mv;
	}

	
	//해당 OrderNo의 주문상태를 변경
	@RequestMapping(value="udtDeliveryStat.do", method = RequestMethod.POST)
    public ModelAndView udtDeliveryStat(int orderNo, int productOptionNo, int deliveryStat, HttpSession session, HttpServletRequest request){
		boolean stat=false;
		ModelAndView mv = new ModelAndView();
		mv.setViewName("common/404");
		
		try {
			stat = ordersService.udtDeliveryStat(orderNo,productOptionNo,deliveryStat);
		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		if(stat==true){
				mv.setViewName("redirect:orderManagement.do");
		}
		return mv;
	}
	
	
	//해당 OrderNo의 주문을 삭제
	@RequestMapping(value="deleteOrder.do", method = RequestMethod.POST)
    public ModelAndView deleteOrder(int orderNo, HttpSession session, HttpServletRequest request){
		boolean stat=false;
		ModelAndView mv = new ModelAndView();
		
		mv.setViewName("common/404");
		
		try {
			stat = ordersService.deleteOrder(orderNo);
		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		if(stat==true){
			mv.setViewName("redirect:orderManagement.do");
		}
		
		return mv;
	}
	
	
	
	
	
	
	
	
	@RequestMapping(value="orderComplete.do")
    public String orderComplete(){
    	return "orders/orderComplete";
    }
}
