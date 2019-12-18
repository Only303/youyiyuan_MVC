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
 * ��������ʱʡ�Լ��빺�ﳵ����
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
		//���ղ���
		//����uid
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
			
			//�����ܼ�
			String totalPriceStr = request.getParameter("totalPrice");
			double totalPrice = 0;
			if(totalPriceStr!=null && !"".equals(totalPriceStr)) {
				totalPrice = Double.valueOf(totalPriceStr);
			}

			//����oid
			String oid = UUID.randomUUID().toString();
			
			//����uremark
			String uremark = request.getParameter("uremark");
			
			//����address
			String address = request.getParameter("address");
			
			//��ȡ�µ�ʱ��
			Timestamp otime = new Timestamp(System.currentTimeMillis());
			
			//����ҵ��㷽��
			OrdersAndOrdersDetailService oaods = new OrdersAndOrdersDetailServiceImpl();
			try {
				oaods.addOrdersAndOrdersDetail(oid, uid, uremark, address, otime, b_id, count, totalPrice);
			} catch (Exception e) {
				request.getRequestDispatcher("error.html").forward(request, response);
			}
			
			//��װ���ݣ�����תҳ��:�ύ����������ת�����������servlet
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
