package com.y3.util;

import java.util.List;

/**
 * ��ҳ������
 * @author Entity-G
 * @param <T>
 */
public class PageUtil<T> {
	
	private int total;//�ܼ�¼��-������ҳ��
	private int currentPage;//��ǰҳ��
	private int pageSize;//ûҳҪ��ʾ����Ŀ
	private int pageCount;//��ҳ��
	private List<T> list;//����-���϶���
	
	public int getTotal() {
		return total;
	}
	public void setTotal(int total) {
		this.total = total;
	}
	public int getCurrentPage() {
		return currentPage;
	}
	public void setCurrentPage(int currentPage) {
		this.currentPage = currentPage;
	}
	public int getPageSize() {
		return pageSize;
	}
	public void setPageSize(int pageSize) {
		this.pageSize = pageSize;
	}
	public int getPageCount() {
		return pageCount;
	}
	public void setPageCount(int pageCount) {
		this.pageCount = pageCount;
	}
	public List<T> getList() {
		return list;
	}
	public void setList(List<T> list) {
		this.list = list;
	}
	
}
