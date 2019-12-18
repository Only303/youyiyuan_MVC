package com.y3.serviceImpl;

import java.util.List;

import com.y3.dao.UserDao;
import com.y3.daoImpl.UserDaoImpl;
import com.y3.entity.User;
import com.y3.service.UserService;
import com.y3.util.DBFactory;
import com.y3.util.PageUtil;

/**
 * �û�ҵ��ӿ�ʵ����
 * @author Entity-G
 *
 */
public class UserServiceImpl implements UserService {

	private UserDao ud = new UserDaoImpl();
	
	@Override
	public int addUser(User user) throws Exception {
		int row = 0;
		try {
			row = ud.addUser(user);
		} catch (Exception e) {
			e.printStackTrace();
		} finally {
			DBFactory.closeConnection();//���ݿ����ӹر�
		}
		return row;
	}

	@Override
	public int deleteUser(String uidStr) throws Exception {
		int row = 0;
		try {
			row = ud.deleteUser(uidStr);
		} catch (Exception e) {
			e.printStackTrace();
		} finally {
			DBFactory.closeConnection();//���ݿ����ӹر�
		}
		return row;
	}

	@Override
	public int updateUser(User user,int uid) throws Exception {
		int row = 0;
		try {
			row = ud.updateUser(user, uid);
		} catch (Exception e) {
			e.printStackTrace();
		} finally {
			DBFactory.closeConnection();//���ݿ����ӹر�
		}
		return row;
	}

	/**
	 * ��ѯ�����û�����̨����Ա����+��ҳ
	 */
	@Override
	public PageUtil<User> findAllUserByPage(int currentPage,int pageSize) throws Exception {
		PageUtil<User> pageUtil = new PageUtil<User>();
		try {
			List<User> list = ud.findAllUserByPage(currentPage, pageSize);//�û�����
			int total = ud.userCount();//�ܼ�¼��
			//�����ܼ�¼��������ҳ��
			int pageCount = total%pageSize==0?total/pageSize:total/pageSize+1;
			pageUtil.setCurrentPage(currentPage);
			pageUtil.setList(list);
			pageUtil.setPageCount(pageCount);
			pageUtil.setPageSize(pageSize);
			pageUtil.setTotal(total);
		} catch (Exception e) {
			e.printStackTrace();
		}finally {
			DBFactory.closeConnection();
		}
		return pageUtil;
	}

	@Override
	public User findUserByUid(int uid) throws Exception {
		User user = null;
		try {
			user = ud.findUserByUid(uid);
		} catch (Exception e) {
			e.printStackTrace();
		}finally {
			DBFactory.closeConnection();
		}
		return user;
	}
	
	/**
	 * �û���¼
	 */
	@Override
	public User login(String username, String password) throws Exception {
		User user = new User();
		try {
			user = ud.login(username, password);
		} catch (Exception e) {
			e.printStackTrace();
		} finally {
			DBFactory.closeConnection();
		}
		return user;
	}
	/**
	 * �û�ע��
	 */
	@Override
	public int register(User user) throws Exception {
		int row = 0;
		try {
			row = ud.register(user);
		} catch (Exception e) {
			e.printStackTrace();
		} finally {
			DBFactory.closeConnection();//���ݿ����ӹر�
		}
		return row;
	}
	
	/**
	 * ��ѯ�û�����
	 */
	@Override
	public int userCount() throws Exception {
		int userCount = 0;
		try {
			userCount = ud.userCount();
		} catch (Exception e) {
			e.printStackTrace();
		} finally {
			DBFactory.closeConnection();//���ݿ����ӹر�
		}
		return userCount;
	}

}
