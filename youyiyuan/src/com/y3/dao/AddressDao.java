package com.y3.dao;

import com.y3.entity.Address;

/**
 * ��ַ���ݲ�
 * @author Entity-G
 */
public interface AddressDao {
	
	Address findAddressByAdd_id(int add_id) throws Exception;//��ѯ���ݵ�ַ
	
}
