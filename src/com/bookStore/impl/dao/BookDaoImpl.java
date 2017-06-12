package com.bookStore.impl.dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import com.bookStore.Entity.Book;
import com.bookStore.Util.StringUtil;
import com.bookStore.dao.BookDao;
import com.bookStore.dao.baseDao;

/**
 * 图书实现类
 * 
 * @author Administrator
 * 
 */
public class BookDaoImpl extends baseDao implements BookDao {
	/**
	 * 根据图书名称获取图书信息列表，如果名字为空，返回全部图书信息
	 * 
	 * @param bookName
	 * @return
	 */
	public List<Book> getBookList(String bookName) {
		List<Book> bookList = new ArrayList<Book>();
		Connection conn = null;
		PreparedStatement pstmt = null;
		ResultSet rs = null;

		conn = this.getConnection();
		StringBuilder sql = new StringBuilder();
		sql.append("select * " + "from book_info where 1=1");
		if (!StringUtil.isNullOrEmpty(bookName)) {
			sql.append(" and book_name like ? ");
		}
		try {
			pstmt = conn.prepareStatement(sql.toString());
			if (!StringUtil.isNullOrEmpty(bookName)) {
				pstmt.setString(1, "%"+bookName+"%");
			}
			System.out.println(sql);
			rs = pstmt.executeQuery();
			while (rs.next()) {
				Book book = new Book();
				book.setBook_id(rs.getInt("book_id"));
				book.setBook_name(rs.getString("book_name"));
				book.setPrice(rs.getDouble("book_price"));
				book.setAmount(rs.getInt("book_stock"));
				book.setPic_path(rs.getString("book_photo"));
				bookList.add(book);
			}
		} catch (SQLException e) {
			e.printStackTrace();
		} finally {
			this.closeAll(rs);
		}
		return bookList;
	}

	/**
	 * 根据书名查询指定页面的图书信息
	 * 
	 * @param bookName
	 * @param pageSize
	 * @param pageIndex
	 * @return
	 */
	public List<Book> getByPage(String bookName, int pageSize, int pageIndex) {
		List<Book> bookList = new ArrayList<Book>();
		ResultSet rs = null;
		Connection conn = null;
		PreparedStatement pstmt = null;

		conn = this.getConnection();
		StringBuilder sql = new StringBuilder();
		sql.append("select *").append(" from(select rownum r, g.*  from book_info g ")
				.append(" where 1=1");
		if (!StringUtil.isNullOrEmpty(bookName)) {
			sql.append("     and book_name like ?");
		}
		sql.append("     and rownum<=?)").append("  where r>?");
		try {
			pstmt = conn.prepareStatement(sql.toString());
			int index = 1;
			if (!StringUtil.isNullOrEmpty(bookName)) {
				pstmt.setString(index++, "%" + bookName + "%");
			}
			if(pageIndex-1<=0){
				pageIndex=1;
			}
			pstmt.setInt(index++, pageSize * pageIndex);
			pstmt.setInt(index++, pageSize * (pageIndex - 1));
			rs = pstmt.executeQuery();
			while (rs.next()) {
				Book book = new Book();
				book.setBook_id(rs.getInt("book_id"));
				book.setBook_name(rs.getString("book_name"));
				book.setPrice(rs.getDouble("book_price"));
				book.setAmount(rs.getInt("book_stock"));
				book.setPic_path(rs.getString("book_photo"));
				bookList.add(book);
			}
		} catch (SQLException e) {
			e.printStackTrace();
		} finally {
			this.closeAll(rs);
		}
		return bookList;
	}

	public Book getById(int bookId) {
		Book book = null;
		Connection conn = null;
		PreparedStatement pstmt = null;
		ResultSet rs = null;

		conn = this.getConnection();
		StringBuilder sql = new StringBuilder();
		sql.append("select* " + "from book_info where book_id=?");
		try {
			pstmt = conn.prepareStatement(sql.toString());
			pstmt.setInt(1, bookId);
			rs = pstmt.executeQuery();
			if (rs.next()) {
				book = new Book();
				book.setBook_id(rs.getInt("book_id"));
				book.setBook_name(rs.getString("book_name"));
				book.setPrice(rs.getDouble("price"));
				book.setAmount(rs.getInt("amount"));
				book.setPic_path(rs.getString("pic_path"));
			}
		} catch (SQLException e) {
			e.printStackTrace();
		} finally {
			this.closeAll(rs);
		}
		return book;
	}

	public List<Book> getBooksPages(String bookName, int index, int PageSize) {
		return null;
	}

	public List<Book> getBookLists(ArrayList<Integer> list) {
		String sql = "select * from book_info where book_id=?";
		this.getConnection();
		ResultSet set = null;
		List<Book> bookList = new ArrayList<Book>();
		try {
			this.pstmt = this.conn.prepareStatement(sql);
			for (int i = 0; i < list.size(); i++) {
				this.pstmt.setObject(1, list.get(i));
				set = this.pstmt.executeQuery();
				if (set.next()) {
					Book book = new Book();
					book.setAmount(set.getInt("book_stock"));
					book.setBook_id(set.getInt("book_id"));
					book.setBook_name(set.getString("book_name"));
					book.setPrice(set.getDouble("book_price"));
					book.setPic_path(set.getString("book_photo"));
					bookList.add(book);
				}
			}

		} catch (SQLException e) {
			e.printStackTrace();
		}

		closeAll(set);
		return bookList;
	}
}
