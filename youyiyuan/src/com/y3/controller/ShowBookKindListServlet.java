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
 * index.jsp页面的控制类：控制图书类型清单显示
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
		
		//调用业务层方法
		BookKindService bks = new BookKindServiceImpl();
		List<BookKind> listBK = null;
		try {
			listBK = bks.findAllBookKind();
		} catch (Exception e) {
			request.getRequestDispatcher("error.html").forward(request, response);
			return;
		}
		
		//对图书类型数据进行封装，并跳转页面
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
