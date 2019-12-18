package com.y3.controller;

import java.io.IOException;
import java.util.List;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.y3.entity.BookKind;
import com.y3.service.BookKindService;
import com.y3.serviceImpl.BookKindServiceImpl;

/**
 * index.jspҳ��Ŀ����ࣺ����ͼ�������嵥��ʾ
 * Servlet implementation class ShowBookKindListServlet
 */
@WebServlet("/ShowBookKindListServlet")
public class ShowBookKindListServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public ShowBookKindListServlet() {
        super();
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		
		//����ҵ��㷽��
		BookKindService bks = new BookKindServiceImpl();
		List<BookKind> listBK = null;
		try {
			listBK = bks.findAllBookKind();
		} catch (Exception e) {
			request.getRequestDispatcher("error.html").forward(request, response);
			return;
		}
		
		//��ͼ���������ݽ��з�װ������תҳ��
		if(listBK != null) {
			request.setAttribute("list", listBK);
			request.getRequestDispatcher("index.jsp").forward(request, response);
		}else {
			response.sendRedirect("error.html");
		}
		
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		doGet(request, response);
	}

}
