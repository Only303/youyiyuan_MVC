package com.y3.daoImpl;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.util.ArrayList;
import java.util.List;

import com.y3.dao.BookKindDao;
import com.y3.entity.BookKind;
import com.y3.util.DBFactory;

/**
 * ͼ��־ò�ӿ�ʵ����
 * @author Entity-G
 *
 */
public class BookKindDaoImpl implements BookKindDao {

	/**
	 * ��̨-��ѯͼ�����ͣ����У�+��ҳ
	 * @param currentPage
	 * @param pageSize
	 * @return
	 * @throws Exception
	 */
	@Override
	public List<BookKind> findAllBookKind(int currentPage,int pageSize) throws Exception {
		List<BookKind> listBK = new ArrayList<BookKind>();
		PreparedStatement ps = null;
		ResultSet rs =  null;
		try {
			Connection conn = DBFactory.openConncetion();
			String sql = "SELECT * FROM `book_kind` WHERE 1=1 LIMIT ?,?";
			ps = conn.prepareStatement(sql);
			ps.setInt(1, (currentPage-1)*pageSize);
			ps.setInt(2, pageSize);
			rs = ps.executeQuery();
			while(rs.next()) {
				BookKind bk = new BookKind();
				bk.setBk_id(rs.getInt("bk_id"));
				bk.setBk_name(rs.getString("bk_name"));
				bk.setBk_img(rs.getString("bk_img"));
				listBK.add(bk);
			}
		} catch (Exception e) {
			e.printStackTrace();
		} finally {
			if(rs!=null) {
				rs.close();
			}
			if(ps!=null) {
				ps.close();
			}
		}
		return listBK;
	}

	/**
	 * ��ѯͼ�����͵�����
	 */
	@Override
	public int findBookKindCount() throws Exception {
		int row = 0;
		PreparedStatement ps = null;
		ResultSet rs =  null;
		try {
			Connection conn = DBFactory.openConncetion();
			String sql = "SELECT count(*) FROM `book_kind`";
			ps = conn.prepareStatement(sql);
			rs = ps.executeQuery();
			if(rs.next()) {
				row = rs.getInt(1);
			}
		} catch (Exception e) {
			e.printStackTrace();
		} finally {
			if(rs!=null) {
				rs.close();
			}
			if(ps!=null) {
				ps.close();
			}
		}
		return row;
	}

	/**
	 * ��ѯ����ͼ�������б�
	 */
	@Override
	public List<BookKind> findAllBookKind() throws Exception {
		List<BookKind> listBK = new ArrayList<BookKind>();
		PreparedStatement ps = null;
		ResultSet rs =  null;
		try {
			Connection conn = DBFactory.openConncetion();
			String sql = "SELECT * FROM `book_kind`";
			ps = conn.prepareStatement(sql);
			rs = ps.executeQuery();
			while(rs.next()) {
				BookKind bk = new BookKind();
				bk.setBk_id(rs.getInt("bk_id"));
				bk.setBk_name(rs.getString("bk_name"));
				bk.setBk_img(rs.getString("bk_img"));
				listBK.add(bk);
			}
		} catch (Exception e) {
			e.printStackTrace();
		} finally {
			if(rs!=null) {
				rs.close();
			}
			if(ps!=null) {
				ps.close();
			}
		}
		return listBK;
	}

}
