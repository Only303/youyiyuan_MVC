package com.y3.entity;
/**
 * 订单详情所需信息的实体类
 * @author Entity-G
 *
 */
public class OrdersDetailVo extends Orders {

//	b.b_id,b.bname,b.bimg
	private int odcount;//商品数量
	private int b_id;//图书编号
	private String bname;//图书名称
	private String bimg;//图书路径
	
	public int getOdcount() {
		return odcount;
	}
	
	public void setOdcount(int odcount) {
		this.odcount = odcount;
	}

	public int getB_id() {
		return b_id;
	}

	public void setB_id(int b_id) {
		this.b_id = b_id;
	}

	public String getBname() {
		return bname;
	}

	public void setBname(String bname) {
		this.bname = bname;
	}

	public String getBimg() {
		return bimg;
	}

	public void setBimg(String bimg) {
		this.bimg = bimg;
	}
}
