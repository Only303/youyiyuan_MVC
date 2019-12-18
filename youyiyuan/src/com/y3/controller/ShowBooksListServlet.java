package com.y3.controller;

import java.io.IOException;
import java.util.List;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.y3.entity.Books;
import com.y3.service.BooksService;
import com.y3.serviceImpl.BooksServiceImpl;

/**
 * չʾͼ���б������
 * Servlet implementation class ShowBooksListServlet
 */
@WebServlet("/ShowBooksListServlet")
public class ShowBooksListServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public ShowBooksListServlet() {
        super();
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		//������Ӧ�����ʽ
		response.setContentType("text/html;charset=utf-8");
		
		//����һ������ҳ�����Ҫ��ģ����ѯ�ַ���
		String dimStr = request.getParameter("dimStr");
		
		if(dimStr == null) {
			dimStr = "";//�൱�ڸ�û�и��κ���������ѯ���е�ͼ��
		}else {
			//get������룬��ȥ�ո�
			dimStr = new String(dimStr.getBytes("ISO-8859-1"),"utf-8").replaceAll(" ", "");
		}
		//����ͼ���ţ�bk_id
		String bk_idStr = request.getParameter("bk_id");
		int bk_id = -1;//û��ͼ������Ϊ-1�ģ����ڲ�ʹ�øò���
		if(bk_idStr!=null && !"".equals(bk_idStr)) {
			bk_id = Integer.parseInt(bk_idStr);
		}
		//����ҵ��㷽��
		BooksService bService = new BooksServiceImpl();
		List<Books> listBooks = null;
		try {
			listBooks = bService.findAllBooks(dimStr,bk_id);//ȥ�ո񣬲���Ϊģ����ѯ
		} catch (Exception e) {
			request.getRequestDispatcher("error.html").forward(request, response);
		}
		if(listBooks != null) {
			//��ͼ����Ϣ���з�װ��request�����У���ҳ����ת
			request.setAttribute("list", listBooks);
			request.getRequestDispatcher("books.jsp").forward(request, response);
		}else {
			request.getRequestDispatcher("error.html").forward(request, response);
		}
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		doGet(request, response);
	}

}
