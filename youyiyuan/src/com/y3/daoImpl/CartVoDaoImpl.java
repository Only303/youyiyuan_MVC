package com.y3.daoImpl;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.util.ArrayList;
import java.util.List;

import com.y3.dao.CartVoDao;
import com.y3.entity.CartVo;
import com.y3.util.DBFactory;

/**
 * 数据层购物车清单展示实现类
 * @author Entity-G
 *
 */
public class CartVoDaoImpl implements CartVoDao {

	/**
	 * 通过用户id查询购物车产品信息
	 */
	@Override
	public List<CartVo> findAllCartVoByUid(int uid) throws Exception {
		List<CartVo> list = new ArrayList<CartVo>();

		Connection conn = null;
		PreparedStatement ps = null; 
		ResultSet rs = null;
		
		try {
			conn = DBFactory.openConncetion();
			String sql = "select b.b_id,b.bimg,b.bname,b.bprice,c.count,c.cid from cart c INNER JOIN books b on b.b_id=c.b_id WHERE c.uid=?";
			ps = conn.prepareStatement(sql);
			ps.setInt(1, uid);
			rs = ps.executeQuery();
			while(rs.next()) {
				CartVo cv = new CartVo();
				cv.setB_id(rs.getInt("b_id"));
				cv.setBimg(rs.getString("bimg"));
				cv.setBname(rs.getString("bname"));
				cv.setBprice(rs.getDouble("bprice"));
				cv.setCount(rs.getInt("count"));
				cv.setCid(rs.getInt("cid"));
				list.add(cv);
			}
		} catch (Exception e) {
			e.printStackTrace();
		} finally {
			if(rs!=null) {
				rs.close();
			}
			if(ps!=null) {
				ps.close();
			}
		}
		return list;
	}

	/**
	 * 根据购物车编号cidStr查询选中要结算的商品，添加到订单
	 */
	@Override
	public List<CartVo> findCheckedCartByCid(String cidStr) throws Exception {
		List<CartVo> list = new ArrayList<CartVo>();

		Connection conn = null;
		PreparedStatement ps = null; 
		ResultSet rs = null;
		
		try {
			conn = DBFactory.openConncetion();
			String sql = "SELECT b.bimg,b.bname,b.bprice,c.count FROM cart c INNER JOIN books b ON b.b_id=c.b_id"
					+ " WHERE cid in("+cidStr+")";
			ps = conn.prepareStatement(sql);
			rs = ps.executeQuery();
			while(rs.next()) {
				CartVo cv = new CartVo();
				cv.setBimg(rs.getString("bimg"));
				cv.setBname(rs.getString("bname"));
				cv.setBprice(rs.getDouble("bprice"));
				cv.setCount(rs.getInt("count"));
				list.add(cv);
			}
		} catch (Exception e) {
			e.printStackTrace();
		} finally {
			if(rs!=null) {
				rs.close();
			}
			if(ps!=null) {
				ps.close();
			}
		}
		return list;
	}

	/**
	 * 根据购物车编号cid查询选中要结算的商品，添加到订单
	 */
	@Override
	public CartVo findCheckedCartByCid(int cid) throws Exception {
		CartVo cv = new CartVo();
		Connection conn = null;
		PreparedStatement ps = null; 
		ResultSet rs = null;
		
		try {
			conn = DBFactory.openConncetion();
			String sql = "SELECT b.b_id,b.bimg,b.bname,b.bprice,c.count FROM cart c INNER JOIN books b ON b.b_id=c.b_id WHERE c.cid=?";
			ps = conn.prepareStatement(sql);
			ps.setInt(1, cid);
			rs = ps.executeQuery();
			while(rs.next()) {
				cv.setB_id(rs.getInt("b_id"));
				cv.setBimg(rs.getString("bimg"));
				cv.setBname(rs.getString("bname"));
				cv.setBprice(rs.getDouble("bprice"));
				cv.setCount(rs.getInt("count"));
			}
		} catch (Exception e) {
			throw new Exception("CartVoDaoImpl：根据购物车编号cid查询选中要结算的商品，添加到订单");
		} finally {
			if(rs!=null) {
				rs.close();
			}
			if(ps!=null) {
				ps.close();
			}
		}
		return cv;
	}

	/**
	 * 根据cidStr删除购物车信息
	 */
	@Override
	public int deleteCartVo(String cidStr) throws Exception {
		int row = 0;
		Connection conn = null;
		PreparedStatement ps = null; 
		
		try {
			conn = DBFactory.openConncetion();
			String sql = "delete from cart where cid in("+cidStr+")";
			ps = conn.prepareStatement(sql);
			ps.executeUpdate();
		} catch (Exception e) {
			e.printStackTrace();
		} finally {
			if(ps!=null) {
				ps.close();
			}
		}
		
		return row;
	}

	
}
