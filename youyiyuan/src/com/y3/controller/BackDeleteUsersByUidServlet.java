package com.y3.controller;

import java.io.IOException;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.y3.service.UserService;
import com.y3.serviceImpl.UserServiceImpl;

/**
 * 根据用户id删除指定用户
 * Servlet implementation class BackDeleteUsersByUidServlet
 */
@WebServlet("/BackDeleteUsersByUidServlet")
public class BackDeleteUsersByUidServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public BackDeleteUsersByUidServlet() {
        super();
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		doPost(request, response);
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		request.setCharacterEncoding("utf-8");
		response.setContentType("text/html;charset=utf-8");
		String[] uidArr = request.getParameterValues("checkbox");
		StringBuilder uidStr = new StringBuilder();
		if(uidArr!=null) {
			int len = uidArr.length;
			for(int i=0;i<len;i++) {
				uidStr.append(uidArr[i]);
				if(i!=len-1) {
					uidStr.append(",");
				}
			}
		}else {
			uidStr.append(0);
		}
		
		UserService us = new UserServiceImpl();
		int row = 0;
		try {
			row = us.deleteUser(uidStr.toString());
		} catch (Exception e) {
			request.getRequestDispatcher("error.jsp").forward(request, response);
			return;
		}
		if(row != 0) {
			response.getWriter().print("<script>alert('删除成功');location.href='BackUserListServlet';</script>");
		}else {
			response.getWriter().print("<script>alert('删除失败');location.href='BackUserListServlet';</script>");
		}
	}

}
