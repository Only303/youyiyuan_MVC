package com.y3.entity;

import java.sql.Timestamp;

/**
 * ����ʵ����
 * @author Entity-G
 *
 */
public class Orders {

	private String oid;//�������
	private Timestamp otime;//�µ�ʱ��
	private int uid;//�û����
	private String uremark;//�û���ע
	private String state;//����״̬
	private double total;//�ܼ�
	
	
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
