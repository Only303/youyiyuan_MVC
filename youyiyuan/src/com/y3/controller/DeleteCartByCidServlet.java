package com.y3.controller;

import java.io.IOException;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.y3.entity.User;
import com.y3.service.CartService;
import com.y3.serviceImpl.CartServiceImpl;

/**
 * Servlet implementation class DeleteCartByCidServlet
 */
@WebServlet("/DeleteCartByCidServlet")
public class DeleteCartByCidServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public DeleteCartByCidServlet() {
        super();
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		request.setCharacterEncoding("utf-8");
		response.setContentType("text/html;charset=utf-8");
		//接收参数：b_id、uid、count
		User user = (User) request.getSession().getAttribute("user");
		if(user==null) {
			response.getWriter().print("<script>alert('请先登录！');location.href='login.jsp'</script>");
		}else {
			//接收b_id
			String cidStr = request.getParameter("cid");
			int cid = 0;
			if(cidStr!=null && !"".equals(cidStr)) {
				cid = Integer.parseInt(cidStr);
			}
			
			//调用业务层方法
			CartService cs = new CartServiceImpl();
			try {
				cs.deleteCart(cid);
			} catch (Exception e) {
				request.getRequestDispatcher("error.html").forward(request, response);
				return;
			}
			//页面跳转：跳转到查询购物车的servlet：FindAllCartByUidServlet
			request.getRequestDispatcher("FindAllCartByUidServlet").forward(request, response);
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
