package hwst.controller.orders;

import hwst.service.orders.OrdersService;

import java.util.List;

import javax.annotation.Resource;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpSession;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.servlet.ModelAndView;

@Controller
public class OrdersController {

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
			System.out.println(productOptionNo);
			System.out.println(buyAmount);
			System.out.println(totalPrice);
			System.out.println(receiverName);
			System.out.println(phone);
			System.out.println(postCode);
			System.out.println(address);
			System.out.println(checkoutInfo);
			System.out.println(userNo);
			System.out.println(grade);
			System.out.println(message);
			System.out.println(allTotalPrice);
			System.out.println(discountPrice);
			System.out.println(discountedTotalPrice);
			stat = ordersService.insertOrders(productOptionNo, buyAmount, totalPrice ,receiverName, phone, postCode, address, checkoutInfo, userNo, grade, message, allTotalPrice, discountPrice, discountedTotalPrice);
		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
		ModelAndView mv = new ModelAndView();
		mv.setViewName("redirect:orderComplete.do");
		session.setAttribute("insertOrdersStat", stat);
		System.out.println("stat은"+stat);
		
		return mv;
	}

	
	@RequestMapping(value="orderComplete.do")
    public String orderComplete(){
    	return "orders/orderComplete";
    }
}
