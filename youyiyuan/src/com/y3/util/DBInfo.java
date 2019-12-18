package com.y3.util;

import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.util.Properties;

/**
 * 懒汉单利模式读取数据库配置文件
 * @author Entity-G
 *
 */
public class DBInfo {

	private static DBInfo dBIfo;
	
	private String driverClass;
	private String url;
	private String username;
	private String userpwd;
	
	private DBInfo() {
		Properties properties = new Properties();
		try {
			properties.load(new FileInputStream(new File(DBInfo.class.getResource("/").getPath()+"db.properties")));
		} catch (FileNotFoundException e) {
			e.printStackTrace();
		} catch (IOException e) {
			e.printStackTrace();
		}
		driverClass = properties.getProperty("driverClass");
		url = properties.getProperty("url");
		username = properties.getProperty("username");
		userpwd = properties.getProperty("userpwd");
	}
	
	public static DBInfo getInstance() {
		if(dBIfo==null) {
			dBIfo = new DBInfo();
		}
		return dBIfo;
	}

	public static DBInfo getdBIfo() {
		return dBIfo;
	}

	public String getDriverClass() {
		return driverClass;
	}

	public String getUrl() {
		return url;
	}

	public String getUsername() {
		return username;
	}

	public String getUserpwd() {
		return userpwd;
	}
	
}
