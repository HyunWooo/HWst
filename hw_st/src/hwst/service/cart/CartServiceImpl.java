package hwst.service.cart;

import hwst.dao.cart.CartDao;
import hwst.domain.cart.CartVo;

import java.util.List;

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
	
	
	//장바구니에서 상품주문 시 상품정보 select
	@Override
	public List<CartVo> selectCartInfo(List<Integer> cartNo) throws Exception{
		List<CartVo> carts =  cartDao.selectCartByCartList(cartNo); // 해당 장바구니 번호의 데이터를 조회 
		
		//앞상품과 뒷상품의 상품옵션번호가 일치하면 뒷상품의 구매수량에 앞상품 구매수량을 합친다.
		for(int i=0; i<carts.size()-1; i++){
			if(carts.get(i).getProductOptionNo()==carts.get(i+1).getProductOptionNo()){//이부분 수정
				carts.get(i+1).setBuyAmount(carts.get(i).getBuyAmount() +carts.get(i+1).getBuyAmount());
				carts.remove(i);
				i = i-1;
			}
		}
		return carts;
	}
	
	
	//장바구니 추가
	@Override
	public boolean insertCart(List<Integer> productOptionNo,int userNo,List<Integer> buyAmount)throws Exception{
		int stat = 0;
		for(int i=0; i<productOptionNo.size(); i++){
			CartVo cVo = new CartVo(productOptionNo.get(i), userNo, buyAmount.get(i));
			stat += cartDao.insertCart(cVo);
		}
		if(stat==productOptionNo.size()){
			return true;
		}
		return false;
	}

	
	//해당 장바구니 삭제
	@Override
	public boolean deleteCart(int cartNo) throws Exception{
		
		if(cartDao.deleteCart(cartNo)>0){
			return true;
		}
		return false;
	}
	
	
	//장바구니 구매수량 수정
	@Override
	public boolean updateCartAmountByCartNo(List<Integer> cartNo, List<Integer> buyAmount, int updateBuyAmountStat) throws Exception{
		int stat = 0;
		for(int i=0; i<cartNo.size(); i++){
			if(cartNo.get(i)==updateBuyAmountStat){
				CartVo cVo = new CartVo(cartNo.get(i),buyAmount.get(i));
				stat = cartDao.updateCartAmountByCartNo(cVo);
			}
		}
		
		if(stat>0){
			return true;
		}
		return false;
	}
	
	
	
}
