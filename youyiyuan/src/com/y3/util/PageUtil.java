package com.y3.util;

import java.util.List;

/**
 * 分页工具类
 * @author Entity-G
 * @param <T>
 */
public class PageUtil<T> {
	
	private int total;//总记录数-计算总页数
	private int currentPage;//当前页数
	private int pageSize;//没页要显示的数目
	private int pageCount;//总页数
	private List<T> list;//泛型-集合对象
	
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
