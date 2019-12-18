package com.y3.dao;

import java.util.List;

import com.y3.entity.CartVo;

/**
 * 数据层购物车清单展示接口
 * @author Entity-G
 *
 */
public interface CartVoDao {

	List<CartVo> findAllCartVoByUid(int uid) throws Exception;//查询并展示购物车清单
	
	List<CartVo> findCheckedCartByCid(String cidStr) throws Exception;//根据购物车编号cidStr查询选中要结算的商品，添加到订单
	
	CartVo findCheckedCartByCid(int cid) throws Exception;//根据购物车编号cid查询选中要结算的商品，添加到订单
	
	int deleteCartVo(String cidStr) throws Exception;//根据cidStr删除购物车信息
	
}
