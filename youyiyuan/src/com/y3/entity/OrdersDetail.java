package com.y3.entity;

/**
 * ��������ʵ����
 * @author Entity-G
 *
 */
public class OrdersDetail {

	private int odid;//����������
	private int b_id;//ͼ����
	private int odcount;//ͼ������
	private String oid;//�������
	private double price;//ͼ�鵥��
	private String address;//�ջ���ַ

	public String getAddress() {
		return address;
	}
	public void setAddress(String address) {
		this.address = address;
	}
	public int getOdid() {
		return odid;
	}
	public void setOdid(int odid) {
		this.odid = odid;
	}
	public int getB_id() {
		return b_id;
	}
	public void setB_id(int b_id) {
		this.b_id = b_id;
	}
	public int getOdcount() {
		return odcount;
	}
	public void setOdcount(int odcount) {
		this.odcount = odcount;
	}
	public String getOid() {
		return oid;
	}
	public void setOid(String oid) {
		this.oid = oid;
	}
	public double getPrice() {
		return price;
	}
	public void setPrice(double price) {
		this.price = price;
	}
	
}
