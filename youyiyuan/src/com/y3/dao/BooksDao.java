package com.y3.dao;

import java.util.List;

import com.y3.entity.Books;

/**
 * ͼ��־ò�ӿ�
 * @author Entity-G
 *
 */
public interface BooksDao {
	
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
	public List<Books> findAllBooks(String dimStr,int bk_id) throws Exception;
	
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
	List<Books> findAllBooks(int currentPage,int pageSize) throws Exception;
	
}
