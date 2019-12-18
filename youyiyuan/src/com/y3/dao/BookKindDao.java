package com.y3.dao;

import java.util.List;

import com.y3.entity.BookKind;

/**
 * ͼ�����ͳ־ò�ӿ�
 * @author Entity-G
 *
 */
public interface BookKindDao {

	//���ͼ������
	
	//ɾ��ͼ������
	
	/**
	 * ��ѯ����ͼ�������б�
	 * @return
	 * @throws Exception
	 */
	List<BookKind> findAllBookKind() throws Exception;
	
	/**
	 * ��̨-��ѯͼ�����ͣ����У�+��ҳ
	 * @param currentPage
	 * @param pageSize
	 * @return
	 * @throws Exception
	 */
	List<BookKind> findAllBookKind(int currentPage,int pageSize) throws Exception;
	
	int findBookKindCount() throws Exception;//��ѯͼ�����͵�����
	
	//�޸�ͼ������
	
}
