package com.y3.entity;

/**
 * 购物车将要展示的信息实体类：
 * @author Entity-G
 */
public class CartVo extends Books {
	
	private int cid;//图书编号
	private int count;//图书数量
	
	public int getCid() {
		return cid;
	}
	public void setCid(int cid) {
		this.cid = cid;
	}
	public int getCount() {
		return count;
	}
	public void setCount(int count) {
		this.count = count;
	}
	@Override
	public String toString() {
		return "CartVo [cid=" + cid + ", count=" + count + "]";
	}
	
}
