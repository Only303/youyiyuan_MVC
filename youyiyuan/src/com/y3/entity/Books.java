package com.y3.entity;

import java.util.Date;

/**
 * 书籍实体类
 * @author Entity-G
 *
 */
public class Books {

	private int b_id;//图书id
	private String bname;//图书名称
	private String bauto;//作者
	private int bk_id;//图书类型编号
	private String b_press;//出版社
	private Date b_press_time;//出版时间
	private String bimg;//图书图片名称
	private double bprice;//图书价格
	
	private String bk_name;//图书类型名称
	
	public String getBk_name() {
		return bk_name;
	}

	public void setBk_name(String bk_name) {
		this.bk_name = bk_name;
	}

	public Books() {}

	public Books(int b_id, String bname, String bauto, int bk_id, String b_press, Date b_press_time, String bimg,
			double bprice) {
		this.b_id = b_id;
		this.bname = bname;
		this.bauto = bauto;
		this.bk_id = bk_id;
		this.b_press = b_press;
		this.b_press_time = b_press_time;
		this.bimg = bimg;
		this.bprice = bprice;
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
	public String getBauto() {
		return bauto;
	}
	public void setBauto(String bauto) {
		this.bauto = bauto;
	}
	public int getBk_id() {
		return bk_id;
	}
	public void setBk_id(int bk_id) {
		this.bk_id = bk_id;
	}
	public String getB_press() {
		return b_press;
	}
	public void setB_press(String b_press) {
		this.b_press = b_press;
	}
	public Date getB_press_time() {
		return b_press_time;
	}
	public void setB_press_time(Date b_press_time) {
		this.b_press_time = b_press_time;
	}
	public String getBimg() {
		return bimg;
	}
	public void setBimg(String bimg) {
		this.bimg = bimg;
	}
	public double getBprice() {
		return bprice;
	}
	public void setBprice(double bprice) {
		this.bprice = bprice;
	}
	@Override
	public String toString() {
		return "Books [b_id=" + b_id + ", bname=" + bname + ", bauto=" + bauto + ", bk_id=" + bk_id + ", b_press="
				+ b_press + ", b_press_time=" + b_press_time + ", bimg=" + bimg + ", bprice=" + bprice + "]";
	}
	
}
