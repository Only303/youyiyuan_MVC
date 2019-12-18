package com.y3.daoImpl;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.util.ArrayList;
import java.util.List;

import com.y3.dao.UserDao;
import com.y3.entity.User;
import com.y3.util.DBFactory;

/**
 * 用户接口实现类
 * @author Entity-G
 *
 */
public class UserDaoImpl implements UserDao {

	/**
	 * 添加用户信息
	 */
	@Override
	public int addUser(User user) throws Exception {
		int row = 0;
		PreparedStatement ps = null;
		try {
			Connection conn = DBFactory.openConncetion();
			String sql = "insert into user(uname,upwd,usex,uage,uaddress,uphone,uemail) values(?,?,?,?,?,?,?)";
			ps = conn.prepareStatement(sql);
			ps.setString(1, user.getUname());
			ps.setString(2, user.getUpwd());
			ps.setInt(3, user.getUsex());
			ps.setInt(4, user.getUage());
			ps.setString(5, user.getUaddress());
			ps.setString(6, user.getUphone());
			ps.setString(7, user.getUemail());
			row = ps.executeUpdate();
		} catch (Exception e) {
			//一般用于保存错误日志文件信息
			e.printStackTrace();
		}finally {
			ps.close();
		}
		return row;
	}

	/**
	 * 删除用户信息
	 */
	@Override
	public int deleteUser(String uidStr) throws Exception {
		int row = 0;
		PreparedStatement ps = null;
		try {
			Connection conn = DBFactory.openConncetion();
			String sql = "DELETE FROM `user` WHERE uid IN ("+uidStr+")";
			ps = conn.prepareStatement(sql);
			row = ps.executeUpdate();
		} catch (Exception e) {
			//一般用于保存错误日志文件信息
			e.printStackTrace();
		}finally {
			ps.close();
		}
		return row;
	}

	/**
	 * 后台-管理员修改用户信息
	 * 修改用户信息
	 */
	@Override
	public int updateUser(User user,int uid) throws Exception {
		int row = 0;
		PreparedStatement ps = null;
		try {
			Connection conn = DBFactory.openConncetion();
//			update user set uname=?,upwd=?,usex=?,uage=?,uaddress=?,uphone=?,uemail=? where uid=?
			String sql = "update user set uname='"+user.getUname()+"',upwd='"+user.getUpwd()+"',uaddress='"+user.getUaddress()+"' where uid="+uid;
			ps = conn.prepareStatement(sql);
			row = ps.executeUpdate();
		} catch (Exception e) {
			e.printStackTrace();
		}finally {
			ps.close();
		}
		return row;
	}

	/**
	 * 查询（所有）用户信息：根据分页显示
	 * current:当前页码、pageSize:每页要显示的数目
	 * 查询所有用户信息
	 */
	@Override
	public List<User> findAllUserByPage(int currentPage,int pageSize) throws Exception {
		List<User> userList = new ArrayList<User>();
		PreparedStatement ps = null;
		ResultSet rs = null;
		try {
			Connection conn = DBFactory.openConncetion();
			String sql = "SELECT * FROM `user` u WHERE 1=1 LIMIT ?,?";
			ps = conn.prepareStatement(sql);
			ps.setInt(1, (currentPage-1)*pageSize);//开始下标
			ps.setInt(2, pageSize);//要显示的页数（个数）
			rs = ps.executeQuery();
			while(rs.next()) {
				User user = new User();
				user.setUid(rs.getInt("uid"));
				user.setUname(rs.getString("uname"));
				user.setUpwd(rs.getString("upwd"));
				user.setUsex(rs.getInt("usex"));
				user.setUage(rs.getInt("uage"));
				user.setUaddress(rs.getString("uaddress"));
				user.setUphone(rs.getString("uphone"));
				user.setUemail(rs.getString("uemail"));
				userList.add(user);
			}
		} catch (Exception e) {
			//一般用于保存错误日志文件信息
			e.printStackTrace();
		}finally {
			ps.close();
		}
		return userList;
	}

	/**
	 * 通过用户id查询用户详细信息
	 */
	@Override
	public User findUserByUid(int uid) throws Exception {
		User user = new User();
		PreparedStatement ps = null;
		ResultSet rs = null;
		try {
			Connection conn = DBFactory.openConncetion();
			String sql = "select * from user where uid=?";
			ps = conn.prepareStatement(sql);
			ps.setInt(1, uid);
			rs = ps.executeQuery();
			if(rs.next()) {
				user.setUid(rs.getInt("uid"));
				user.setUname(rs.getString("uname"));
				user.setUpwd(rs.getString("upwd"));
				user.setUsex(rs.getInt("usex"));
				user.setUage(rs.getInt("uage"));
				user.setUaddress(rs.getString("uaddress"));
				user.setUphone(rs.getString("uphone"));
				user.setUemail(rs.getString("uemail"));
			}
		} catch (Exception e) {
			//一般用于保存错误日志文件信息
			e.printStackTrace();
		}finally {
			ps.close();
		}
		return user;
	}
	/**
	 * 用户登录
	 */
	@Override
	public User login(String username,String password) throws Exception {
		User user = new User();
		PreparedStatement ps = null;
		ResultSet rs = null;
		try {
			Connection conn = DBFactory.openConncetion();
			String sql = "select * from user where uname=? and upwd=?";
			ps = conn.prepareStatement(sql);
			ps.setString(1, username);
			ps.setString(2, password);
			rs = ps.executeQuery();
			if(rs.next()) {
				user.setUid(rs.getInt("uid"));
				user.setUname(rs.getString("uname"));
				user.setUpwd(rs.getString("upwd"));
				user.setUsex(rs.getInt("usex"));
				user.setUage(rs.getInt("uage"));
				user.setUaddress(rs.getString("uaddress"));
				user.setUphone(rs.getString("uphone"));
				user.setUemail(rs.getString("uemail"));
			}
		} catch (Exception e) {
			e.printStackTrace();
		}finally {
			rs.close();
			ps.close();
		}
		return user;
	}
	
	/**
	 * 用户注册
	 */
	@Override
	public int register(User user) throws Exception {
		int row = 0;
		PreparedStatement ps = null;
		try {
			Connection conn = DBFactory.openConncetion();
			String sql = "insert into user(uname,upwd,usex,uphone,uemail) values(?,?,?,?,?)";
			ps = conn.prepareStatement(sql);
			ps.setString(1, user.getUname());
			ps.setString(2, user.getUpwd());
			ps.setInt(3, user.getUsex());
			ps.setString(4, user.getUphone());
			ps.setString(5, user.getUemail());
			row = ps.executeUpdate();
		} catch (Exception e) {
			//一般用于保存错误日志文件信息
			e.printStackTrace();
		}finally {
			ps.close();
		}
		return row;
	}

	/**
	 * 查询用于总数
	 */
	@Override
	public int userCount() throws Exception {
		int userCount = 0;
		PreparedStatement ps = null;
		ResultSet rs = null;
		try {
			Connection conn = DBFactory.openConncetion();
			String sql = "SELECT COUNT(*) FROM `user`";
			ps = conn.prepareStatement(sql);
			rs = ps.executeQuery();
			if(rs.next()) {
				userCount = rs.getInt(1);
			}
		} catch (Exception e) {
			//一般用于保存错误日志文件信息
			e.printStackTrace();
		}finally {
			if(rs!=null) {
				rs.close();
			}
			if(ps!=null) {
				ps.close();
			}
		}
		return userCount;
	}
	
}
