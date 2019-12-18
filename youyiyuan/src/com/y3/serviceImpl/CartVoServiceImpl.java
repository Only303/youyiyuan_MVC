package com.y3.serviceImpl;

import java.util.List;

import com.y3.dao.CartVoDao;
import com.y3.daoImpl.CartVoDaoImpl;
import com.y3.entity.CartVo;
import com.y3.service.CartVoService;
import com.y3.util.DBFactory;

/**
 * 购物车展示清单业务层实现类
 * @author Entity-G
 *
 */
public class CartVoServiceImpl implements CartVoService {

	private CartVoDao cvd = new CartVoDaoImpl();
	
	/**
	 * 查询购物车清单信息
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
	 * 根据购物车编号cid查询选中要结算的商品，添加到订单
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
