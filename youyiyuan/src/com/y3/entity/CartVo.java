package com.y3.entity;

/**
 * ���ﳵ��Ҫչʾ����Ϣʵ���ࣺ
 * @author Entity-G
 */
public class CartVo extends Books {
	
	private int cid;//ͼ����
	private int count;//ͼ������
	
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
