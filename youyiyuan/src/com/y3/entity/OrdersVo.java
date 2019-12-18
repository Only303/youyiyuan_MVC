package com.y3.entity;

/**
 * 后台展示订单Vo实体类
 * @author Entity-G
 */
public class OrdersVo extends Orders {

	private String uname;
	private String uphone;
	
	public String getUname() {
		return uname;
	}
	public void setUname(String uname) {
		this.uname = uname;
	}
	public String getUphone() {
		return uphone;
	}
	public void setUphone(String uphone) {
		this.uphone = uphone;
	}
	
}
