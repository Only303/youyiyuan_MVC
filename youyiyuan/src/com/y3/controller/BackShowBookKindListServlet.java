package com.y3.controller;

import java.io.IOException;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.y3.entity.BookKind;
import com.y3.service.BookKindService;
import com.y3.serviceImpl.BookKindServiceImpl;
import com.y3.util.PageUtil;

/**
 * 后台-展示图书类型列表
 * Servlet implementation class BackShowBookKindListServlet
 */
@WebServlet("/BackShowBookKindListServlet")
public class BackShowBookKindListServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public BackShowBookKindListServlet() {
        super();
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		request.getRequestDispatcher("utf-8");
		String currentPageStr = request.getParameter("currentPage");//当前页码
		int currentPage = 1;
		if(currentPageStr!=null && !"".equals(currentPageStr)) {
			currentPage = Integer.parseInt(currentPageStr);
		}
		int pageSize = 5;//要显示的总页数
		
		BookKindService bks = new BookKindServiceImpl();
		PageUtil<BookKind> list = null;
		try {
			list = bks.findAllBookKind(currentPage, pageSize);
		} catch (Exception e) {
			request.getRequestDispatcher("error.jsp").forward(request, response);
		}
		request.setAttribute("pageUtil", list);
		request.setAttribute("path", "BackShowBookKindListServlet");
		request.getRequestDispatcher("/back/bookKindList.jsp").forward(request, response);
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		doGet(request, response);
	}

}
