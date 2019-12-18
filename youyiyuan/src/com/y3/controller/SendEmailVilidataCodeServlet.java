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
		//��������
		String email = request.getParameter("firstEmail");
		
		String sendResult = "";
		//��Ӧ�ͻ���
		if(email!=null && !"".equals(email)) {
			//����������֤�룬��������֤��
			SendEmailUtil seu = new SendEmailUtil();
			int code = seu.sendEmail(email);
			
			if(code != 0) {
				//��װ�������֤��
				request.getSession().setAttribute("code",code);
				request.getSession().setAttribute("firstEmail", email);
				
				sendResult = "ok";
			}else {
				sendResult = "������֤��ʧ��";
			}
		}else {
			sendResult = "��������Ч�������ַ";
		}
		//��װΪjson���Կͻ�����Ӧ
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
