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
 * 后台根据用户id修改用户信息
 * Servlet implementation class BackUpdateUserByUid
 */
@WebServlet("/BackUpdateUserByUid")
public class BackUpdateUserByUid extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public BackUpdateUserByUid() {
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
		System.out.println(uidStr);
		if(uidStr!=null && !"".equals(uidStr)) {
			uid = Integer.parseInt(uidStr);
		}
		//用户名、地址、密码
		String uname = request.getParameter("uname");
		uname = new String(uname.getBytes("iso-8859-1"),"utf-8");
		String uaddress = request.getParameter("uaddress");
		uaddress = new String(uaddress.getBytes("iso-8859-1"),"utf-8");
		String upwd = request.getParameter("upwd");
		upwd = new String(upwd.getBytes("iso-8859-1"),"utf-8");
		User user = new User();
		user.setUname(uname);
		user.setUaddress(uaddress);
		user.setUpwd(upwd);
		//调用业务层方法
		UserService us = new UserServiceImpl();
		int row = 0;
		try {
			row = us.updateUser(user, uid);
		} catch (Exception e) {
			request.getRequestDispatcher("back/error.jsp").forward(request, response);
		}
		if(row != 0) {
			response.getWriter().print("<script>alert('修改成功');location.href='BackUserListServlet';</script>");
		}else {
			response.getWriter().print("<script>alert('修改失败');location.href='"+request.getContextPath()+"/back/editUser.jsp';</script>");
		}
		
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		doGet(request, response);
	}

}
