package com.y3.controller;

import java.io.IOException;
import java.util.List;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.y3.entity.CartVo;
import com.y3.entity.User;
import com.y3.service.CartVoService;
import com.y3.serviceImpl.CartVoServiceImpl;

/**
 * 展示购物车商品信息控制类：shop_car.jsp-->目标页面
 * Servlet implementation class FindAllCartByUidServlet
 */
@WebServlet("/FindAllCartByUidServlet")
public class FindAllCartByUidServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public FindAllCartByUidServlet() {
        super();
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		//接收参数
		User user = (User) request.getSession().getAttribute("user");
		if(user == null) {
			response.getWriter().print("<script>alert('用户名或密码错误！');location.href='login.jsp'</script>");
		}else {
			//获取uid
			int uid = 0;
			if(user!=null) {
				uid = user.getUid();
			}
			//调用业务层方法
			CartVoService cvd = new CartVoServiceImpl();
			List<CartVo> list = null;
			try {
				list = cvd.findAllCartVoByUid(uid);
			} catch (Exception e) {
				request.getRequestDispatcher("error.html").forward(request, response);
			}
			if(list != null) {
				//数据封装，并跳转
				request.setAttribute("list", list);
				request.getRequestDispatcher("shop_car.jsp").forward(request, response);
			}else {
				response.getWriter().print("<script>alert('没有获取到数据！');");
			}
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
