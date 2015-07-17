package hwst.controller.order;

import hwst.service.order.OrderService;

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
public class OrderController {

	@Resource(name="orderService")
    private OrderService orderService;
	
	//주문등록
	@RequestMapping(value="insertOrder.do", method = RequestMethod.POST)
	public ModelAndView insertCart(HttpSession session, HttpServletRequest request,
			@RequestParam("productOptionNo") List<Integer> productOptionNo, 
			@RequestParam("buyAmount") List<Integer> buyAmount,
			@RequestParam("totalPrice") List<Integer> totalPrice,
			@RequestParam("receiverName") String receiverName, 
			@RequestParam("phone") String phone, 
			@RequestParam("postCode") String postCode, 
			@RequestParam("address") String address, 
			@RequestParam("checkout_Info") String checkout_Info,
			@RequestParam("userNo") int userNo,
			@RequestParam("grade") int grade,
			@RequestParam("message") String message,
			@RequestParam("allTotalPrice") String allTotalPrice,
			@RequestParam("discountPrice") String discountPrice,
			@RequestParam("discountedTotalPrice") String discountedTotalPrice){
		
		System.out.println(productOptionNo);
		System.out.println(buyAmount);
		System.out.println(totalPrice);
		System.out.println(receiverName);
		System.out.println(phone);
		System.out.println(postCode);
		System.out.println(address);
		System.out.println(checkout_Info);
		System.out.println(userNo);
		System.out.println(grade);
		System.out.println(message);
		System.out.println(allTotalPrice);
		System.out.println(discountPrice);
		System.out.println(discountedTotalPrice);
		//여기까지함
		
		ModelAndView mv = null;
		return mv;
	}

}
