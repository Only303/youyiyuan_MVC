package com.y3.dao;

import java.util.List;

import com.y3.entity.OrdersDetail;
import com.y3.entity.OrdersDetailVo;

/**
 * ͼ�鶩���������ݲ�ӿ�
 * @author Entity-G
 */
public interface OrdersDetailDao {

	int addOrdersDetail(OrdersDetail od) throws Exception;//��Ӷ�������
	
	List<OrdersDetailVo> findOrdersDetailVoByUid(int uid) throws Exception;//��ѯ���������������Ϣ�������û����
	
}
