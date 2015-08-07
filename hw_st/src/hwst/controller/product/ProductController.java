package hwst.controller.product;

import hwst.domain.product.ProductOptionVo;
import hwst.domain.product.ProductVo;
import hwst.domain.users.UsersVo;
import hwst.service.category.CategoryService;
import hwst.service.product.ProductOptionService;
import hwst.service.product.ProductService;
import hwst.service.users.UsersService;

import java.util.ArrayList;
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
public class ProductController {

	@Resource(name="productService")
    private ProductService productService;
	
	@Resource(name="usersService")
    private UsersService usersService;
	
	@Resource(name="productOptionService")
    private ProductOptionService productOptionService;
	
	@Resource(name="categoryService")
    private CategoryService categoryService;
	
	Logger logger = Logger.getLogger(this.getClass());
	
	//상품전체보기(현재는 최근등록순 정렬)
	@RequestMapping(value="allProductView.do", method = RequestMethod.GET)
	public ModelAndView showSelectProductAll(HttpSession session, HttpServletRequest request){
		List<ProductVo> list = new ArrayList<ProductVo>();
		try {
			list = productService.selectProductAll();
		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		request.setAttribute("pg",1);
		ModelAndView mv = new ModelAndView();
		mv.addObject("list", list);	
		mv.setViewName("product/product");
		session.setAttribute("productViewStat", "all");
		return mv;
	}
	
	//상품상세보기
	@RequestMapping(value="viewProductDetails.do", method = RequestMethod.GET)
	public ModelAndView showSelectProductDetails(HttpSession session, HttpServletRequest request,int productNo){
		ProductVo productVo = new ProductVo();
		try {
			productVo = productService.selectProductDetails(productNo);
		} catch (Exception e1) {
			// TODO Auto-generated catch block
			e1.printStackTrace();
		}
		UsersVo sellerInfo = null;
		List<ProductOptionVo> productOptionList=null;
		
		try {
			sellerInfo = usersService.selectUserOne(productVo.getUserNo());
			productOptionList = productOptionService.selectProductOptionAll(productVo.getProductNo());
		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
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
		List<ProductVo> list = new ArrayList<ProductVo>();
		try {
			list = productService.selectProductByKeyword(keyword);
		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
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
		List<ProductVo> list = new ArrayList<ProductVo>();
		try {
			list = productService.selectProductByCategory(categoryNo);
		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		request.setAttribute("pg",1);
		ModelAndView mv = new ModelAndView();
		mv.addObject("list", list);	
		mv.setViewName("product/product");	
		session.setAttribute("productViewStat", "searchCategory");
		return mv;
	}
	
	//상품추가 실행
	@RequestMapping(value="insertPrd.do")
	public ModelAndView insertPrd(HttpSession session, HttpServletRequest request,
		    @RequestParam("plusPOName") List<String> plusPOName, @RequestParam("plusOP") List<Integer> plusOP,
		    @RequestParam("plusAddPrice") List<Integer> plusAddPrice, @RequestParam("plusProductAmount") List<Integer> plusProductAmount,
		    @RequestParam("optionValue") List<Integer> optionValue, int userNo, ProductVo prdVo){
		int productNo = 0;
		boolean stat = false;
		
		try {
			productNo = productService.insertPrd(prdVo);
			stat = productOptionService.insertPrdOptionB(productNo,plusPOName,plusOP,plusAddPrice,plusProductAmount,optionValue, userNo);
		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
		ModelAndView mv = new ModelAndView();
		mv.setViewName("common/404");	
		
		if(stat==true){
			mv.setViewName("redirect:selectRegisterPrdAll.do");	
		}
		return mv;
	}
	
	
	
	//상품등록페이지로 이동
	@RequestMapping(value="registerProduct.do")
	public ModelAndView registerProduct(HttpSession session, HttpServletRequest request){
		ModelAndView mv = new ModelAndView();
		mv.setViewName("product/registerProduct");
		return mv;
	}
	
	@RequestMapping(value="productManagement.do")
	public String productManagement(){
		return "product/productManagement";
	}
}
