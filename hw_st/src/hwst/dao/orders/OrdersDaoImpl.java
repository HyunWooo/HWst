package hwst.dao.orders;

import hwst.domain.orders.OrdersVo;
import hwst.util.DBUtil;

import java.util.List;

import org.apache.ibatis.session.SqlSession;
import org.springframework.stereotype.Repository;

@Repository("ordersDao")
public class OrdersDaoImpl  implements OrdersDao {
	
	//주문정보 insert
	@Override
	public int insertOrders(OrdersVo ordersVo){
		SqlSession session = null;
		int stat = 0;
		try {
			System.out.println(ordersVo + "ordersVo");
			session = DBUtil.getSqlSession();
			stat = session.insert("orders.insertOrders",ordersVo);
		} finally {
			DBUtil.closeSqlSession(session);
		}
		return stat;
	}
	
	//가장최근에 insert한 유저번호의 주문번호 select
	@Override
	public int selectOrderNoByUserNo(int userNo){
		SqlSession session = null;
		int orderNo = 0;
		try {
			session = DBUtil.getSqlSession();
			orderNo = session.selectOne("orders.selectOrderNoByUserNo", userNo);
		} finally {
			DBUtil.closeSqlSession(session);
		}
		return orderNo;
	}
	
	//userNo별 주문항목 조회
	@Override
	public List<OrdersVo> selectOrdersAll(int userNo){
		SqlSession session = null;
		 List<OrdersVo> ordersVo = null;
		try {
			session = DBUtil.getSqlSession();
			ordersVo = session.selectList("orders.selectOrdersAll", userNo);
		} finally {
			DBUtil.closeSqlSession(session);
		}
		return ordersVo;
	}
	
	//orderNo를 group by하여 각 orderNo의 상품개수 조회
	@Override
	public List<OrdersVo> selectOrderNoGroupCount(int userNo){
		SqlSession session = null;
		 List<OrdersVo> ordersVo = null;
		try {
			session = DBUtil.getSqlSession();
			ordersVo = session.selectList("orders.selectOrderNoGroupCount", userNo);
		} finally {
			DBUtil.closeSqlSession(session);
		}
		return ordersVo;
	}
	
	//userNo별 주문항목 조회
		@Override
		public List<OrdersVo> selectSellerOrdersAll(int userNo){
			SqlSession session = null;
			 List<OrdersVo> ordersVo = null;
			try {
				session = DBUtil.getSqlSession();
				ordersVo = session.selectList("orders.selectSellerOrdersAll", userNo);
			} finally {
				DBUtil.closeSqlSession(session);
			}
			return ordersVo;
		}
		
		//orderNo를 group by하여 각 orderNo의 상품개수 조회
		@Override
		public List<OrdersVo> selectSellerGroupCount(int userNo){
			SqlSession session = null;
			 List<OrdersVo> ordersVo = null;
			try {
				session = DBUtil.getSqlSession();
				ordersVo = session.selectList("orders.selectSellerGroupCount", userNo);
			} finally {
				DBUtil.closeSqlSession(session);
			}
			return ordersVo;
		}
		
		
		//orderNo에 속해있는 productOptionNo와 buyAmount를 받아옴
		@Override
		public List<OrdersVo> selectByPrdOpNo(int orderNo){
			SqlSession session = null;
			 List<OrdersVo> ordersVo = null;
			try {
				session = DBUtil.getSqlSession();
				ordersVo = session.selectList("orders.selectByPrdOpNo", orderNo);
			} finally {
				DBUtil.closeSqlSession(session);
			}
			return ordersVo;
		}
		
	
	//해당 주문의 orderStat 변경
	@Override
	public int updateOrderStat(OrdersVo ordersVo)throws Exception{
		SqlSession session = null;
		int stat = 0;
		try {
			session = DBUtil.getSqlSession();
			stat = session.update("orders.updateOrderStat", ordersVo);
		} finally {
			DBUtil.closeSqlSession(session);
		}
		return stat;
	}
	

	//해당 주문의 orderStat 변경
	@Override
	public int deleteOrder(int orderNo)throws Exception{
		SqlSession session = null;
		int stat = 0;
		try {
			session = DBUtil.getSqlSession();
			stat = session.update("orders.deleteOrder", orderNo);
		} finally {
			DBUtil.closeSqlSession(session);
		}
		return stat;
	}
}
