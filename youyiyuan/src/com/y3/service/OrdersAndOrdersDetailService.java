package com.y3.service;

import java.sql.Timestamp;
import java.util.List;

import com.y3.entity.OrdersDetailVo;
import com.y3.entity.OrdersVo;
import com.y3.util.PageUtil;

/**
 * �ύ����
 * �Թ��ﳵ������������������ҵ�����
 * @author Entity-G
 *
 */
public interface OrdersAndOrdersDetailService {

	/**
	 * �ύ����ʱ��ҵ�����
	 * 1.�������������
	 * 2.����������������
	 * 3.���ﳵɾ����¼
	 */
	void submitOrders(String oid,String cidStr,int uid,double total,String uremark,String address,Timestamp otime) throws Exception;
	
	/**
	 * ��������ʱ����
	 * @throws Exception
	 */
	void addOrdersAndOrdersDetail(String oid,int uid,String uremark,String address,Timestamp otime,int b_id,int count,double totalPrice) throws Exception;
	
	/**
	 * ��ѯ���������������Ϣ�������û����
	 * @param uid
	 * @return
	 * @throws Exception
	 */
	List<OrdersDetailVo> findOrdersDetailVoByUid(int uid) throws Exception;
	
	/**
	 * ��̨չʾ���ж���--��ҳ
	 * @return
	 * @throws Exception
	 */
	PageUtil<OrdersVo> findAllOrdersByPage(int currentPage,int pageSize) throws Exception;
	
	/**
	 * ��ȡ��������
	 * @return
	 */
	int findOrdersCount() throws Exception;
	
}
