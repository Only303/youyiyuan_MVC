package com.y3.service;

import com.y3.entity.Admin;
/**
 * ����Աҵ���ӿ�
 * @author Entity-G
 */
public interface AdminService {
	//��¼
	Admin login(String a_name, String a_pwd) throws Exception;
}
