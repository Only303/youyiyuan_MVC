package com.y3.util;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;

/**
 * ���ݿ��������Ӳ��������ӡ��رա��������
 * @author Entity-G
 *
 */
public class DBFactory {
	
	private static ThreadLocal<Connection> tl = new ThreadLocal<Connection>();
	private static Connection conn = null;
//	private static Connection conn;//�߲����������̲߳���ȫ
	/**
	 * �������ݿ�
	 * @return
	 * @throws ClassNotFoundException
	 * @throws SQLException
	 */
	public static Connection openConncetion() throws ClassNotFoundException, SQLException {
		conn = tl.get();
//		System.out.println("������"+conn);
		if(conn == null) {
			DBInfo dBInfo = DBInfo.getInstance();
			//1����������������
			Class.forName(dBInfo.getDriverClass());
			//2����������
			conn = DriverManager.getConnection(dBInfo.getUrl(), dBInfo.getUsername(), dBInfo.getUserpwd());
			tl.set(conn);
		}
		return conn;
	}
	
	/**
	 * �ͷ�����
	 * @throws SQLException
	 */
	public static void closeConnection() throws SQLException{
		conn = tl.get();
//		System.out.println("�ر�����"+conn);
		if(conn!=null) {
			conn.close();
			tl.remove();
		}
		
	}
	
	/**
	 * �ύ����
	 * @throws Exception
	 */
	public static void commit() throws Exception {
		conn = tl.get();
//		System.out.println("�ύ����"+conn);
		if(conn != null) {
			conn.commit();
		}
	}
	
	/**
	 * ����ع�
	 * @throws Exception
	 */
	public static void rollback() throws Exception {
		conn = tl.get();
//		System.out.println("�ع�����"+conn);
		if(conn != null) {
			conn.rollback();
		}
	}

	/**
	 * �����ֹ���������
	 * @throws Exception
	 */
	public static void beginTranaction() throws Exception {
		conn = tl.get();
//		System.out.println("��������"+conn);
		if(conn != null) {
			conn.setAutoCommit(false);
		}
	}
	
}
