package com.y3.dao;

import java.util.List;

import com.y3.entity.BookKind;

/**
 * 图书类型持久层接口
 * @author Entity-G
 *
 */
public interface BookKindDao {

	//添加图书类型
	
	//删除图书类型
	
	/**
	 * 查询所有图书类型列表
	 * @return
	 * @throws Exception
	 */
	List<BookKind> findAllBookKind() throws Exception;
	
	/**
	 * 后台-查询图书类型（所有）+分页
	 * @param currentPage
	 * @param pageSize
	 * @return
	 * @throws Exception
	 */
	List<BookKind> findAllBookKind(int currentPage,int pageSize) throws Exception;
	
	int findBookKindCount() throws Exception;//查询图书类型的总数
	
	//修改图书类型
	
}
