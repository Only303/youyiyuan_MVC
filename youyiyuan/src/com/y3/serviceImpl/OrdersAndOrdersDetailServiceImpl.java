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
 * �ύ����
 * �Թ��ﳵ������������������ҵ�����
 * @author Entity-G
 */
public class OrdersAndOrdersDetailServiceImpl implements OrdersAndOrdersDetailService {

	private OrdersDao od = new OrdersDaoImpl();
	private OrdersDetailDao odd = new OrdersDetailDaoImpl();
	private CartVoDao cvd = new CartVoDaoImpl();
	/**
	 * �ύ����ʱ��ҵ�����
	 * 1.�������������
	 * 2.����������������
	 * 3.���ﳵɾ����¼
	 */
	@Override
	public void submitOrders(String oid,String cidStr,int uid,double total,String uremark,String address,Timestamp otime) throws Exception {
		try {
			//��������
			DBFactory.openConncetion();
			DBFactory.beginTranaction();
			
			//��Ӷ���
			Orders orders = new Orders();
			orders.setOid(oid);
			orders.setOtime(otime);//��ȡ�µ�ʱ��
			orders.setState("���ύ");//����״̬
			orders.setTotal(total);
			orders.setUid(uid);
			orders.setUremark(uremark);
			od.addOrders(orders);
			
			//��Ӷ�������
			OrdersDetail oDetail = new OrdersDetail();
			CartVoDao cv = new CartVoDaoImpl();
			//ͨ��cidStr��ȡ���������
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
			//ɾ�����ﳵ��Ϣ
			cvd.deleteCartVo(cidStr);
			//�ύ����
			DBFactory.commit();
		} catch (Exception e) {
			//�ع�����
			DBFactory.rollback();
			//��ӡ�쳣��Ϣ
			e.printStackTrace();
		}finally {
			//�ر�����
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
	 * ��̨��ҳ��ѯ����
	 */
	@Override
	public PageUtil<OrdersVo> findAllOrdersByPage(int currentPage, int pageSize) throws Exception {
		PageUtil<OrdersVo> pageList = new PageUtil<OrdersVo>();
		List<OrdersVo> list = new ArrayList<OrdersVo>();
		try {
			list = od.findAllOrdersByPage(currentPage, pageSize);//���󼯺�
			int total = od.findOrdersCount();//����
			int pageCount = total%pageSize==0?total/pageSize:total/pageSize+1;//��ҳ��
			
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
	 * �����������ʱ����
	 */
	@Override
	public void addOrdersAndOrdersDetail(String oid,int uid,String uremark,String address,Timestamp otime,int b_id,int count,double totalPrice) throws Exception {
		try {
			//��������
			DBFactory.openConncetion();
			DBFactory.beginTranaction();
			
			//��Ӷ���
			Orders orders = new Orders();
			orders.setOid(oid);
			orders.setOtime(otime);//��ȡ�µ�ʱ��
			orders.setState("���ύ");//����״̬
			orders.setTotal(totalPrice);
			orders.setUid(uid);
			orders.setUremark(uremark);
			od.addOrders(orders);
			
			//��Ӷ�������
			OrdersDetail oDetail = new OrdersDetail();
			//ͨ��cidStr��ȡ���������
				oDetail.setAddress(address);
				oDetail.setB_id(b_id);
				oDetail.setOdcount(count);
				oDetail.setPrice(totalPrice);
				oDetail.setOid(oid);
				odd.addOrdersDetail(oDetail);
			//�ύ����
			DBFactory.commit();
		} catch (Exception e) {
			//�ع�����
			DBFactory.rollback();
			//��ӡ�쳣��Ϣ
			e.printStackTrace();
		}finally {
			//�ر�����
			DBFactory.closeConnection();
		}
	}
	
}
