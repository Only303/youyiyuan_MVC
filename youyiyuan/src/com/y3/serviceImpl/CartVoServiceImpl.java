package com.y3.serviceImpl;

import java.util.List;

import com.y3.dao.CartVoDao;
import com.y3.daoImpl.CartVoDaoImpl;
import com.y3.entity.CartVo;
import com.y3.service.CartVoService;
import com.y3.util.DBFactory;

/**
 * ���ﳵչʾ�嵥ҵ���ʵ����
 * @author Entity-G
 *
 */
public class CartVoServiceImpl implements CartVoService {

	private CartVoDao cvd = new CartVoDaoImpl();
	
	/**
	 * ��ѯ���ﳵ�嵥��Ϣ
	 */
	@Override
	public List<CartVo> findAllCartVoByUid(int uid) throws Exception {
		List<CartVo> list = null;
		try {
			list = cvd.findAllCartVoByUid(uid);
		} catch (Exception e) {
			e.printStackTrace();
		}finally {
			DBFactory.closeConnection();
		}
		return list;
	}

	/**
	 * ���ݹ��ﳵ���cid��ѯѡ��Ҫ�������Ʒ����ӵ�����
	 */
	@Override
	public List<CartVo> findCheckedCartByCid(String cidStr) throws Exception {
		List<CartVo> list = null;
		try {
			list = cvd.findCheckedCartByCid(cidStr);
		} catch (Exception e) {
			e.printStackTrace();
		}finally {
			DBFactory.closeConnection();
		}
		return list;
	}

}
