package com.y3.controller;

import java.io.IOException;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.Cookie;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.y3.util.CookieUtil;

/**
 * 	���ʼ�¼��servlet
 * Servlet implementation class AccessRecordServlet
 */
@WebServlet("/AccessRecordServlet")
public class AccessRecordServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		/**
		 * �����¼������id��ѯ�����¼
		 * 1.��ȡ���ʼ�¼�����û�У��򽫵�ǰ�ķ����������һ��
		 */
		String ids = "";
		Cookie cookie = CookieUtil.getCookieByName(ids, request.getCookies());
		
		
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		doGet(request, response);
	}

}
