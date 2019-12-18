package com.y3.dao;

import com.y3.entity.Cart;

/**
 * ���ﳵ���ݲ�ӿ�
 * @author Entity-G
 *
 */
public interface CartDao {

	/**
	 * ��ӹ��ﳵ
	 * @param cart
	 * @return
	 * @throws Exception
	 */
	int addCart(Cart cart) throws Exception;
	
	int updateCart(Cart cart) throws Exception;//�޸Ĺ��ﳵ
	
	int deleteCart(int cid) throws Exception;//���ݹ��ﳵ���ɾ�����ﳵ��Ϣ
	
	int deleteCart(int uid,int b_id) throws Exception;//���ݹ��ﳵ���ɾ�����ﳵ��Ϣ
	
}
