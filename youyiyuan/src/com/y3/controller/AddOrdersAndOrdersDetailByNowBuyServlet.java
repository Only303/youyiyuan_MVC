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
 * 立即购买时省略加入购物车步骤
 * Servlet implementation class AddOrdersAndOrdersDetailByNowBuyServlet
 */
@WebServlet("/AddOrdersAndOrdersDetailByNowBuyServlet")
public class AddOrdersAndOrdersDetailByNowBuyServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public AddOrdersAndOrdersDetailByNowBuyServlet() {
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
		User user = (User) request.getSession().getAttribute("user");
		if(user != null) {
			int uid = user.getUid();
			//
			String b_idStr = request.getParameter("b_id");
			int b_id = 0;
			if(b_idStr!=null && !"".equals(b_idStr)) {
				b_id = Integer.parseInt(b_idStr);
			}
			
			String countStr = request.getParameter("count");
			int count = 0;
			if(countStr!=null && !"".equals(countStr)) {
				count = Integer.parseInt(countStr);
			}
			
			//接收总价
			String totalPriceStr = request.getParameter("totalPrice");
			double totalPrice = 0;
			if(totalPriceStr!=null && !"".equals(totalPriceStr)) {
				totalPrice = Double.valueOf(totalPriceStr);
			}

			//设置oid
			String oid = UUID.randomUUID().toString();
			
			//接收uremark
			String uremark = request.getParameter("uremark");
			
			//接收address
			String address = request.getParameter("address");
			
			//获取下单时间
			Timestamp otime = new Timestamp(System.currentTimeMillis());
			
			//调用业务层方法
			OrdersAndOrdersDetailService oaods = new OrdersAndOrdersDetailServiceImpl();
			try {
				oaods.addOrdersAndOrdersDetail(oid, uid, uremark, address, otime, b_id, count, totalPrice);
			} catch (Exception e) {
				request.getRequestDispatcher("error.html").forward(request, response);
			}
			
			//封装数据，并跳转页面:提交订单后因跳转到订单详情的servlet
			request.getRequestDispatcher("ShowOrdersDetail").forward(request, response);
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
