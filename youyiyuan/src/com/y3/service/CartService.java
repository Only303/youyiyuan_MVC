package com.y3.service;

import com.y3.entity.Cart;

/**
 * ���ﳵҵ���ӿ�
 * @author Entity-G
 *
 */
public interface CartService {
	
	int addCart(Cart cart) throws Exception;//��ӹ��ﳵ
	
	int updateCart(Cart cart) throws Exception;//�޸Ĺ��ﳵ
	
	int deleteCart(int cid) throws Exception;//���ݹ��ﳵ���ɾ�����ﳵ��Ϣ
	
	int deleteCart(int uid,int b_id) throws Exception;//���ݹ��ﳵ���ɾ�����ﳵ��Ϣ
	
}
