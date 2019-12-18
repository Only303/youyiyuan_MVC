package com.y3.service;

import java.util.List;

import com.y3.entity.Books;
import com.y3.util.PageUtil;

/**
 * ͼ��ҵ���ӿ�
 * @author Entity-G
 *
 */
public interface BooksService {
	
	/**
	 * ����ģ����ѯ����
	 * ��������ͼ����Ϣ
	 * ����
	 * ����ͼ�����ͱ��
	 * ��ѯ��Ӧ���͵�����ͼ��
	 * @param dimStr
	 * @param bk_id
	 * @return
	 * @throws Exception
	 */
	public List<Books> findAllBooks(String dimStr,int bk_id) throws Exception;//��ѯͼ��(����ͼ��)+ģ����ѯ
	
	public Books findBookInfoByBid(int bid) throws Exception; //չʾͼ��������Ϣ
	
	/**
	 * ��ѯͼ������
	 * @return
	 * @throws Exception
	 */
	int findBooksCount() throws Exception;
	
	/**
	 * ��̨-��ҳ��ѯͼ����Ϣ
	 * @param currentPage
	 * @param pageSize
	 * @return
	 * @throws Exception
	 */
	PageUtil<Books> findAllBooks(int currentPage,int pageSize) throws Exception;
	
}
