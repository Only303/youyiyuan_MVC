package com.y3.controller;

import java.io.IOException;
import java.util.List;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.y3.entity.Address;
import com.y3.entity.CartVo;
import com.y3.service.AddressService;
import com.y3.service.CartVoService;
import com.y3.serviceImpl.AddressServiceImpl;
import com.y3.serviceImpl.CartVoServiceImpl;

/**
 * 根据购物车编号cid查询选中要结算的商品，添加到订单
 * Servlet implementation class ShowCheckedCartByCidServlet
 */
@WebServlet("/ShowCheckedCartByCidServlet")
public class ShowCheckedCartByCidServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public ShowCheckedCartByCidServlet() {
        super();
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		request.setCharacterEncoding("utf-8");
		response.setContentType("text/html;charset=utf-8");
		//接受参数：cid
		String[] cid = request.getParameterValues("cid");
		if(cid==null) {
			response.getWriter().print("<script>alert('请选择商品！');location.href='FindAllCartByUidServlet';</script>");
		}else {
			StringBuilder cidStr = new StringBuilder();
			int len = cid.length;
			for(int i=0;i<len;i++) {
				cidStr.append(cid[i]);
				if(i != len-1) {
					cidStr.append(",");
				}
			}
			
			//获取地址
			String a_idStr = request.getParameter("selects");
			int add_id = 0;
			if(a_idStr!=null && !"".equals(a_idStr)) {
				add_id = Integer.parseInt(a_idStr);
			}
			
			//调用业务层方法
			CartVoService cvs = new CartVoServiceImpl();
			List<CartVo> list = null;
			AddressService as = new AddressServiceImpl();
			Address address = null;
			try {
				list = cvs.findCheckedCartByCid(cidStr.toString());
				address = as.findAddressByAdd_id(add_id);
				
			} catch (Exception e) {
				request.getRequestDispatcher("error.html").forward(request, response);
			}
			
			
			
			//封装数据，并跳转订单页面：count.jsp
			request.setAttribute("list", list);
			request.setAttribute("address", address);
			request.setAttribute("cidStr", cidStr.toString());
			request.getRequestDispatcher("count.jsp").forward(request, response);
		}
		
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		doGet(request, response);
	}

}
