package hwst.controller;

import hwst.domain.ProductVo;
import hwst.service.ProductService;

import java.util.List;

import javax.annotation.Resource;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpSession;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.servlet.ModelAndView;

@Controller
public class ProductController {

	@Resource(name="productService")
    private ProductService productService;
	
	@RequestMapping(value="allProductView.do", method = RequestMethod.GET)
	public ModelAndView selectProductAll(HttpSession session, HttpServletRequest request){
		List<ProductVo> list =  productService.selectProductAll();
		System.out.println(list);
		session.setAttribute("productList", list);
		ModelAndView mv = new ModelAndView();
		mv.addObject("list", list);	
		mv.setViewName("redirect:product.do?pg=1");	
		return mv;
	}
	
	
	
	 @RequestMapping(value="product.do")
	    public String product(){
	    	return "product";
	    }
	

}
