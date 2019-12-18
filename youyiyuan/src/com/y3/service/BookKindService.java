package com.y3.service;

import java.util.List;

import com.y3.entity.BookKind;
import com.y3.util.PageUtil;

/**
 * 图书类型业务层接口
 * @author Entity-G
 *
 */
public interface BookKindService {

	//添加图书类型
	
	/**
	 * 查询所有图书类型列表
	 * @return
	 * @throws Exception
	 */
	List<BookKind> findAllBookKind() throws Exception;
	
	//删除图书类型
	
	PageUtil<BookKind> findAllBookKind(int currentPage,int pageSize) throws Exception;//查询图书类型（所有）
	
	int findBookKindCount() throws Exception;//查询图书类型的总数
	
	//修改图书类型
	
}
