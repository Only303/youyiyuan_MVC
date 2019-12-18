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
 * �ύ����ʱ�Ŀ�����
 * �������������
 * ����������������
 * ���ﳵ���������
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
		//���ղ���
		//����uid
		User user = (User) request.getSession(false).getAttribute("user");
		if(user != null) {
			int uid = 0;
			if(user != null) {
				uid = user.getUid();
			}
			//����cidStr
			String cidStr = request.getParameter("cidStr");
			//����oid
			String oid = UUID.randomUUID().toString();
			//����total
			String totalStr = request.getParameter("total");
			//�����ܼ�
			double total = 0;
			if(totalStr!=null && !"".equals(totalStr)) {
				total = Double.valueOf(totalStr);
			}
			
			//����uremark
			String uremark = request.getParameter("uremark");
			
			//����address
			String address = request.getParameter("address");
			
			//��ȡ�µ�ʱ��
			Timestamp otime = new Timestamp(System.currentTimeMillis());
			
			//����ҵ��㷽��
			OrdersAndOrdersDetailService oaods = new OrdersAndOrdersDetailServiceImpl();
			try {
				oaods.submitOrders(oid, cidStr, uid, total, uremark, address,otime);
			} catch (Exception e) {
				request.getRequestDispatcher("error.html").forward(request, response);
			}
			
			//��װ���ݣ�����תҳ��:�ύ����������ת�����������servlet
			request.getRequestDispatcher("ShowOrdersDetail").forward(request, response);
		}else {
			response.getWriter().print("<script>alert('�㻹û�е�¼�������ȵ�¼��');location.href='login.jsp'</script>");
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
