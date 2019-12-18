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
import com.y3.util.PageUtil;

/**
 * 后台-展示图书列表信息
 * Servlet implementation class BackShowBooksListServlet
 */
@WebServlet("/BackShowBooksListServlet")
public class BackShowBooksListServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public BackShowBooksListServlet() {
        super();
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		request.setCharacterEncoding("utf-8");
		
		String currentPageStr = request.getParameter("currentPage");
		int currentPage = 1;
		if(currentPageStr!=null && !"".equals(currentPageStr))
			currentPage = Integer.parseInt(currentPageStr);
		int pageSize = 5;
		
		BooksService bs = new BooksServiceImpl();
		PageUtil<Books> pageList = null;
		
		try {
			pageList = bs.findAllBooks(currentPage, pageSize);
		} catch (Exception e) {
			request.getRequestDispatcher("error.jsp").forward(request, response);
		}
		
		request.setAttribute("pageUtil", pageList);
		request.setAttribute("path", "BackShowBooksListServlet");
		request.getRequestDispatcher("/back/booksList.jsp").forward(request, response);
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		doGet(request, response);
	}

}
