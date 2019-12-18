package com.y3.daoImpl;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;

import com.y3.dao.AddressDao;
import com.y3.entity.Address;
import com.y3.util.DBFactory;
/**
 * 地址数据层接口
 * @author Entity-G
 *
 */
public class AddressDaoImpl implements AddressDao {

	/**
	 * 查询地址
	 */
	@Override
	public Address findAddressByAdd_id(int add_id) throws Exception {
		Address address = new Address();
		PreparedStatement ps = null;
		ResultSet rs = null;
		try {
			Connection conn = DBFactory.openConncetion();
			String sql = "select * from address where add_id=?";
			ps = conn.prepareStatement(sql);
			ps.setInt(1, add_id);
			rs = ps.executeQuery();
			if(rs.next()) {
				address.setAdd_id(add_id);
				address.setAddress(rs.getString("address"));
			}
		} catch (Exception e) {
			e.printStackTrace();
		}finally {
			rs.close();
			ps.close();
		}
		return address;
	}

}
