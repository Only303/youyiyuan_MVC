package com.y3.entity;
/**
 * ��������������Ϣ��ʵ����
 * @author Entity-G
 *
 */
public class OrdersDetailVo extends Orders {

//	b.b_id,b.bname,b.bimg
	private int odcount;//��Ʒ����
	private int b_id;//ͼ����
	private String bname;//ͼ������
	private String bimg;//ͼ��·��
	
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
