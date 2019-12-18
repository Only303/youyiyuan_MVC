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

/**
 * 后台-展示需要修改的用户信息，以便修改
 * Servlet implementation class BackShowUpdateUserByUid
 */
@WebServlet("/BackShowUpdateUserByUid")
public class BackShowUpdateUserByUid extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public BackShowUpdateUserByUid() {
        super();
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		request.setCharacterEncoding("utf-8");
		response.setContentType("text/html;charset=utf-8");
		//接收参数
		String uidStr = request.getParameter("uid");
		int uid = 0;
		if(uidStr!=null && !"".equals(uidStr)) {
			uid = Integer.parseInt(uidStr);
		}
		//调用业务层方法
		UserService us = new UserServiceImpl();
		User user = null;
		try {
			user = us.findUserByUid(uid);
		} catch (Exception e) {
			request.getRequestDispatcher("back/error.jsp").forward(request, response);
		}
		if(user!=null) {
			request.setAttribute("user", user);
			request.getRequestDispatcher("back/editUser.jsp").forward(request, response);
		}else {
			response.getWriter().print("<script>alert('展示用户详情失败');location.href='BackUserListServlet';</script>");
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
