package hwst.dao.orders;

import hwst.domain.orders.OrdersVo;

import java.util.List;
import java.util.Map;

import org.apache.ibatis.session.SqlSession;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

@Repository("ordersDao")
public class OrdersDaoImpl  implements OrdersDao {
	
	@Autowired
	private SqlSession sqlSession;
	
	
	//주문정보 insert
	@Override
	public int insertOrders(OrdersVo ordersVo){
		return sqlSession.insert("orders.insertOrders",ordersVo);
	}
	
	//가장최근에 insert한 유저번호의 주문번호 select
	@Override
	public int selectOrderNoByUserNo(int userNo){
		return sqlSession.selectOne("orders.selectOrderNoByUserNo", userNo);
	}
	
	//userNo별 주문항목 조회
	@Override
	public List<OrdersVo> selectOrdersAll(int userNo){
		return sqlSession.selectList("orders.selectBuyerOrdersAll", userNo);
	}
	
	//orderNo를 group by하여 각 orderNo의 상품개수 조회
	@Override
	public Map<Integer, Integer> selectBuyerOrdGroupCnt(int userNo){
		return sqlSession.selectMap("orders.selectBuyerOrdGroupCnt", userNo, "orderNo");
	}
	
	//userNo별 주문항목 조회
	@Override
	public List<OrdersVo> selectSellerOrdersAll(int userNo){
		System.out.println(sqlSession);
		return sqlSession.selectList("orders.selectSellerOrdersAll", userNo);
	}
	
	//orderNo를 group by하여 각 orderNo의 상품개수 조회
	@Override
	public Map<Integer, Integer> selectSellerOrdGroupCnt(int userNo){
		return sqlSession.selectMap("orders.selectSellerOrdGroupCnt", userNo, "orderNo");
	}
	
	
	//orderNo에 속해있는 productOptionNo와 buyAmount를 받아옴
	@Override
	public List<OrdersVo> selectByPrdOpNo(int orderNo){
		return sqlSession.selectList("orders.selectByPrdOpNo", orderNo);
	}
		
	
	//해당 주문의 orderStat 변경
	@Override
	public int updateOrderStat(OrdersVo ordersVo){
		return sqlSession.update("orders.updateOrderStat", ordersVo);
	}
	

	//해당 주문의 orderStat 변경
	@Override
	public int deleteOrder(int orderNo){
		return sqlSession.update("orders.deleteOrder", orderNo);
	}
	
	@Override
	public OrdersVo selectGradeFulfill(int userNo){
		return sqlSession.selectOne("orders.selectGradeFulfill", userNo);
	}
}
