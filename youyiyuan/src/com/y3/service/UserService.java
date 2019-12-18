package com.y3.service;

import com.y3.entity.User;
import com.y3.util.PageUtil;

/**
 * �û�ҵ��ӿ�
 * @author Entity-G
 *
 */
public interface UserService {

	public int addUser(User user) throws Exception;//����û�
	
	public int deleteUser(String uidStr) throws Exception;//ɾ���û�
	
	public int updateUser(User user,int uid) throws Exception;//�޸��û�
	
	/**
	 * ��ѯ�û�����
	 * @return
	 * @throws Exception
	 */
	int userCount() throws Exception;
	
	/**
	 * ��ѯ�����У��û���Ϣ�����ݷ�ҳ��ʾ
	 * current:��ǰҳ�롢pageSize:ÿҳҪ��ʾ����Ŀ
	 * @return
	 * @throws Exception
	 */
	public PageUtil<User> findAllUserByPage(int currentPage,int pageSize) throws Exception;
	
	public User findUserByUid(int uid) throws Exception;//��ѯ�û���ϸ��Ϣ
	
	public User login(String username,String password) throws Exception;//�û���¼����
	
	public int register(User user) throws Exception;//ע�Ṧ��
	
}
