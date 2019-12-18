package com.y3.serviceImpl;

import java.util.List;

import com.y3.dao.BooksDao;
import com.y3.daoImpl.BooksDaoImpl;
import com.y3.entity.Books;
import com.y3.service.BooksService;
import com.y3.util.DBFactory;
import com.y3.util.PageUtil;

/**
 * ͼ��ҵ���ӿ�ʵ����
 * @author Entity-G
 *
 */
public class BooksServiceImpl implements BooksService {

	private BooksDao booksDao = new BooksDaoImpl();
	
	/**
	 * ����ģ����ѯ����
	 * ��������ͼ����Ϣ
	 * ����
	 * ����ͼ�����ͱ��
	 * ��ѯ��Ӧ���͵�����ͼ��
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
	 * ����ͼ���Ų鿴ͼ����Ϣ
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
	 * ͼ������
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
	 * ��̨-��ҳ��ѯͼ��
	 */
	@Override
	public PageUtil<Books> findAllBooks(int currentPage, int pageSize) throws Exception {
		
		List<Books> list = booksDao.findAllBooks(currentPage, pageSize);//����
		PageUtil<Books> pageList = new PageUtil<Books>();
		try {
			int total = booksDao.findBooksCount();//����
			int pageCount = total%pageSize==0?total/pageSize:total/pageSize+1;//��ҳ��
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
