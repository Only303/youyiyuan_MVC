package com.y3.serviceImpl;

import java.util.List;

import com.y3.dao.BookKindDao;
import com.y3.daoImpl.BookKindDaoImpl;
import com.y3.entity.BookKind;
import com.y3.service.BookKindService;
import com.y3.util.DBFactory;
import com.y3.util.PageUtil;

/**
 * 图书业务层接口实现类
 * @author Entity-G
 *
 */
public class BookKindServiceImpl implements BookKindService {

	private BookKindDao bookKindDao = new BookKindDaoImpl();
	
	/**
	 * 查询所有图书类型
	 */
	@Override
	public PageUtil<BookKind> findAllBookKind(int currentPage,int pageSize) throws Exception {
		PageUtil<BookKind> listPage = new PageUtil<BookKind>();
		try {
			int total = findBookKindCount();//总页数
			List<BookKind> list = bookKindDao.findAllBookKind(currentPage, pageSize);//集合对象
			int pageCount = total%pageSize==0?total/pageSize:total/pageSize+1;//总页数
			listPage.setCurrentPage(currentPage);
			listPage.setList(list);
			listPage.setPageCount(pageCount);
			listPage.setPageSize(pageSize);
			listPage.setTotal(total);
		} catch (Exception e) {
			e.printStackTrace();
		} finally {
			DBFactory.closeConnection();
		}
		return listPage;
	}

	@Override
	public int findBookKindCount() throws Exception {
		int row = 0;
		try {
			row = bookKindDao.findBookKindCount();
		} catch (Exception e) {
			e.printStackTrace();
		} finally {
			DBFactory.closeConnection();
		}
		return row;
	}

	/**
	 * 查询所有图书列表
	 */
	@Override
	public List<BookKind> findAllBookKind() throws Exception {
		List<BookKind> list = null;
		try {
			list = bookKindDao.findAllBookKind();
		} catch (Exception e) {
			e.printStackTrace();
		} finally {
			DBFactory.closeConnection();
		}
		return list;
	}

}
