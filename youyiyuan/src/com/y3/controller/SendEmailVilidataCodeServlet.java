package com.y3.controller;

import java.io.IOException;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.google.gson.Gson;
import com.y3.util.SendEmailUtil;

/**
 * Servlet implementation class SendEmailVilidataCodeServlet
 */
@WebServlet("/SendEmailVilidataCodeServlet")
public class SendEmailVilidataCodeServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public SendEmailVilidataCodeServlet() {
        super();
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		request.setCharacterEncoding("utf-8");
		response.setContentType("text/html;charset=utf-8");
		//接收邮箱
		String email = request.getParameter("firstEmail");
		
		String sendResult = "";
		//响应客户端
		if(email!=null && !"".equals(email)) {
			//发送邮箱验证码，并返回验证码
			SendEmailUtil seu = new SendEmailUtil();
			int code = seu.sendEmail(email);
			
			if(code != 0) {
				//封装邮箱和验证码
				request.getSession().setAttribute("code",code);
				request.getSession().setAttribute("firstEmail", email);
				
				sendResult = "ok";
			}else {
				sendResult = "发送验证码失败";
			}
		}else {
			sendResult = "请输入有效的邮箱地址";
		}
		//封装为json并对客户端响应
		Gson gson = new Gson();
		response.getWriter().print(gson.toJson(sendResult));
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		doGet(request, response);
	}

}
