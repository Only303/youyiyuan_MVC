package com.y3.serviceImpl;

import com.y3.dao.CartDao;
import com.y3.daoImpl.CartDaoImpl;
import com.y3.entity.Cart;
import com.y3.service.CartService;
import com.y3.util.DBFactory;

/**
 * 购物车业务层接口实现类
 * @author Entity-G
 *
 */
public class CartServiceImpl implements CartService {

	private CartDao cd = new CartDaoImpl();
	
	/**
	 * 添加购物车
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
	 * 根据用户编号和图书编号删除购物车
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
