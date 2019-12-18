package com.y3.service;

import com.y3.entity.Address;

/**
 * 地址业务层接口
 * @author Entity-G
 *
 */
public interface AddressService {

	Address findAddressByAdd_id(int add_id) throws Exception;//查询数据地址
	
}
