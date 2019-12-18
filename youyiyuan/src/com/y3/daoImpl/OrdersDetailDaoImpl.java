package com.y3.daoImpl;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.util.ArrayList;
import java.util.List;

import com.y3.dao.OrdersDetailDao;
import com.y3.entity.OrdersDetail;
import com.y3.entity.OrdersDetailVo;
import com.y3.util.DBFactory;

/**
 * 
 * @author Entity-G
 *
 */
public class OrdersDetailDaoImpl implements OrdersDetailDao {

	/**
	 * 添加订单详情
	 */
	@Override
	public int addOrdersDetail(OrdersDetail od) throws Exception {
		int row = 0;
		
		Connection conn = null;
		PreparedStatement ps = null;
		try {
			conn = DBFactory.openConncetion();
			String sql = "INSERT INTO orders_detail(b_id,odcount,oid,address,price) VALUES(?,?,?,?,?)";
			ps = conn.prepareStatement(sql);
			ps.setInt(1, od.getB_id());
			ps.setInt(2, od.getOdcount());
			ps.setString(3, od.getOid());
			ps.setString(4, od.getAddress());
			ps.setDouble(5, od.getPrice());
			row = ps.executeUpdate();
		} catch (Exception e) {
			throw new Exception("OrdersDetailDaoImpl：添加订单详情");
		}finally {
			if(ps!=null) {
				ps.close();
			}
		}
		return row;
	}

	/**
	 * 查询订单详情所需的信息：根据用户编号
	 */
	@Override
	public List<OrdersDetailVo> findOrdersDetailVoByUid(int uid) throws Exception {
		List<OrdersDetailVo> list = new ArrayList<OrdersDetailVo>();
		PreparedStatement ps = null;
		try {
			Connection conn = DBFactory.openConncetion();
//			String sql = "select o.otime,o.oid,o.state,o.total,od.odcount from orders o INNER JOIN orders_detail od on o.oid=od.oid WHERE o.uid=?";
			String sql = "SELECT b.b_id,b.bname,b.bimg,oo.* from books b" + 
					" INNER JOIN (select o.otime,o.oid,o.state,o.total,od.odcount,od.b_id from orders o INNER JOIN orders_detail od on o.oid=od.oid WHERE o.uid=?) oo" + 
					" where b.b_id=oo.b_id";
			ps = conn.prepareStatement(sql);
			ps.setInt(1, uid);
			ResultSet rs = ps.executeQuery();
			while(rs.next()) {
				OrdersDetailVo odv = new OrdersDetailVo();
				
				odv.setB_id(rs.getInt("b_id"));
				odv.setBimg(rs.getString("bimg"));
				odv.setBname(rs.getString("bname"));
				
				odv.setOtime(rs.getTimestamp("otime"));
				odv.setOid(rs.getString("oid"));
				odv.setState(rs.getString("state"));
				odv.setTotal(rs.getDouble("total"));
				odv.setOdcount(rs.getInt("odcount"));
				list.add(odv);
			}
		} catch (Exception e) {
			e.printStackTrace();
		}finally {
			if(ps!=null) {
				ps.close();
			}
		}
		return list;
	}
	
}
