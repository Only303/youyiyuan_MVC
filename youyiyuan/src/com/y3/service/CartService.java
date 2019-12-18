package com.y3.service;

import com.y3.entity.Cart;

/**
 * 购物车业务层接口
 * @author Entity-G
 *
 */
public interface CartService {
	
	int addCart(Cart cart) throws Exception;//添加购物车
	
	int updateCart(Cart cart) throws Exception;//修改购物车
	
	int deleteCart(int cid) throws Exception;//根据购物车编号删除购物车信息
	
	int deleteCart(int uid,int b_id) throws Exception;//根据购物车编号删除购物车信息
	
}
