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
 * ��̨�鿴�û��б��servlet��+��ҳ
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
		//���ñ����ʽ
		request.setCharacterEncoding("utf-8");
		response.setContentType("text/html;charset=utf-8");
		//���ղ���
		//��ǰҳ��
		String currentPageStr = request.getParameter("currentPage");
		int currentPage = 1;
		if(currentPageStr!=null && !"".equals(currentPageStr)) {
			currentPage = Integer.parseInt(currentPageStr);
		}
		//ûҳҪ��ʾ������
		int pageSize = 5;
		
		//����ҵ��㷽��
		UserService us = new UserServiceImpl();
		PageUtil<User> pageUtil = new PageUtil<User>();
		try {
			//��ҳ��ѯ
			pageUtil = us.findAllUserByPage(currentPage, pageSize);
		} catch (Exception e) {
			request.getRequestDispatcher("error.jsp").forward(request, response);
		}
		if(pageUtil!=null) {
			//���ݷ�װ��ҳ����ת
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
