package com.y3.controller;

import java.io.IOException;
import java.util.List;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.y3.entity.OrdersDetailVo;
import com.y3.entity.User;
import com.y3.service.OrdersAndOrdersDetailService;
import com.y3.serviceImpl.OrdersAndOrdersDetailServiceImpl;

/**
 * 订单详情控制器类
 * 用户封装订单详情要展示的数据
 * Servlet implementation class ShowOrdersDetail
 */
@WebServlet("/ShowOrdersDetail")
public class ShowOrdersDetail extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public ShowOrdersDetail() {
        super();
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		request.setCharacterEncoding("utf-8");
		response.setContentType("text/html;charset=utf-8");
		//接收参数
		User user = (User) request.getSession().getAttribute("user");
		if(user == null) {
			response.getWriter().print("<script>alert('你尚未登录，不能查看个人订单！');location.href='login.jsp'</script>");
		}else {
			int uid = user.getUid();
			//调用业务层方法
			OrdersAndOrdersDetailService service = new OrdersAndOrdersDetailServiceImpl();
			List<OrdersDetailVo> list = null;
			try {
				list = service.findOrdersDetailVoByUid(uid);
			} catch (Exception e) {
				request.getRequestDispatcher("error.html").forward(request, response);
			}
			//页面跳转
			if(list != null) {
				request.setAttribute("list", list);
				request.getRequestDispatcher("myorder.jsp").forward(request, response);
			}else {
				response.getWriter().print("<script>alert('页面跳转失败')</script>");
			}
		}
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		doGet(request, response);
	}

}
