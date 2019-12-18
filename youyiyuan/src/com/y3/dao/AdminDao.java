package com.y3.dao;

import com.y3.entity.Admin;

/**
 * 管理员数据层操作接口
 * @author Entity-G
 */
public interface AdminDao {

	//登录
	Admin login(String a_name, String a_pwd) throws Exception;
	
}
