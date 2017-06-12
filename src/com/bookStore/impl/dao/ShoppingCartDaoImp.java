package com.bookStore.impl.dao;

import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import com.bookStore.Entity.ShoppingCart;
import com.bookStore.Entity.User;
import com.bookStore.dao.ShoppingCartDao;
import com.bookStore.dao.baseDao;

public class ShoppingCartDaoImp extends baseDao implements ShoppingCartDao {

	public List<ShoppingCart> getUserCart(String user) {
		List<ShoppingCart> lists = new ArrayList<ShoppingCart>();
		String sql = "select * from SHOPPING_TROLLEY where user_name=?";
		// 如果user为空，则应当返回null不进行接下的语句
		if (user == null) {
			return null;
		}
		this.getConnection();
		ResultSet set;
		try {
			this.pstmt = this.conn.prepareStatement(sql);
			this.pstmt.setString(1, user);
			set = this.pstmt.executeQuery();
			while (set.next()) {
				ShoppingCart cart = new ShoppingCart(set.getInt("book_id"), set.getString("user_name"),
						set.getDouble("price"), set.getInt("amount"));
				lists.add(cart);
			}
		} catch (SQLException e) {
			e.printStackTrace();
		}

		// 集合用于存储查询到的数据

		return lists;
	}

	/**
	 * 添加商品，不能处理更新添加商品的数量，如果要处理更新商品数量信息，应使用updateItemMsg（）
	 */
	@SuppressWarnings("unchecked")
	public int addItem(ShoppingCart item) {
		String sql = "insert into SHOPPING_TROLLEY(book_id,Amount,PRICE,USER_NAME) values(?,?,?,?)";
		if (item == null) {
			return -1;
		}
		List list = new ArrayList();
		list.add(item.getBookId());
		list.add(item.getAmount());
		list.add(item.getPrice());
		list.add(item.getUserName());
		// 受影响的行数
		int rows = -1;
		try {
			rows = this.executeUpdate(sql, list);
		} catch (SQLException e) {
			e.printStackTrace();
		}
		return rows;
	}

	@SuppressWarnings("unchecked")
	public int delItem(ShoppingCart item) {
		String sql = "delete  SHOPPING_TROLLEY where user_name=? and book_id=?";
		if (item == null) {
			return -1;
		}
		List list = new ArrayList();
		list.add(item.getUserName());
		list.add(item.getBookId());
		// 受影响的行数
		int rows = -1;
		try {
			rows = this.executeUpdate(sql, list);
		} catch (SQLException e) {
			e.printStackTrace();
		}
		return rows;
	}

	@SuppressWarnings("unchecked")
	public int updateItemMsg(ShoppingCart item, int amount) {
		String sql = "update SHOPPING_TROLLEY st set st.amount=? where st.user_name=? and book_id=?";
		if (item == null) {
			return -1;
		}
		List list = new ArrayList();
		list.add(amount);
		list.add(item.getUserName());
		list.add(item.getBookId());
		// 受影响的行数
		int rows = -1;
		try {
			rows = this.executeUpdate(sql, list);
		} catch (SQLException e) {
			e.printStackTrace();
		}
		return rows;
	}

	/**
	 * 执行数据库操作
	 * 
	 * @param sql
	 *            数据库语句
	 * @param list
	 *            需要设置预编译的参数列表
	 * @return 返回受影响的行数
	 * @throws SQLException
	 */
	private int executeUpdate(String sql, List<Object> list) throws SQLException {
		// 该集合用于保存数据用
		int rows = -1;
		// 建立连接
		this.getConnection();
		// 预编译语句
		this.pstmt = this.conn.prepareStatement(sql);
		// 设置参数
		this.setParam(list);
		// 受影响行数
		rows = this.pstmt.executeUpdate();
		closeAll(null);
		return rows;
	}

}
