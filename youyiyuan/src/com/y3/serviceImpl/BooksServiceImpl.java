package com.y3.serviceImpl;

import java.util.List;

import com.y3.dao.BooksDao;
import com.y3.daoImpl.BooksDaoImpl;
import com.y3.entity.Books;
import com.y3.service.BooksService;
import com.y3.util.DBFactory;
import com.y3.util.PageUtil;

/**
 * 图书业务层接口实现类
 * @author Entity-G
 *
 */
public class BooksServiceImpl implements BooksService {

	private BooksDao booksDao = new BooksDaoImpl();
	
	/**
	 * 根据模糊查询条件
	 * 查找所有图书信息
	 * 或者
	 * 根据图书类型编号
	 * 查询对应类型的所有图书
	 */
	@Override
	public List<Books> findAllBooks(String dimStr,int bk_id) throws Exception {
		List<Books> list = null;
		try {
			list = booksDao.findAllBooks(dimStr,bk_id);
		} catch (Exception e) {
			e.printStackTrace();
		}finally {
			DBFactory.closeConnection();
		}
		return list;
	}

	/**
	 * 根据图书编号查看图书信息
	 */
	@Override
	public Books findBookInfoByBid(int bid) throws Exception {
		Books book = null;
		try {
			book = booksDao.findBookInfoByBid(bid);
		} catch (Exception e) {
			e.printStackTrace();
		}finally {
			DBFactory.closeConnection();
		}
		return book;
	}

	/**
	 * 图书数量
	 */
	@Override
	public int findBooksCount() throws Exception {
		int count = 0;
		try {
			count = booksDao.findBooksCount();
		} catch (Exception e) {
			e.printStackTrace();
		}finally {
			DBFactory.closeConnection();
		}
		return count;
	}

	/**
	 * 后台-分页查询图书
	 */
	@Override
	public PageUtil<Books> findAllBooks(int currentPage, int pageSize) throws Exception {
		
		List<Books> list = booksDao.findAllBooks(currentPage, pageSize);//集合
		PageUtil<Books> pageList = new PageUtil<Books>();
		try {
			int total = booksDao.findBooksCount();//总数
			int pageCount = total%pageSize==0?total/pageSize:total/pageSize+1;//总页数
			pageList.setCurrentPage(currentPage);
			pageList.setList(list);
			pageList.setPageCount(pageCount);
			pageList.setPageSize(pageSize);
			pageList.setTotal(total);
		} catch (Exception e) {
			e.printStackTrace();
		}finally {
			DBFactory.closeConnection();
		}
		return pageList;
	}

}
