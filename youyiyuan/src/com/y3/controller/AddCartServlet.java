package com.y3.controller;

import java.io.IOException;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.y3.entity.Cart;
import com.y3.entity.User;
import com.y3.service.CartService;
import com.y3.serviceImpl.CartServiceImpl;

/**
 * �û���ӹ��ﳵ�Ŀ�����
 * Servlet implementation class AddCartServlet
 */
@WebServlet("/AddCartServlet")
public class AddCartServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public AddCartServlet() {
        super();
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		request.setCharacterEncoding("utf-8");
		response.setContentType("text/html;charset=utf-8");
		//���ղ�����b_id��uid��count
		User user = (User) request.getSession().getAttribute("user");
		if(user==null) {
			response.getWriter().print("<script>alert('���ȵ�¼��');location.href='login.jsp'</script>");
		}else {
			//����uid
			int uid = user.getUid();
			//����b_id
			String bidStr = request.getParameter("b_id");
			int b_id = 0;
			if(bidStr!=null && !"".equals(bidStr)) {
				b_id = Integer.parseInt(bidStr);
			}
			
			//����ҵ��㷽��
			CartService cs = new CartServiceImpl();
			Cart cart = new Cart();
			cart.setUid(uid);
			cart.setB_id(b_id);
			cart.setCount(1);
			int row = 0;
			try {
				row = cs.updateCart(cart);
				if(row==0) {
					cs.addCart(cart);
				}
			} catch (Exception e) {
				request.getRequestDispatcher("error.html").forward(request, response);
				return;
			}
			
			//ҳ����ת����ת����ѯ���ﳵ��servlet��FindAllCartByUidServlet
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
