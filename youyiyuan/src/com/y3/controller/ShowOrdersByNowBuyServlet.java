package com.y3.controller;

import java.io.IOException;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.y3.entity.User;

/**
 * 立即购买时使用的控制类
 * Servlet implementation class ShowOrdersByNowBuyServlet
 */
@WebServlet("/ShowOrdersByNowBuyServlet")
public class ShowOrdersByNowBuyServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public ShowOrdersByNowBuyServlet() {
        super();
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		request.setCharacterEncoding("utf-8");
		User user = (User) request.getSession().getAttribute("user");
		if(user!=null) {
			String b_id = request.getParameter("b_id");
			
			String count = request.getParameter("count");
			String totalPrice = request.getParameter("totalPrice");
			
			request.setAttribute("b_id", b_id);
			request.setAttribute("count", count);
			request.setAttribute("totalPrice", totalPrice);
			
			request.getRequestDispatcher("").forward(request, response);
			
		}else {
			response.getWriter().print("<script>alert('请先登录！');location.href='login.jsp'</script>");
		}
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		doGet(request, response);
	}

}
