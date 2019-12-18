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
 * ���������������
 * �û���װ��������Ҫչʾ������
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
		//���ղ���
		User user = (User) request.getSession().getAttribute("user");
		if(user == null) {
			response.getWriter().print("<script>alert('����δ��¼�����ܲ鿴���˶�����');location.href='login.jsp'</script>");
		}else {
			int uid = user.getUid();
			//����ҵ��㷽��
			OrdersAndOrdersDetailService service = new OrdersAndOrdersDetailServiceImpl();
			List<OrdersDetailVo> list = null;
			try {
				list = service.findOrdersDetailVoByUid(uid);
			} catch (Exception e) {
				request.getRequestDispatcher("error.html").forward(request, response);
			}
			//ҳ����ת
			if(list != null) {
				request.setAttribute("list", list);
				request.getRequestDispatcher("myorder.jsp").forward(request, response);
			}else {
				response.getWriter().print("<script>alert('ҳ����תʧ��')</script>");
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
