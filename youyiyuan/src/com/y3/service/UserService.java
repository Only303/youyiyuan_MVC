package com.y3.service;

import com.y3.entity.User;
import com.y3.util.PageUtil;

/**
 * 用户业务接口
 * @author Entity-G
 *
 */
public interface UserService {

	public int addUser(User user) throws Exception;//添加用户
	
	public int deleteUser(String uidStr) throws Exception;//删除用户
	
	public int updateUser(User user,int uid) throws Exception;//修改用户
	
	/**
	 * 查询用户数量
	 * @return
	 * @throws Exception
	 */
	int userCount() throws Exception;
	
	/**
	 * 查询（所有）用户信息：根据分页显示
	 * current:当前页码、pageSize:每页要显示的数目
	 * @return
	 * @throws Exception
	 */
	public PageUtil<User> findAllUserByPage(int currentPage,int pageSize) throws Exception;
	
	public User findUserByUid(int uid) throws Exception;//查询用户详细信息
	
	public User login(String username,String password) throws Exception;//用户登录功能
	
	public int register(User user) throws Exception;//注册功能
	
}
