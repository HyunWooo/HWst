package hwst.controller.product;

import hwst.domain.product.ProductOptionVo;
import hwst.domain.product.ProductVo;
import hwst.domain.users.UsersVo;
import hwst.service.product.ProductOptionService;
import hwst.service.product.ProductService;
import hwst.service.users.UsersService;

import java.sql.SQLException;
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
	
	@Resource(name="usersService")
    private UsersService usersService;
	
	@Resource(name="productOptionService")
    private ProductOptionService productOptionService;
	
	
	//상품전체보기(현재는 최근등록순 정렬)
	@RequestMapping(value="allProductView.do", method = RequestMethod.GET)
	public ModelAndView showSelectProductAll(HttpSession session, HttpServletRequest request){
		List<ProductVo> list =  productService.selectProductAll();
		request.setAttribute("pg",1);
		System.out.println(list);
		ModelAndView mv = new ModelAndView();
		mv.addObject("list", list);	
		mv.setViewName("product/product");
		session.setAttribute("productViewStat", "all");
		return mv;
	}
	
	//상품상세보기
	@RequestMapping(value="viewProductDetails.do", method = RequestMethod.GET)
	public ModelAndView showSelectProductDetails(HttpSession session, HttpServletRequest request,int productNo){
		ProductVo productVo =  productService.selectProductDetails(productNo);
		UsersVo sellerInfo = null;
		try {
			sellerInfo = usersService.selectUserOne(productVo.getUserNo());
		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		List<ProductOptionVo> productOptionList =  productOptionService.selectProductOptionAll(productVo.getProductNo());
		System.out.println("productOptionList"+productOptionList);
		
		ModelAndView mv = new ModelAndView();
		mv.addObject("product", productVo);
		mv.addObject("sellerInfo", sellerInfo);
		mv.addObject("productOptionList", productOptionList);
		mv.setViewName("product/product_details");	
		return mv;
	}
	
	//키워드검색
	@RequestMapping(value="selectProductByKeyword.do", method = RequestMethod.POST)
	public ModelAndView showSelectProductByKeyword(HttpSession session, HttpServletRequest request,String keyword){
		System.out.println("컨트롤러 "+keyword);
		List<ProductVo> list =  productService.selectProductByKeyword(keyword);
		System.out.println(list);
		request.setAttribute("pg",1);
		ModelAndView mv = new ModelAndView();
		mv.addObject("list", list);	
		mv.setViewName("product/product");	
		session.setAttribute("productViewStat", "searchKeyword");
		return mv;
	}

	//카테고리검색
	@RequestMapping(value="selectProductByCategory.do", method = RequestMethod.GET)
	public ModelAndView showSelectProductByCategory(HttpSession session, HttpServletRequest request,int categoryNo){
		System.out.println("컨트롤러 "+categoryNo);
		List<ProductVo> list =  productService.selectProductByCategory(categoryNo);
		System.out.println(list);
		request.setAttribute("pg",1);
		ModelAndView mv = new ModelAndView();
		mv.addObject("list", list);	
		mv.setViewName("product/product");	
		session.setAttribute("productViewStat", "searchCategory");
		return mv;
	}
}
