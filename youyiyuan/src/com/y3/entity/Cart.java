package com.y3.entity;

/**
 * 购物车实体类
 * @author Entity-G
 *
 */
public class Cart {

	private int cid;//购物车编号
	private int uid;//用户编号
	private int b_id;//图书编号
	private int count;//图书数量
	
	public int getCid() {
		return cid;
	}
	public void setCid(int cid) {
		this.cid = cid;
	}
	public int getUid() {
		return uid;
	}
	public void setUid(int uid) {
		this.uid = uid;
	}
	public int getB_id() {
		return b_id;
	}
	public void setB_id(int b_id) {
		this.b_id = b_id;
	}
	public int getCount() {
		return count;
	}
	public void setCount(int count) {
		this.count = count;
	}
	
}
