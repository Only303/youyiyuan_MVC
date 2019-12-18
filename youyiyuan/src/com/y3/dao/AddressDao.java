package com.y3.dao;

import com.y3.entity.Address;

/**
 * 地址数据层
 * @author Entity-G
 */
public interface AddressDao {
	
	Address findAddressByAdd_id(int add_id) throws Exception;//查询数据地址
	
}
