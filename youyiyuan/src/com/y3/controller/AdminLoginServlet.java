package com.y3.controller;

import java.io.IOException;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import com.y3.entity.Admin;
import com.y3.service.AdminService;
import com.y3.serviceImpl.AdminServiceImpl;

/**
 * ����Ա��¼
 * Servlet implementation class AdminLoginServlet
 */
@WebServlet("/AdminLoginServlet")
public class AdminLoginServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public AdminLoginServlet() {
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
		//���ñ����ʽ
		request.setCharacterEncoding("utf-8");
		response.setContentType("text/html;charset=utf-8");
		//���ղ���
		String a_name = request.getParameter("a_name");
		String a_pwd = request.getParameter("a_pwd");
		//����ҵ�㷽��
		AdminService adminService = new AdminServiceImpl();
		Admin admin = null;
		try {
			admin = adminService.login(a_name, a_pwd);
		} catch (Exception e) {
			request.getRequestDispatcher("error.jsp").forward(request, response);
		}
		//��װ���ݣ�����תҳ��
		if(admin.getA_id()!=0) {//����Ĭ��ֵΪ0
			HttpSession session = request.getSession();
			session.setAttribute("admin", admin);
			request.getRequestDispatcher("back/index.jsp").forward(request, response);
		}else {
			response.getWriter().print("<script>alert('�û������������');location.href='back/login.jsp'</script>");
		}
	
	}

}
