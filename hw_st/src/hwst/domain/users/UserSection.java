package hwst.domain.users;

import hwst.dao.orders.OrdersDao;
import hwst.domain.orders.OrdersVo;

import java.util.List;
import java.util.Map;

public enum UserSection {

	UNREGISTER{
		public List<OrdersVo> selectOrdersAll(int userNo){
			return selectBuyerOrdersAll(userNo);
		}
		
		public Map<Integer, Integer> selectOrderGroupCount(int userNo) {
			return selectBuyerOrdGroupCnt(userNo);
		}
	},
	BUYER{
		public List<OrdersVo> selectOrdersAll(int userNo){
			return selectBuyerOrdersAll(userNo);
		}
		
		public Map<Integer, Integer> selectOrderGroupCount(int userNo) {
			return selectBuyerOrdGroupCnt(userNo);
		}
	}, 
	SELLER{
		public List<OrdersVo> selectOrdersAll(int userNo){
			return selectSellerOrdersAll(userNo);
		}
		
		public Map<Integer, Integer> selectOrderGroupCount(int userNo) {
			return selectSellerOrdGroupCnt(userNo);
		}
	},
	ADMIN{
		public List<OrdersVo> selectOrdersAll(int userNo){
			return selectBuyerOrdersAll(userNo);
		}
		
		public Map<Integer, Integer> selectOrderGroupCount(int userNo) {
			return selectBuyerOrdGroupCnt(userNo);
		}
	};

	public abstract List<OrdersVo> selectOrdersAll(int userNo);
	public abstract Map<Integer, Integer> selectOrderGroupCount(int userNo);
	
	private  OrdersDao ordersDao;
	
	public void setOrderDao(OrdersDao ordersDao) {
		this.ordersDao = ordersDao;
	}
	
	public List<OrdersVo> selectBuyerOrdersAll(int userNo){
		return ordersDao.selectOrdersAll(userNo);
	}
	
	public List<OrdersVo> selectSellerOrdersAll(int userNo){
		return ordersDao.selectSellerOrdersAll(userNo);
	}
	
	protected Map<Integer, Integer> selectSellerOrdGroupCnt(int userNo) {
		return ordersDao.selectSellerOrdGroupCnt(userNo);
	}
	
	protected Map<Integer, Integer> selectBuyerOrdGroupCnt(int userNo) {
		return ordersDao.selectBuyerOrdGroupCnt(userNo);
	}
	
}
