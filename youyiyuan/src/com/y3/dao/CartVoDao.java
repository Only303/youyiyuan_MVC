package com.y3.dao;

import java.util.List;

import com.y3.entity.CartVo;

/**
 * ���ݲ㹺�ﳵ�嵥չʾ�ӿ�
 * @author Entity-G
 *
 */
public interface CartVoDao {

	List<CartVo> findAllCartVoByUid(int uid) throws Exception;//��ѯ��չʾ���ﳵ�嵥
	
	List<CartVo> findCheckedCartByCid(String cidStr) throws Exception;//���ݹ��ﳵ���cidStr��ѯѡ��Ҫ�������Ʒ����ӵ�����
	
	CartVo findCheckedCartByCid(int cid) throws Exception;//���ݹ��ﳵ���cid��ѯѡ��Ҫ�������Ʒ����ӵ�����
	
	int deleteCartVo(String cidStr) throws Exception;//����cidStrɾ�����ﳵ��Ϣ
	
}
