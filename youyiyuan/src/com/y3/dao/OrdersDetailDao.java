package com.y3.dao;

import java.util.List;

import com.y3.entity.OrdersDetail;
import com.y3.entity.OrdersDetailVo;

/**
 * 图书订单详情数据层接口
 * @author Entity-G
 */
public interface OrdersDetailDao {

	int addOrdersDetail(OrdersDetail od) throws Exception;//添加订单详情
	
	List<OrdersDetailVo> findOrdersDetailVoByUid(int uid) throws Exception;//查询订单详情所需的信息：根据用户编号
	
}
