package com.y3.entity;

import java.sql.Timestamp;

/**
 * 订单实体类
 * @author Entity-G
 *
 */
public class Orders {

	private String oid;//订单编号
	private Timestamp otime;//下单时间
	private int uid;//用户编号
	private String uremark;//用户备注
	private String state;//订单状态
	private double total;//总价
	
	
	public String getOid() {
		return oid;
	}
	public void setOid(String oid) {
		this.oid = oid;
	}
	public Timestamp getOtime() {
		return otime;
	}
	public void setOtime(Timestamp otime) {
		this.otime = otime;
	}
	public int getUid() {
		return uid;
	}
	public void setUid(int uid) {
		this.uid = uid;
	}
	public String getUremark() {
		return uremark;
	}
	public void setUremark(String uremark) {
		this.uremark = uremark;
	}
	public String getState() {
		return state;
	}
	public void setState(String state) {
		this.state = state;
	}
	public double getTotal() {
		return total;
	}
	public void setTotal(double total) {
		this.total = total;
	}
	
}
