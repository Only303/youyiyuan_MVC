package com.y3.daoImpl;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;

import com.y3.dao.AdminDao;
import com.y3.entity.Admin;
import com.y3.util.DBFactory;

/**
 * 管理员数据层接口实现类
 * @author Entity-G
 *
 */
public class AdminDaoImpl implements AdminDao {

	/**
	 * 管理员用户登录
	 */
	@Override
	public Admin login(String a_name, String a_pwd) throws Exception {
		Admin admin = new Admin();
		PreparedStatement ps = null;
		ResultSet rs = null;
		try {
			Connection conn = DBFactory.openConncetion();
			String sql = "select * from admin where a_name=? and a_pwd=?";
			ps = conn.prepareStatement(sql);
			ps.setString(1, a_name);
			ps.setString(2, a_pwd);
			rs = ps.executeQuery();
			if(rs.next()) {
				admin.setA_age(rs.getInt("a_age"));
				admin.setA_birthday(rs.getDate("a_birthday"));
				admin.setA_email(rs.getString("a_email"));
				admin.setA_id(rs.getInt("a_id"));
				admin.setA_name(rs.getString("a_name"));
				admin.setA_phone(rs.getString("a_phone"));
				admin.setA_pwd(rs.getString("a_pwd"));
				admin.setA_sex(rs.getInt("a_sex"));
				admin.setA_address(rs.getString("a_address"));
			}
		} catch (Exception e) {
			e.printStackTrace();
		}finally {
			rs.close();
			ps.close();
		}
		return admin;
	}

}
