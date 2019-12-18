package com.y3.serviceImpl;

import com.y3.dao.AddressDao;
import com.y3.daoImpl.AddressDaoImpl;
import com.y3.entity.Address;
import com.y3.service.AddressService;
import com.y3.util.DBFactory;

/**
 * 地址业务层接口
 * @author Entity-G
 *
 */
public class AddressServiceImpl implements AddressService {

	private AddressDao ad = new AddressDaoImpl();
	
	@Override
	public Address findAddressByAdd_id(int add_id) throws Exception {
		Address adaddress = null;
		try {
			adaddress = ad.findAddressByAdd_id(add_id);
		} catch (Exception e) {
			e.printStackTrace();
		} finally {
			DBFactory.closeConnection();
		}
		return adaddress;
	}

}
