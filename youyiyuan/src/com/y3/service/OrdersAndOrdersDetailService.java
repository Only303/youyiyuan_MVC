package com.y3.service;

import java.sql.Timestamp;
import java.util.List;

import com.y3.entity.OrdersDetailVo;
import com.y3.entity.OrdersVo;
import com.y3.util.PageUtil;

/**
 * 提交订单
 * 对购物车表、订单表、订单详情表的业务操作
 * @author Entity-G
 *
 */
public interface OrdersAndOrdersDetailService {

	/**
	 * 提交订单时的业务操作
	 * 1.订单表添加数据
	 * 2.订单详情表添加数据
	 * 3.购物车删除记录
	 */
	void submitOrders(String oid,String cidStr,int uid,double total,String uremark,String address,Timestamp otime) throws Exception;
	
	/**
	 * 立即购买时触发
	 * @throws Exception
	 */
	void addOrdersAndOrdersDetail(String oid,int uid,String uremark,String address,Timestamp otime,int b_id,int count,double totalPrice) throws Exception;
	
	/**
	 * 查询订单详情所需的信息：根据用户编号
	 * @param uid
	 * @return
	 * @throws Exception
	 */
	List<OrdersDetailVo> findOrdersDetailVoByUid(int uid) throws Exception;
	
	/**
	 * 后台展示所有订单--分页
	 * @return
	 * @throws Exception
	 */
	PageUtil<OrdersVo> findAllOrdersByPage(int currentPage,int pageSize) throws Exception;
	
	/**
	 * 获取订单数量
	 * @return
	 */
	int findOrdersCount() throws Exception;
	
}
