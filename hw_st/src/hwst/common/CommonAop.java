package hwst.common;

import hwst.domain.category.CategoryVo;
import hwst.domain.product.ProductVo;
import hwst.service.category.CategoryService;
import hwst.service.product.ProductService;

import java.util.ArrayList;
import java.util.List;

import javax.annotation.Resource;
import javax.servlet.http.HttpSession;

import org.aspectj.lang.JoinPoint;
import org.aspectj.lang.annotation.Aspect;
import org.aspectj.lang.annotation.Before;

@Aspect
public class CommonAop {

	@Resource(name="categoryService")
    private CategoryService categoryService;
	
	@Resource(name="productService")
	private ProductService productService;
	
	
	//show*로 시작하는 메소드가 실행되기 전에 이 메소드가 실행되어 카테고리와 상품리스트 세션구성
	@Before("execution(public * show*(..))")
	public void bringMainContets(JoinPoint joinPoint)throws Exception{
		Object[] args = joinPoint.getArgs();
		
		HttpSession session = (HttpSession)args[0];
		List<CategoryVo> upCategoryList = categoryService.selectUpCategory();
	 	List<CategoryVo> categoryList = categoryService.selectCategory();
	 	List<ProductVo> productList = new ArrayList<ProductVo>();
	 	List<ProductVo> lowPriceList = new ArrayList<ProductVo>();
		productList = productService.selectProductAll();
		lowPriceList = productService.selectPrdLow();
	 	 
    	session.setAttribute("upCategoryList", upCategoryList);
    	session.setAttribute("categoryList", categoryList);
    	session.setAttribute("productList", productList);
    	session.setAttribute("lowPriceList", lowPriceList);
    	
	}
    	
}
