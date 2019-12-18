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
		//设置编码格式
		request.setCharacterEncoding("utf-8");
		response.setContentType("text/html;charset=utf-8");
		//获取表单参数（通过表单元素名称value值）
		String name = request.getParameter("username");
		String pwd = request.getParameter("password");
		
		//获取用户输入的验证码
		String valueCode = request.getParameter("verifyCode");
		
		//获取session中的验证码
		String vCode = (String) request.getSession().getAttribute("vCode");
		
		//调用service中的login()方法
		UserService userService = new UserServiceImpl();
		User user = null;
		try {
			user = userService.login(name, pwd);
		} catch (Exception e) {
			//如果出现异常，则重定向到错误页面
			//出现异常，没有数据的传输，所以使用响应重定向
			request.getRequestDispatcher("error.html").forward(request, response);
		}
		String result;
		//如果不出现异常，则进行登录
		//如果数据库中存在，则有数据，登录成功
		if(user.getUid()!=0) {
			System.out.println(name);
			System.out.println(pwd);
			System.out.println(valueCode);
			System.out.println(vCode);
			
			if(vCode.equals(valueCode)) {//验证码通过
				//登录成功，可能存在数据的传输，所以使用请求转发
				HttpSession session = request.getSession();
				session.setAttribute("user", user);
				result = "ok";
			}else {
				result = "验证码错误";
			}
		}else {
			//登录失败，返回当前页面
			result = "用户名获取密码错误";
		}
		//验证码错误，向客户端响应
		Gson gson = new Gson();
		response.getWriter().print(gson.toJson(result));
	}

}
