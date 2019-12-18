package com.y3.dao;

import java.util.List;

import com.y3.entity.Books;

/**
 * 图书持久层接口
 * @author Entity-G
 *
 */
public interface BooksDao {
	
	/**
	 * 根据模糊查询条件
	 * 查找所有图书信息
	 * 或者
	 * 根据图书类型编号
	 * 查询对应类型的所有图书
	 * @param dimStr
	 * @param bk_id
	 * @return
	 * @throws Exception
	 */
	public List<Books> findAllBooks(String dimStr,int bk_id) throws Exception;
	
	public Books findBookInfoByBid(int bid) throws Exception; //展示图书详情信息
	
	/**
	 * 查询图书数量
	 * @return
	 * @throws Exception
	 */
	int findBooksCount() throws Exception;
	
	/**
	 * 后台-分页查询图书信息
	 * @param currentPage
	 * @param pageSize
	 * @return
	 * @throws Exception
	 */
	List<Books> findAllBooks(int currentPage,int pageSize) throws Exception;
	
}
