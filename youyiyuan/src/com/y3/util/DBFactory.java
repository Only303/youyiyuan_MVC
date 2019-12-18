package com.y3.util;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;

/**
 * 数据库的相关连接操作：连接、关闭、事务控制
 * @author Entity-G
 *
 */
public class DBFactory {
	
	private static ThreadLocal<Connection> tl = new ThreadLocal<Connection>();
	private static Connection conn = null;
//	private static Connection conn;//高并发环境下线程不安全
	/**
	 * 连接数据库
	 * @return
	 * @throws ClassNotFoundException
	 * @throws SQLException
	 */
	public static Connection openConncetion() throws ClassNotFoundException, SQLException {
		conn = tl.get();
//		System.out.println("打开链接"+conn);
		if(conn == null) {
			DBInfo dBInfo = DBInfo.getInstance();
			//1、加载驱动：反射
			Class.forName(dBInfo.getDriverClass());
			//2、建立连接
			conn = DriverManager.getConnection(dBInfo.getUrl(), dBInfo.getUsername(), dBInfo.getUserpwd());
			tl.set(conn);
		}
		return conn;
	}
	
	/**
	 * 释放连接
	 * @throws SQLException
	 */
	public static void closeConnection() throws SQLException{
		conn = tl.get();
//		System.out.println("关闭链接"+conn);
		if(conn!=null) {
			conn.close();
			tl.remove();
		}
		
	}
	
	/**
	 * 提交事务
	 * @throws Exception
	 */
	public static void commit() throws Exception {
		conn = tl.get();
//		System.out.println("提交事务"+conn);
		if(conn != null) {
			conn.commit();
		}
	}
	
	/**
	 * 事务回滚
	 * @throws Exception
	 */
	public static void rollback() throws Exception {
		conn = tl.get();
//		System.out.println("回滚事务"+conn);
		if(conn != null) {
			conn.rollback();
		}
	}

	/**
	 * 设置手工控制事务
	 * @throws Exception
	 */
	public static void beginTranaction() throws Exception {
		conn = tl.get();
//		System.out.println("设置事务"+conn);
		if(conn != null) {
			conn.setAutoCommit(false);
		}
	}
	
}
