package com.y3.entity;

/**
 * 订单详情实体类
 * @author Entity-G
 *
 */
public class OrdersDetail {

	private int odid;//订单详情编号
	private int b_id;//图书编号
	private int odcount;//图书数量
	private String oid;//订单编号
	private double price;//图书单价
	private String address;//收货地址

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
