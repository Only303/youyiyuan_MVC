package com.y3.controller;

import java.io.IOException;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import com.google.gson.Gson;
import com.y3.entity.User;
import com.y3.service.UserService;
import com.y3.serviceImpl.UserServiceImpl;

/**
 * Servlet implementation class LoginServlet
 */
@WebServlet("/LoginServlet")
public class LoginServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
    
    /**
     * @see HttpServlet#HttpServlet()
     */
    public LoginServlet() {
        super();
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		//���ñ����ʽ
		request.setCharacterEncoding("utf-8");
		response.setContentType("text/html;charset=utf-8");
		//��ȡ��������ͨ����Ԫ������valueֵ��
		String name = request.getParameter("username");
		String pwd = request.getParameter("password");
		
		//��ȡ�û��������֤��
		String valueCode = request.getParameter("verifyCode");
		
		//��ȡsession�е���֤��
		String vCode = (String) request.getSession().getAttribute("vCode");
		
		//����service�е�login()����
		UserService userService = new UserServiceImpl();
		User user = null;
		try {
			user = userService.login(name, pwd);
		} catch (Exception e) {
			//��������쳣�����ض��򵽴���ҳ��
			//�����쳣��û�����ݵĴ��䣬����ʹ����Ӧ�ض���
			request.getRequestDispatcher("error.html").forward(request, response);
		}
		String result;
		//����������쳣������е�¼
		//������ݿ��д��ڣ��������ݣ���¼�ɹ�
		if(user.getUid()!=0) {
			System.out.println(name);
			System.out.println(pwd);
			System.out.println(valueCode);
			System.out.println(vCode);
			
			if(vCode.equals(valueCode)) {//��֤��ͨ��
				//��¼�ɹ������ܴ������ݵĴ��䣬����ʹ������ת��
				HttpSession session = request.getSession();
				session.setAttribute("user", user);
				result = "ok";
			}else {
				result = "��֤�����";
			}
		}else {
			//��¼ʧ�ܣ����ص�ǰҳ��
			result = "�û�����ȡ�������";
		}
		//��֤�������ͻ�����Ӧ
		Gson gson = new Gson();
		response.getWriter().print(gson.toJson(result));
	}

}
