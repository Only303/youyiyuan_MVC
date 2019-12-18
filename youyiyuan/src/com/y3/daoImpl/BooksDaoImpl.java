package com.y3.daoImpl;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.util.ArrayList;
import java.util.List;

import com.y3.dao.BooksDao;
import com.y3.entity.BookKindVo;
import com.y3.entity.Books;
import com.y3.util.DBFactory;

/**
 * �־ò�ͼ��ӿ�ʵ����
 * @author Entity-G
 *
 */
public class BooksDaoImpl implements BooksDao {

	/**
	 * ����ģ����ѯ����
	 * ��������ͼ����Ϣ
	 * ����
	 * ����ͼ�����ͱ��
	 * ��ѯ��Ӧ���͵�����ͼ��
	 */
	@Override
	public List<Books> findAllBooks(String dimStr,int bk_id) throws Exception {
		List<Books> list = new ArrayList<Books>();
		PreparedStatement ps = null;
		ResultSet rs = null;
		try {
			Connection conn = DBFactory.openConncetion();
			//ԭʼ��select * from books b left JOIN book_kind bk ON b.bk_id=bk.bk_id
			//ģ����ѯ��
			//SELECT * FROM books b LEFT JOIN book_kind bk ON b.bk_id=bk.bk_id WHERE b.bname LIKE '%java%' OR b.bauto LIKE '%5%' OR bk.bk_id=-1
			String sql;
			if(bk_id == -1) {
				sql = "SELECT * FROM books b LEFT JOIN book_kind bk ON b.bk_id=bk.bk_id WHERE b.bname LIKE '%"+dimStr+"%' OR b.bauto LIKE '%"+dimStr+"%' OR bk.bk_id=?";
			}else {
				sql = "SELECT * FROM books b LEFT JOIN book_kind bk on b.bk_id=bk.bk_id WHERE bk.bk_id=?";
			}
			ps = conn.prepareStatement(sql);
			ps.setInt(1, bk_id);
			rs = ps.executeQuery();
			while(rs.next()) {
				Books book = new Books();
				book.setB_id(rs.getInt("b_id"));
				book.setBname(rs.getString("bname"));
				book.setBprice(rs.getDouble("bprice"));
				book.setB_press(rs.getString("b_press"));
				book.setB_press_time(rs.getDate("b_press_time"));
				book.setBimg(rs.getString("bimg"));
				book.setBauto(rs.getString("bauto"));
				book.setBk_id(rs.getInt("bk_id"));
				book.setBk_name(rs.getString("bk_name"));
				list.add(book);
			}
		} catch (Exception e) {
			e.printStackTrace();
		}finally {
			if(rs!=null) {
				rs.close();
			}
			if(ps!=null) {
				ps.close();
			}
		}
		return list;
	}

	/**
	 * ����ͼ���Ų�ѯͼ������
	 */
	@Override
	public Books findBookInfoByBid(int bid) throws Exception {
		BookKindVo book = new BookKindVo();
		PreparedStatement ps = null;
		ResultSet rs = null;
		try {
			Connection conn = DBFactory.openConncetion();
			String sql = "select b.*,bk.* from books b inner join book_kind bk where b.bk_id=bk.bk_id and b.b_id=?";
			ps = conn.prepareStatement(sql);
			ps.setInt(1, bid);
			rs = ps.executeQuery();
			while(rs.next()) {
				book.setBk_id(rs.getInt("bk_id"));
				book.setBk_name(rs.getString("bk_name"));
				book.setB_id(rs.getInt("b_id"));
				book.setBname(rs.getString("bname"));
				book.setBprice(rs.getDouble("bprice"));
				book.setB_press(rs.getString("b_press"));
				book.setB_press_time(rs.getDate("b_press_time"));
				book.setBimg(rs.getString("bimg"));
				book.setBauto(rs.getString("bauto"));
			}
		} catch (Exception e) {
			e.printStackTrace();
		}finally {
			if(rs!=null) {
				rs.close();
			}
			if(ps!=null) {
				ps.close();
			}
		}
		return book;
	}

	/**
	 * ͼ������
	 */
	@Override
	public int findBooksCount() throws Exception {
		int count = 0;
		PreparedStatement ps = null;
		ResultSet rs = null;
		try {
			Connection conn = DBFactory.openConncetion();
			String sql = "SELECT COUNT(*) FROM books";
			ps = conn.prepareStatement(sql);
			rs = ps.executeQuery();
			if(rs.next()) {
				count = rs.getInt(1);
			}
		} catch (Exception e) {
			e.printStackTrace();
		}finally {
			if(rs!=null) {
				rs.close();
			}
			if(ps!=null) {
				ps.close();
			}
		}
		return count;
	}

	/**
	 * ��̨-��ҳ��ѯ
	 */
	@Override
	public List<Books> findAllBooks(int currentPage, int pageSize) throws Exception {
		List<Books> list = new ArrayList<Books>();
		PreparedStatement ps = null;
		ResultSet rs = null;
		try {
			Connection conn = DBFactory.openConncetion();
			String sql = "SELECT * FROM books WHERE 1=1 LIMIT ?,?";
			ps = conn.prepareStatement(sql);
			ps.setInt(1, (currentPage-1)+pageSize);
			ps.setInt(2, pageSize);
			rs = ps.executeQuery();
			while(rs.next()) {
				Books book = new Books();
				book.setBk_id(rs.getInt("bk_id"));
				book.setB_id(rs.getInt("b_id"));
				book.setBname(rs.getString("bname"));
				book.setBprice(rs.getDouble("bprice"));
				book.setB_press(rs.getString("b_press"));
				book.setB_press_time(rs.getDate("b_press_time"));
				book.setBimg(rs.getString("bimg"));
				book.setBauto(rs.getString("bauto"));
				list.add(book);
			}
		} catch (Exception e) {
			e.printStackTrace();
		}finally {
			if(rs!=null) {
				rs.close();
			}
			if(ps!=null) {
				ps.close();
			}
		}
		return list;
	}

}
