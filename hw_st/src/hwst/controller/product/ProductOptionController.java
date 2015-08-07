package hwst.controller.product;

import hwst.domain.product.ProductOptionVo;
import hwst.domain.users.UsersEnum.UserSection;
import hwst.domain.users.UsersVo;
import hwst.service.product.ProductOptionService;

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
public class ProductOptionController {

	@Resource(name="productOptionService")
	private ProductOptionService productOptionService;
	
	Logger logger = Logger.getLogger(this.getClass());
	    

	//상품옵션전체보기(해당상품번호와 일치하는)
	@RequestMapping(value="selectProductOptionAll.do", method = RequestMethod.GET)
	public ModelAndView selectProductOptionAll(int productNo, HttpSession session, HttpServletRequest request){
		List<ProductOptionVo> poList = null;
		try {
			poList = productOptionService.selectProductOptionAll(productNo);
		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		ModelAndView mv = new ModelAndView();
		mv.addObject("productOptionList", poList);	
		mv.setViewName("product/productOption");
		return mv;
	}
	
	//상품상세페이지에서 선택한 상품옵션의 정보를 받아오기
	@RequestMapping(value="selectProductOptionByPoNo.do", method = RequestMethod.POST)
	public ModelAndView selectProductOptionByPoNo(@RequestParam("productOptionNo") List<Integer> productOptionNo, @RequestParam("buyAmount")List<Integer> buyAmount, HttpSession session, HttpServletRequest request){
		List<ProductOptionVo> poList =null;
		try {
			poList  = productOptionService.selectProductOptionByPoNo(productOptionNo,buyAmount);
		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		ModelAndView mv = new ModelAndView();
		mv.addObject("list", poList );
		mv.setViewName("orders/order");
		return mv;
	}
	
		
		
	
	//해당 판매자가 등록한 상품목록을 조회
	@RequestMapping(value="selectRegisterPrdAll.do")
    public ModelAndView selectRegisterPrdAll(HttpSession session, HttpServletRequest request){
		List<ProductOptionVo> poList = new ArrayList<ProductOptionVo>();
		ModelAndView mv = new ModelAndView();
		UsersVo vo = (UsersVo)session.getAttribute("userLoginInfo");
		
		if(vo==null){
			mv.setViewName("users/login");
			return mv;
		}
		else if(vo.getUserSection() != UserSection.SELLER){
			mv.setViewName("common/404");
		}
		
		logger.info("안녕하세요! userNo "+ vo.getUserNo() + "입니다.");
		
		try {
			poList = productOptionService.selectRegisterPrdAll(vo.getUserNo());
		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		logger.info("안녕하세요!"+ poList + "입니다.");
		
		mv.addObject("list", poList);
		mv.setViewName("/product/productManagement");
		
		return mv;
	}
	
	
	//판매자가 해당 상품옵션의 정보를 변경
	@RequestMapping(value="udtPrdOption.do")
    public ModelAndView udtPrdQuantity(ProductOptionVo prdOption, HttpSession session, HttpServletRequest request){
		boolean stat=false;
		ModelAndView mv = new ModelAndView();
		int productNo = prdOption.getProductNo();
		try {
			stat = productOptionService.udtPrdOpAll(prdOption);
		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		logger.info("안녕하세요!"+ stat + "입니다.");
		
		if(stat==true){
			mv.setViewName("redirect:manageProductOption.do");
			mv.addObject("productNo", productNo);
			session.setAttribute("udt", true);
		}
		else{
			mv.setViewName("common/404");
		}
		
		return mv;
	}
	
	//해당 상품번호의 상품옵션정보를 select
	@RequestMapping(value="manageProductOption.do")
    public ModelAndView manageProductOption(int productNo, HttpSession session, HttpServletRequest request){
		ModelAndView mv = new ModelAndView();
		List<ProductOptionVo> poList = new ArrayList<ProductOptionVo>();
		
		try {
			poList = productOptionService.selectPrdOpByPrdNo(productNo);
		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
		mv.addObject("list", poList);
		request.setAttribute("productNo",productNo);
		mv.setViewName("product/udtProductOption");
		return mv;
	}
	
	
	
	//상품옵션 추가
	@RequestMapping(value="insertPrdOption.do")
    public ModelAndView insertPrdOption(HttpSession session, HttpServletRequest request, @RequestParam("productNo") List<Integer> productNo,
    @RequestParam("plusPOName") List<String> plusPOName, @RequestParam("plusOP") List<Integer> plusOP,
    @RequestParam("plusAddPrice") List<Integer> plusAddPrice, @RequestParam("plusProductAmount") List<Integer> plusProductAmount,
    @RequestParam("optionValue") List<Integer> optionValue, int userNo
    ){
		ModelAndView mv = new ModelAndView();
		boolean stat = false;
		mv.setViewName("common/404");
		
		try {
			stat = productOptionService.insertPrdOption(productNo,plusPOName,plusOP,plusAddPrice,plusProductAmount,optionValue, userNo);
		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
		if(stat){
			mv.setViewName("redirect:manageProductOption.do");
			mv.addObject("productNo", productNo.get(0));
		}
		return mv;
	}
	
	//해당 상품옵션 삭제
	@RequestMapping(value="delPrdOption.do")
    public ModelAndView delPrdOption(int productOptionNo, int productNo, HttpSession session, HttpServletRequest request){
		ModelAndView mv = new ModelAndView();
		boolean stat = false;
		mv.setViewName("common/404");
		
		try {
			stat = productOptionService.delPrdOption(productOptionNo);
		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
		if(stat){
			mv.setViewName("redirect:manageProductOption.do");
			mv.addObject("productNo", productNo);
		}
		return mv;
	}
}
