package com.y3.dao;

import java.util.List;

import com.y3.entity.Orders;
import com.y3.entity.OrdersVo;

/**
 * ͼ�鶩�����ݲ�ӿ�
 * @author Entity-G
 *
 */
public interface OrdersDao {

	int addOrders(Orders orders) throws Exception;//��Ӷ���
	
	/**
	 * ��̨չʾ���ж���--��ҳ
	 * @return
	 * @throws Exception
	 */
	List<OrdersVo> findAllOrdersByPage(int currentPage,int pageSize) throws Exception;
	
	/**
	 * ��ȡ��������
	 * @return
	 */
	int findOrdersCount() throws Exception;
	
}
