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
 * 展示图书列表控制类
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
		//设置响应编码格式
		response.setContentType("text/html;charset=utf-8");
		
		//接收一个来自页面的需要的模糊查询字符串
		String dimStr = request.getParameter("dimStr");
		
		if(dimStr == null) {
			dimStr = "";//相当于给没有给任何条件，查询所有的图书
		}else {
			//get请求编码，和去空格
			dimStr = new String(dimStr.getBytes("ISO-8859-1"),"utf-8").replaceAll(" ", "");
		}
		//接收图书编号：bk_id
		String bk_idStr = request.getParameter("bk_id");
		int bk_id = -1;//没有图书类型为-1的，用于不使用该查找
		if(bk_idStr!=null && !"".equals(bk_idStr)) {
			bk_id = Integer.parseInt(bk_idStr);
		}
		//调用业务层方法
		BooksService bService = new BooksServiceImpl();
		List<Books> listBooks = null;
		try {
			listBooks = bService.findAllBooks(dimStr,bk_id);//去空格，参数为模糊查询
		} catch (Exception e) {
			request.getRequestDispatcher("error.html").forward(request, response);
		}
		if(listBooks != null) {
			//将图书信息进行封装到request请求中，并页面跳转
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
