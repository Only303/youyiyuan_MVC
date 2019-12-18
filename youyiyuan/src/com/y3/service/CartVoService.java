package com.y3.service;

import java.util.List;

import com.y3.entity.CartVo;

/**
 * 通过用户id查寻
 * 业务层购物车清单展示接口
 * @author Entity-G
 *
 */
public interface CartVoService {

	List<CartVo> findAllCartVoByUid(int uid) throws Exception;//查询并展示购物车清单
	
	List<CartVo> findCheckedCartByCid(String cidStr) throws Exception;//根据购物车编号cid查询选中要结算的商品，添加到订单
	
}
