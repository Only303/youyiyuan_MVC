package com.y3.serviceImpl;

import com.y3.dao.CartDao;
import com.y3.daoImpl.CartDaoImpl;
import com.y3.entity.Cart;
import com.y3.service.CartService;
import com.y3.util.DBFactory;

/**
 * ���ﳵҵ���ӿ�ʵ����
 * @author Entity-G
 *
 */
public class CartServiceImpl implements CartService {

	private CartDao cd = new CartDaoImpl();
	
	/**
	 * ��ӹ��ﳵ
	 */
	@Override
	public int addCart(Cart cart) throws Exception {
		int row = 0;
		try {
			row = cd.addCart(cart);
		} catch (Exception e) {
			e.printStackTrace();
		} finally {
			DBFactory.closeConnection();
		}
		
		return row;
	}

	@Override
	public int updateCart(Cart cart) throws Exception {
		int row = 0;
		try {
			row = cd.updateCart(cart);
		} catch (Exception e) {
			e.printStackTrace();
		} finally {
			DBFactory.closeConnection();
		}
		
		return row;
	}

	@Override
	public int deleteCart(int cid) throws Exception {
		int row = 0;
		try {
			row = cd.deleteCart(cid);
		} catch (Exception e) {
			e.printStackTrace();
		} finally {
			DBFactory.closeConnection();
		}
		return row;
	}

	/**
	 * �����û���ź�ͼ����ɾ�����ﳵ
	 */
	@Override
	public int deleteCart(int uid, int b_id) throws Exception {
		int row = 0;
		try {
			row = cd.deleteCart(uid, b_id);
		} catch (Exception e) {
			e.printStackTrace();
		} finally {
			DBFactory.closeConnection();
		}
		return row;
	}

}
