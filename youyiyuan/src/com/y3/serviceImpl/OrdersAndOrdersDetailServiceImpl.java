package com.y3.serviceImpl;

import java.sql.Timestamp;
import java.util.ArrayList;
import java.util.List;

import com.y3.dao.CartVoDao;
import com.y3.dao.OrdersDao;
import com.y3.dao.OrdersDetailDao;
import com.y3.daoImpl.CartVoDaoImpl;
import com.y3.daoImpl.OrdersDaoImpl;
import com.y3.daoImpl.OrdersDetailDaoImpl;
import com.y3.entity.CartVo;
import com.y3.entity.Orders;
import com.y3.entity.OrdersDetail;
import com.y3.entity.OrdersDetailVo;
import com.y3.entity.OrdersVo;
import com.y3.service.OrdersAndOrdersDetailService;
import com.y3.util.DBFactory;
import com.y3.util.PageUtil;

/**
 * 提交订单
 * 对购物车表、订单表、订单详情表的业务操作
 * @author Entity-G
 */
public class OrdersAndOrdersDetailServiceImpl implements OrdersAndOrdersDetailService {

	private OrdersDao od = new OrdersDaoImpl();
	private OrdersDetailDao odd = new OrdersDetailDaoImpl();
	private CartVoDao cvd = new CartVoDaoImpl();
	/**
	 * 提交订单时的业务操作
	 * 1.订单表添加数据
	 * 2.订单详情表添加数据
	 * 3.购物车删除记录
	 */
	@Override
	public void submitOrders(String oid,String cidStr,int uid,double total,String uremark,String address,Timestamp otime) throws Exception {
		try {
			//开启事务
			DBFactory.openConncetion();
			DBFactory.beginTranaction();
			
			//添加订单
			Orders orders = new Orders();
			orders.setOid(oid);
			orders.setOtime(otime);//获取下单时间
			orders.setState("已提交");//订单状态
			orders.setTotal(total);
			orders.setUid(uid);
			orders.setUremark(uremark);
			od.addOrders(orders);
			
			//添加订单详情
			OrdersDetail oDetail = new OrdersDetail();
			CartVoDao cv = new CartVoDaoImpl();
			//通过cidStr获取所需的数据
			String[] cidArr = cidStr.split(",");
			int len = cidArr.length;
			int cid = 0;
			for(int i=0;i<len;i++) {
				cid = Integer.parseInt(cidArr[i]);
				CartVo cartVo = cv.findCheckedCartByCid(cid);
				oDetail.setAddress(address);
				oDetail.setB_id(cartVo.getB_id());
				oDetail.setOdcount(cartVo.getCount());
				oDetail.setPrice(cartVo.getBprice());
				oDetail.setOid(oid);
				odd.addOrdersDetail(oDetail);
			}
			//删除购物车信息
			cvd.deleteCartVo(cidStr);
			//提交事务
			DBFactory.commit();
		} catch (Exception e) {
			//回滚事务
			DBFactory.rollback();
			//打印异常信息
			e.printStackTrace();
		}finally {
			//关闭连接
			DBFactory.closeConnection();
		}
	}
	@Override
	public List<OrdersDetailVo> findOrdersDetailVoByUid(int uid) throws Exception {
		List<OrdersDetailVo> list = null;
		try {
			list = odd.findOrdersDetailVoByUid(uid);
		} catch (Exception e) {
			e.printStackTrace();
		} finally {
			DBFactory.closeConnection();
		}
		return list;
	}
	
	/**
	 * 后台分页查询订单
	 */
	@Override
	public PageUtil<OrdersVo> findAllOrdersByPage(int currentPage, int pageSize) throws Exception {
		PageUtil<OrdersVo> pageList = new PageUtil<OrdersVo>();
		List<OrdersVo> list = new ArrayList<OrdersVo>();
		try {
			list = od.findAllOrdersByPage(currentPage, pageSize);//对象集合
			int total = od.findOrdersCount();//总数
			int pageCount = total%pageSize==0?total/pageSize:total/pageSize+1;//总页数
			
			pageList.setCurrentPage(currentPage);
			pageList.setList(list);
			pageList.setPageCount(pageCount);
			pageList.setPageSize(pageSize);
			pageList.setTotal(total);
		} catch (Exception e) {
			e.printStackTrace();
		} finally {
			DBFactory.closeConnection();
		}
		return pageList;
	}
	@Override
	public int findOrdersCount() throws Exception {
		int count = 0;
		try {
			count = od.findOrdersCount();
		} catch (Exception e) {
			e.printStackTrace();
		} finally {
			DBFactory.closeConnection();
		}
		return count;
	}
	
	/**
	 * 点击立即购买时触发
	 */
	@Override
	public void addOrdersAndOrdersDetail(String oid,int uid,String uremark,String address,Timestamp otime,int b_id,int count,double totalPrice) throws Exception {
		try {
			//开启事务
			DBFactory.openConncetion();
			DBFactory.beginTranaction();
			
			//添加订单
			Orders orders = new Orders();
			orders.setOid(oid);
			orders.setOtime(otime);//获取下单时间
			orders.setState("已提交");//订单状态
			orders.setTotal(totalPrice);
			orders.setUid(uid);
			orders.setUremark(uremark);
			od.addOrders(orders);
			
			//添加订单详情
			OrdersDetail oDetail = new OrdersDetail();
			//通过cidStr获取所需的数据
				oDetail.setAddress(address);
				oDetail.setB_id(b_id);
				oDetail.setOdcount(count);
				oDetail.setPrice(totalPrice);
				oDetail.setOid(oid);
				odd.addOrdersDetail(oDetail);
			//提交事务
			DBFactory.commit();
		} catch (Exception e) {
			//回滚事务
			DBFactory.rollback();
			//打印异常信息
			e.printStackTrace();
		}finally {
			//关闭连接
			DBFactory.closeConnection();
		}
	}
	
}
