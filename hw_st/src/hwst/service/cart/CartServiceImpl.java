package hwst.service.cart;

import hwst.common.CommonMethod;
import hwst.dao.cart.CartDao;
import hwst.domain.cart.CartVo;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

import javax.annotation.Resource;

import org.springframework.stereotype.Service;

@Service("cartService")
public class CartServiceImpl implements CartService {

	@Resource(name="cartDao")
	private CartDao cartDao;
	
	
	//장바구니항목 전체불러오기
	@Override
	public List<CartVo> selectCartAll(int userNo)throws Exception{
		return cartDao.selectCartAll(userNo);
	}
	
	
	//장바구니에서 상품들 주문 시 해당상품들의 정보 select해오기
	@Override
	public Map<String, Object> selectCartInfo(List<Integer> cartNo) throws Exception{
		Map<String, Object> mp = new HashMap<String, Object>();
		List<CartVo> carts =  cartDao.selectCartInfo(cartNo); // 해당 장바구니 번호의 데이터를 조회 
		
		mp.put("DeletedCartList", cartNo);
		
		//앞상품과 뒷상품의 상품옵션번호가 일치하면 뒷상품의 구매수량에 앞상품 구매수량을 합친다.
		for(int num=0; num<carts.size()-1; num++){
			if(isEqPrdOpNo(carts.get(num),carts.get(num+1))){
				carts.get(num+1).setBuyAmount(carts.get(num),carts.get(num+1));
				carts.remove(num);
				num = num-1;
			}
		}
		mp.put("CartList", carts);
		return mp;
	}
	
	
	//장바구니 추가
	@Override
	public boolean insertCart(List<Integer> productOptionNo,int userNo,List<Integer> buyAmount)throws Exception{
		int stat = 0;
		
		for(int num=0; num<productOptionNo.size(); num++){
			stat += cartDao.insertCart(new CartVo(productOptionNo.get(num), userNo, buyAmount.get(num)));
		}
		
		return CommonMethod.isEqualValues(stat, productOptionNo.size());
	}

	
	//해당 장바구니 삭제
	@Override
	public boolean deleteCart(int cartNo) throws Exception{
		return CommonMethod.isSuccessOneCUD(cartDao.deleteCart(cartNo));
	}
	
	
	//장바구니 구매수량 수정
	@Override
	public boolean updateCartAmount(CartVo cartVo) throws Exception{
		return CommonMethod.isSuccessOneCUD(cartDao.updateCartAmount(cartVo));
	}
	
	
	//상품옵션번호가 같은지 체크
	public boolean isEqPrdOpNo(CartVo cart1, CartVo cart2){
		return CommonMethod.isEqualValues(cart1.getProductOptionNo(), cart2.getProductOptionNo());
	}
	
	
}
