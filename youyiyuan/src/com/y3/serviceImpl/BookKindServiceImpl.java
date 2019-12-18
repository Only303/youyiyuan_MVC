package com.y3.serviceImpl;

import java.util.List;

import com.y3.dao.BookKindDao;
import com.y3.daoImpl.BookKindDaoImpl;
import com.y3.entity.BookKind;
import com.y3.service.BookKindService;
import com.y3.util.DBFactory;
import com.y3.util.PageUtil;

/**
 * ͼ��ҵ���ӿ�ʵ����
 * @author Entity-G
 *
 */
public class BookKindServiceImpl implements BookKindService {

	private BookKindDao bookKindDao = new BookKindDaoImpl();
	
	/**
	 * ��ѯ����ͼ������
	 */
	@Override
	public PageUtil<BookKind> findAllBookKind(int currentPage,int pageSize) throws Exception {
		PageUtil<BookKind> listPage = new PageUtil<BookKind>();
		try {
			int total = findBookKindCount();//��ҳ��
			List<BookKind> list = bookKindDao.findAllBookKind(currentPage, pageSize);//���϶���
			int pageCount = total%pageSize==0?total/pageSize:total/pageSize+1;//��ҳ��
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
	 * ��ѯ����ͼ���б�
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
