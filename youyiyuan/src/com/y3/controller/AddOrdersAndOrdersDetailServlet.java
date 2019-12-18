package com.y3.controller;

import java.io.IOException;
import java.sql.Timestamp;
import java.util.UUID;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.y3.entity.User;
import com.y3.service.OrdersAndOrdersDetailService;
import com.y3.serviceImpl.OrdersAndOrdersDetailServiceImpl;

/**
 * 提交订单时的控制器
 * 订单表添加数据
 * 订单详情表添加数据
 * 购物车表清除数据
 * Servlet implementation class AddOrdersAndOrdersDetailServlet
 */
@WebServlet("/AddOrdersAndOrdersDetailServlet")
public class AddOrdersAndOrdersDetailServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public AddOrdersAndOrdersDetailServlet() {
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
		//接收uid
		User user = (User) request.getSession(false).getAttribute("user");
		if(user != null) {
			int uid = 0;
			if(user != null) {
				uid = user.getUid();
			}
			//接收cidStr
			String cidStr = request.getParameter("cidStr");
			//设置oid
			String oid = UUID.randomUUID().toString();
			//接收total
			String totalStr = request.getParameter("total");
			//接受总价
			double total = 0;
			if(totalStr!=null && !"".equals(totalStr)) {
				total = Double.valueOf(totalStr);
			}
			
			//接收uremark
			String uremark = request.getParameter("uremark");
			
			//接收address
			String address = request.getParameter("address");
			
			//获取下单时间
			Timestamp otime = new Timestamp(System.currentTimeMillis());
			
			//调用业务层方法
			OrdersAndOrdersDetailService oaods = new OrdersAndOrdersDetailServiceImpl();
			try {
				oaods.submitOrders(oid, cidStr, uid, total, uremark, address,otime);
			} catch (Exception e) {
				request.getRequestDispatcher("error.html").forward(request, response);
			}
			
			//封装数据，并跳转页面:提交订单后因跳转到订单详情的servlet
			request.getRequestDispatcher("ShowOrdersDetail").forward(request, response);
		}else {
			response.getWriter().print("<script>alert('你还没有登录，请求先登录！');location.href='login.jsp'</script>");
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
