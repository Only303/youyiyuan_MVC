package com.y3.controller;

import java.io.IOException;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.google.gson.Gson;
import com.y3.entity.User;
import com.y3.service.UserService;
import com.y3.serviceImpl.UserServiceImpl;

/**
 * Servlet implementation class register
 */
@WebServlet("/RegisterServlet")
public class RegisterServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public RegisterServlet() {
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
		//���ñ���
		request.setCharacterEncoding("utf-8");
		response.setContentType("text/html;charset=utf-8");
		
		//��ȡ������
		String name = request.getParameter("username");
		String pwd = request.getParameter("pwd");
		String repwd = request.getParameter("rePwd");
		String email = request.getParameter("email");
		String phone = request.getParameter("phone");
		
		//��ȡsession�����֤�������
		int code = (int) request.getSession().getAttribute("code");
		String firstEmail = (String) request.getSession().getAttribute("firstEmail");
		
		//��ȡ�û�������֤��
		String vilidateCode = request.getParameter("eCode");
		int vCode = 0;
		if(vilidateCode!=null && !"".equals(vilidateCode)) {
			vCode = Integer.parseInt(vilidateCode);
		}
		
		//���ڷ�װ����
		User user = new User();
		//���ؽ��
		String result = "";
		
		//�����������һ�����װ��ʵ����
		if(!repwd.equals(pwd)) {
			result = "�������벻һ��";
		}else{
			//����������䲻һ�£���Ӧ���
			if(!firstEmail.equals(email)) {
				result = "��ʹ�ý�����֤�������ע��";
			}else {
				//�ж���֤��
				if(vCode == code) {
					UserService userService = new UserServiceImpl();
					int row = 0;
					try {
						if((name!=null&&!"".equals(name))&&(pwd!=null&&!"".equals(pwd))&&(phone!=null&&!"".equals(phone))) {
							//���������װ���ݲ��洢
							user.setUname(name);
							user.setUpwd(pwd);
							user.setUphone(phone);
							user.setUemail(email);
							row = userService.register(user);
						}else {
							result = "������Ϣ����Ϊ��";
						}
					} catch (Exception e) {
						//��������쳣���ض���ҳ�棬����û�����ݴ��䣬���Կ��Խ�����Ӧ�ض���
						response.sendRedirect("error.html");
					}
					if(row == 1) {
						//һ�����󣬷���ok
						result = "ok";
					}else {
						result = "��������ȷ���û���������";
					}
				}else {
					result = "��֤�벻��ȷ";
				}
			}
		}
		//��Ӧ���ͻ�
		Gson gson = new Gson();
		response.getWriter().print(gson.toJson(result));
	}

}
