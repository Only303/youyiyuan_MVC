package com.y3.entity;

/**
 * 图书类型实体类
 * @author Entity-G
 *
 */
public class BookKind {

	private int bk_id;//类型编号
	private String bk_name;//类型名称
	private String bk_img;//类型图片
	
	public String getBk_img() {
		return bk_img;
	}

	public void setBk_img(String bk_img) {
		this.bk_img = bk_img;
	}

	public int getBk_id() {
		return bk_id;
	}
	public void setBk_id(int bk_id) {
		this.bk_id = bk_id;
	}
	public String getBk_name() {
		return bk_name;
	}
	public void setBk_name(String bk_name) {
		this.bk_name = bk_name;
	}
}
