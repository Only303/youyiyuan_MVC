package com.y3.dao;

import com.y3.entity.Admin;

/**
 * ����Ա���ݲ�����ӿ�
 * @author Entity-G
 */
public interface AdminDao {

	//��¼
	Admin login(String a_name, String a_pwd) throws Exception;
	
}
