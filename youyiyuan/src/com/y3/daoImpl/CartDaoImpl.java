package com.y3.daoImpl;

import java.sql.Connection;
import java.sql.PreparedStatement;

import com.y3.dao.CartDao;
import com.y3.entity.Cart;
import com.y3.util.DBFactory;

/**
 * 购物车数据层接口实现类
 * @author Entity-G
 */
public class CartDaoImpl implements CartDao {

	/**
	 * 客户添加购物车
	 */
	@Override
	public int addCart(Cart cart) throws Exception {
		int row = 0;
		
		Connection conn = null;
		PreparedStatement ps = null;
		try {
			conn = DBFactory.openConncetion();
			String sql = "INSERT INTO cart(uid,b_id,count) VALUES(?,?,?)";
			ps = conn.prepareStatement(sql);
			ps.setInt(1, cart.getUid());
			ps.setInt(2, cart.getB_id());
			ps.setInt(3, cart.getCount());
			row = ps.executeUpdate();
		} catch (Exception e) {
			throw new Exception(" 客户添加购物车时抛出一场：");
		}finally {
			if(ps!=null) {
				ps.close();
			}
		}
		
		return row;
	}

	/**
	 * 客户修改购物车
	 */
	@Override
	public int updateCart(Cart cart) throws Exception {
		int row = 0;
		
		Connection conn = null;
		PreparedStatement ps = null;
		try {
			conn = DBFactory.openConncetion();
			String sql = "UPDATE cart SET ";
			if(cart.getCid() == 0) {
				//如果购物车里没有改商品则执行添加处理方式
				sql += "count=count+1 ";
			}else {
				//如果已经存在了，则进行修改
				sql += "count="+cart.getCount();
			}
			sql += " where uid=? AND b_id=?";
			ps = conn.prepareStatement(sql);
			ps.setInt(1, cart.getUid());
			ps.setInt(2, cart.getB_id());
			row = ps.executeUpdate();
		} catch (Exception e) {
			throw new Exception(" 客户添加购物车时抛出一场：");
		}finally {
			if(ps!=null) {
				ps.close();
			}
		}
		
		return row;
	}

	/**
	 * 根据购物车编号删除购物车信息
	 */
	@Override
	public int deleteCart(int cid) throws Exception {
		int row = 0;
		Connection conn = null;
		PreparedStatement ps = null;
		try {
			conn = DBFactory.openConncetion();
			String sql = "DELETE from cart where cid=?";
			ps = conn.prepareStatement(sql);
			ps.setInt(1, cid);
			row = ps.executeUpdate();
		} catch (Exception e) {
			e.printStackTrace();
		}finally {
			if(ps!=null) {
				ps.close();
			}
		}
		return row;
	}

	/**
	 * 根据用户编号和图书编号删除购物车数据
	 */
	@Override
	public int deleteCart(int uid, int b_id) throws Exception {
		int row = 0;
		Connection conn = null;
		PreparedStatement ps = null;
		try {
			conn = DBFactory.openConncetion();
			String sql = "DELETE from cart where uid=? AND b_id=?";
			ps = conn.prepareStatement(sql);
			ps.setInt(1, uid);
			ps.setInt(2, b_id);
			row = ps.executeUpdate();
		} catch (Exception e) {
			e.printStackTrace();
		}finally {
			if(ps!=null) {
				ps.close();
			}
		}
		return row;
	}

}
