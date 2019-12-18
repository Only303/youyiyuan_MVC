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
 * 	访问记录的servlet
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
		 * 浏览记录，根据id查询浏览记录
		 * 1.获取访问记录，如果没有，则将当前的访问添加至第一个
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
