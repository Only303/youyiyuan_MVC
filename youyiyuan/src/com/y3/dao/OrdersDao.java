package com.y3.dao;

import java.util.List;

import com.y3.entity.Orders;
import com.y3.entity.OrdersVo;

/**
 * 图书订单数据层接口
 * @author Entity-G
 *
 */
public interface OrdersDao {

	int addOrders(Orders orders) throws Exception;//添加订单
	
	/**
	 * 后台展示所有订单--分页
	 * @return
	 * @throws Exception
	 */
	List<OrdersVo> findAllOrdersByPage(int currentPage,int pageSize) throws Exception;
	
	/**
	 * 获取订单数量
	 * @return
	 */
	int findOrdersCount() throws Exception;
	
}
