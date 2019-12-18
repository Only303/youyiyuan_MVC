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
 * չʾ���ﳵ��Ʒ��Ϣ�����ࣺshop_car.jsp-->Ŀ��ҳ��
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
		//���ղ���
		User user = (User) request.getSession().getAttribute("user");
		if(user == null) {
			response.getWriter().print("<script>alert('�û������������');location.href='login.jsp'</script>");
		}else {
			//��ȡuid
			int uid = 0;
			if(user!=null) {
				uid = user.getUid();
			}
			//����ҵ��㷽��
			CartVoService cvd = new CartVoServiceImpl();
			List<CartVo> list = null;
			try {
				list = cvd.findAllCartVoByUid(uid);
			} catch (Exception e) {
				request.getRequestDispatcher("error.html").forward(request, response);
			}
			if(list != null) {
				//���ݷ�װ������ת
				request.setAttribute("list", list);
				request.getRequestDispatcher("shop_car.jsp").forward(request, response);
			}else {
				response.getWriter().print("<script>alert('û�л�ȡ�����ݣ�');");
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
