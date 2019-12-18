package com.y3.daoImpl;

import java.sql.Connection;
import java.sql.PreparedStatement;

import com.y3.dao.CartDao;
import com.y3.entity.Cart;
import com.y3.util.DBFactory;

/**
 * ���ﳵ���ݲ�ӿ�ʵ����
 * @author Entity-G
 */
public class CartDaoImpl implements CartDao {

	/**
	 * �ͻ���ӹ��ﳵ
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
			throw new Exception(" �ͻ���ӹ��ﳵʱ�׳�һ����");
		}finally {
			if(ps!=null) {
				ps.close();
			}
		}
		
		return row;
	}

	/**
	 * �ͻ��޸Ĺ��ﳵ
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
				//������ﳵ��û�и���Ʒ��ִ����Ӵ���ʽ
				sql += "count=count+1 ";
			}else {
				//����Ѿ������ˣ�������޸�
				sql += "count="+cart.getCount();
			}
			sql += " where uid=? AND b_id=?";
			ps = conn.prepareStatement(sql);
			ps.setInt(1, cart.getUid());
			ps.setInt(2, cart.getB_id());
			row = ps.executeUpdate();
		} catch (Exception e) {
			throw new Exception(" �ͻ���ӹ��ﳵʱ�׳�һ����");
		}finally {
			if(ps!=null) {
				ps.close();
			}
		}
		
		return row;
	}

	/**
	 * ���ݹ��ﳵ���ɾ�����ﳵ��Ϣ
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
	 * �����û���ź�ͼ����ɾ�����ﳵ����
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
