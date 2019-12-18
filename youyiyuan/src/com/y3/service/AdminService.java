package com.y3.service;

import com.y3.entity.Admin;
/**
 * 管理员业务层接口
 * @author Entity-G
 */
public interface AdminService {
	//登录
	Admin login(String a_name, String a_pwd) throws Exception;
}
