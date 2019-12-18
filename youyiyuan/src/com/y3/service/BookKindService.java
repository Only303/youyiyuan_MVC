package com.y3.service;

import java.util.List;

import com.y3.entity.BookKind;
import com.y3.util.PageUtil;

/**
 * ͼ������ҵ���ӿ�
 * @author Entity-G
 *
 */
public interface BookKindService {

	//���ͼ������
	
	/**
	 * ��ѯ����ͼ�������б�
	 * @return
	 * @throws Exception
	 */
	List<BookKind> findAllBookKind() throws Exception;
	
	//ɾ��ͼ������
	
	PageUtil<BookKind> findAllBookKind(int currentPage,int pageSize) throws Exception;//��ѯͼ�����ͣ����У�
	
	int findBookKindCount() throws Exception;//��ѯͼ�����͵�����
	
	//�޸�ͼ������
	
}
