package com.y3.service;

import java.util.List;

import com.y3.entity.CartVo;

/**
 * ͨ���û�id��Ѱ
 * ҵ��㹺�ﳵ�嵥չʾ�ӿ�
 * @author Entity-G
 *
 */
public interface CartVoService {

	List<CartVo> findAllCartVoByUid(int uid) throws Exception;//��ѯ��չʾ���ﳵ�嵥
	
	List<CartVo> findCheckedCartByCid(String cidStr) throws Exception;//���ݹ��ﳵ���cid��ѯѡ��Ҫ�������Ʒ����ӵ�����
	
}
