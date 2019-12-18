package com.y3.controller;

import java.io.IOException;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.y3.entity.Books;
import com.y3.service.BooksService;
import com.y3.serviceImpl.BooksServiceImpl;

/**
 * ����ͼ����չʾͼ�����������
 * Servlet implementation class ShowBookInfoServlet
 */
@WebServlet("/ShowBookInfoServlet")
public class ShowBookInfoServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public ShowBookInfoServlet() {
        super();
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		//���ñ����ʽ
		request.setCharacterEncoding("utf-8");
		//��ȡ������bid
		String bidStr = request.getParameter("bid");
		int bid = 0;
		if(bidStr!=null && !"".equals(bidStr)) {
			bid = Integer.parseInt(bidStr);
		}
		//����ҵ��㷽��
		BooksService booksService = new BooksServiceImpl();
		Books books = null;
		try {
			books = booksService.findBookInfoByBid(bid);
		} catch (Exception e) {
			request.getRequestDispatcher("error.html").forward(request, response);
		}
		//��ͼ����Ϣ���з�װ������תҳ��
		request.setAttribute("book", books);
		request.getRequestDispatcher("bookInfo.jsp").forward(request, response);
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		doGet(request, response);
	}

}
