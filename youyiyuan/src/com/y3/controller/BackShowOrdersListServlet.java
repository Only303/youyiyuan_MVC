package com.y3.controller;

import java.io.IOException;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.y3.entity.OrdersVo;
import com.y3.service.OrdersAndOrdersDetailService;
import com.y3.serviceImpl.OrdersAndOrdersDetailServiceImpl;
import com.y3.util.PageUtil;

/**
 * 后台-展示订单
 * Servlet implementation class BackShowOrdersListServlet
 */
@WebServlet("/BackShowOrdersListServlet")
public class BackShowOrdersListServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public BackShowOrdersListServlet() {
        super();
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		request.setCharacterEncoding("utf-8");
		String currentStr = request.getParameter("currentPage");
		int currentPage = 1;
		if(currentStr!=null && !"".equals(currentStr)) {
			currentPage = Integer.parseInt(currentStr);
		}
		int pageSize = 5;
		OrdersAndOrdersDetailService os = new OrdersAndOrdersDetailServiceImpl();
		PageUtil<OrdersVo> pageUtil = null;
		
		try {
			pageUtil = os.findAllOrdersByPage(currentPage, pageSize);
		} catch (Exception e) {
			request.getRequestDispatcher("error.jsp").forward(request, response);
			return;
		}
		
		request.setAttribute("pageUtil", pageUtil);
		request.setAttribute("path", "BackShowOrdersListServlet");
		request.getRequestDispatcher("back/orderList.jsp").forward(request, response);
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		doGet(request, response);
	}

}
