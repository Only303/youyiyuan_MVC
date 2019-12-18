package com.y3.controller;

import java.io.IOException;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.y3.entity.User;
import com.y3.service.UserService;
import com.y3.serviceImpl.UserServiceImpl;
import com.y3.util.PageUtil;

/**
 * 后台查看用户列表的servlet类+分页
 * Servlet implementation class BackUserListServlet
 */
@WebServlet("/BackUserListServlet")
public class BackUserListServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public BackUserListServlet() {
        super();
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		//设置编码格式
		request.setCharacterEncoding("utf-8");
		response.setContentType("text/html;charset=utf-8");
		//接收参数
		//当前页码
		String currentPageStr = request.getParameter("currentPage");
		int currentPage = 1;
		if(currentPageStr!=null && !"".equals(currentPageStr)) {
			currentPage = Integer.parseInt(currentPageStr);
		}
		//没页要显示的数量
		int pageSize = 5;
		
		//调用业务层方法
		UserService us = new UserServiceImpl();
		PageUtil<User> pageUtil = new PageUtil<User>();
		try {
			//分页查询
			pageUtil = us.findAllUserByPage(currentPage, pageSize);
		} catch (Exception e) {
			request.getRequestDispatcher("error.jsp").forward(request, response);
		}
		if(pageUtil!=null) {
			//数据封装，页面跳转
			request.setAttribute("pageUtil", pageUtil);
			request.setAttribute("path", "BackUserListServlet");
			request.getRequestDispatcher("back/userList.jsp").forward(request, response);
		}else {
			request.getRequestDispatcher("error.jsp").forward(request, response);
		}
		
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		doGet(request, response);
	}

}
