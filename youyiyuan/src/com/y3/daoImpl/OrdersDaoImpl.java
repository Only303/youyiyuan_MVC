package com.y3.daoImpl;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.util.ArrayList;
import java.util.List;

import com.y3.dao.OrdersDao;
import com.y3.entity.Orders;
import com.y3.entity.OrdersVo;
import com.y3.util.DBFactory;

/**
 * 数据层订单接口实现类
 * @author Entity-G
 *
 */
public class OrdersDaoImpl implements OrdersDao{

	/**
	 * 添加订单
	 */
	@Override
	public int addOrders(Orders orders) throws Exception {
		int row = 0;
		Connection conn = null;
		PreparedStatement ps = null;
		try {
			conn = DBFactory.openConncetion();
			String sql = "INSERT INTO orders(otime,uid,uremark,state,total,oid) VALUES(?,?,?,?,?,?)";
			ps = conn.prepareStatement(sql);
			ps.setTimestamp(1, orders.getOtime());
			ps.setInt(2, orders.getUid());
			ps.setString(3, orders.getUremark());
			ps.setString(4,orders.getState());
			ps.setDouble(5, orders.getTotal());
			ps.setString(6, orders.getOid());
			row = ps.executeUpdate();
		} catch (Exception e) {
			throw new Exception("OrdersDaoImpl:添加订单");
		}finally {
			if(ps!=null) {
				ps.close();
			}
		}
		return row;
	}

	/**
	 * 后台分页展示所有订单+根据用户查询
	 */
	@Override
	public List<OrdersVo> findAllOrdersByPage(int currentPage,int pageSize) throws Exception {
		List<OrdersVo> list = new ArrayList<OrdersVo>();
		
		Connection conn = null;
		PreparedStatement ps = null;
		ResultSet rs = null;
		try {
			conn = DBFactory.openConncetion();
			String sql = "SELECT *,u.uname,u.uphone FROM `orders` o INNER JOIN `user` u ON o.uid=u.uid WHERE 1=1 LIMIT ?,?";
			ps = conn.prepareStatement(sql);
			ps.setInt(1, (currentPage-1)*pageSize);
			ps.setInt(2, pageSize);
			rs = ps.executeQuery();
			while(rs.next()) {
				OrdersVo ov = new OrdersVo();
				ov.setOid(rs.getString("oid"));
				ov.setOtime(rs.getTimestamp("otime"));
				ov.setState(rs.getString("state"));
				ov.setTotal(rs.getDouble("total"));
				ov.setUid(rs.getInt("uid"));
				ov.setUname(rs.getString("uname"));
				ov.setUphone(rs.getString("uphone"));
				ov.setUremark(rs.getString("uremark"));
				list.add(ov);
			}
		} catch (Exception e) {
			e.printStackTrace();
		}finally {
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
	 * 获取订单数量
	 */
	@Override
	public int findOrdersCount() throws Exception {
		int count = 0;
		Connection conn = null;
		PreparedStatement ps = null;
		ResultSet rs = null;
		try {
			conn = DBFactory.openConncetion();
			String sql = "SELECT COUNT(*) FROM `orders`;";
			ps = conn.prepareStatement(sql);
			rs = ps.executeQuery();
			if(rs.next()) {
				count = rs.getInt(1);
			}
		} catch (Exception e) {
			throw new Exception("OrdersDaoImpl:添加订单");
		}finally {
			if(ps!=null) {
				ps.close();
			}
		}
		return count;
	}

}
