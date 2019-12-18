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
		//设置编码
		request.setCharacterEncoding("utf-8");
		response.setContentType("text/html;charset=utf-8");
		
		//获取表单内容
		String name = request.getParameter("username");
		String pwd = request.getParameter("pwd");
		String repwd = request.getParameter("rePwd");
		String email = request.getParameter("email");
		String phone = request.getParameter("phone");
		
		//获取session域的验证码和邮箱
		int code = (int) request.getSession().getAttribute("code");
		String firstEmail = (String) request.getSession().getAttribute("firstEmail");
		
		//获取用户输入验证码
		String vilidateCode = request.getParameter("eCode");
		int vCode = 0;
		if(vilidateCode!=null && !"".equals(vilidateCode)) {
			vCode = Integer.parseInt(vilidateCode);
		}
		
		//用于封装数据
		User user = new User();
		//返回结果
		String result = "";
		
		//如果两次密码一致则封装到实体类
		if(!repwd.equals(pwd)) {
			result = "两次密码不一致";
		}else{
			//如果两次邮箱不一致，响应结果
			if(!firstEmail.equals(email)) {
				result = "请使用接收验证码的邮箱注册";
			}else {
				//判断验证码
				if(vCode == code) {
					UserService userService = new UserServiceImpl();
					int row = 0;
					try {
						if((name!=null&&!"".equals(name))&&(pwd!=null&&!"".equals(pwd))&&(phone!=null&&!"".equals(phone))) {
							//都满足则封装数据并存储
							user.setUname(name);
							user.setUpwd(pwd);
							user.setUphone(phone);
							user.setUemail(email);
							row = userService.register(user);
						}else {
							result = "个人信息不能为空";
						}
					} catch (Exception e) {
						//如果出现异常，重定向页面，由于没有数据传输，所以可以进行响应重定向
						response.sendRedirect("error.html");
					}
					if(row == 1) {
						//一切无误，返回ok
						result = "ok";
					}else {
						result = "请输入正确的用户名和密码";
					}
				}else {
					result = "验证码不正确";
				}
			}
		}
		//响应给客户
		Gson gson = new Gson();
		response.getWriter().print(gson.toJson(result));
	}

}
