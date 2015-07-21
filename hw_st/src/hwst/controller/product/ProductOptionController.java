package hwst.controller.product;

import hwst.domain.product.ProductOptionVo;
import hwst.service.product.ProductOptionService;

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
public class ProductOptionController {
	@Resource(name="productOptionService")
	private ProductOptionService productOptionService;
	
	
	    

	//상품옵션전체보기(해당상품번호와 일치하는)
	@RequestMapping(value="selectProductOptionAll.do", method = RequestMethod.GET)
	public ModelAndView selectProductOptionAll(int productNo, HttpSession session, HttpServletRequest request){
		List<ProductOptionVo> list=null;
		try {
			list = productOptionService.selectProductOptionAll(productNo);
		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		ModelAndView mv = new ModelAndView();
		mv.addObject("productOptionList", list);	
		mv.setViewName("product/productOption");
		return mv;
	}
	
	//상품상세페이지에서 선택한 상품옵션의 정보를 받아오기
		@RequestMapping(value="selectProductOptionByPoNo.do", method = RequestMethod.POST)
		public ModelAndView selectProductOptionByPoNo(@RequestParam("productOptionNo") List<Integer> productOptionNo, @RequestParam("buyAmount")List<Integer> buyAmount, HttpSession session, HttpServletRequest request){
			List<ProductOptionVo> list=null;
			try {
				list = productOptionService.selectProductOptionByPoNo(productOptionNo,buyAmount);
			} catch (Exception e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
			ModelAndView mv = new ModelAndView();
			mv.addObject("list", list);
			mv.setViewName("orders/order");
			return mv;
		}
}
