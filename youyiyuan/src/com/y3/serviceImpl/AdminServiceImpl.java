package com.y3.serviceImpl;

import com.y3.dao.AdminDao;
import com.y3.daoImpl.AdminDaoImpl;
import com.y3.entity.Admin;
import com.y3.service.AdminService;
import com.y3.util.DBFactory;
/**
 * ����Աҵ���ӿ�ʵ����
 * @author Entity-G
 */
public class AdminServiceImpl implements AdminService {

	private AdminDao ad = new AdminDaoImpl();

	/**
	 * ����Ա��¼
	 */
	@Override
	public Admin login(String a_name, String a_pwd) throws Exception {
		Admin admin = null;
		try {
			admin = ad.login(a_name, a_pwd);
		} catch (Exception e) {
			e.printStackTrace();
		} finally {
			DBFactory.closeConnection();
		}
		return admin;
	}

}
