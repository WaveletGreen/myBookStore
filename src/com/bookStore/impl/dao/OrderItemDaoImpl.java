package com.bookStore.impl.dao;

import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import com.bookStore.Entity.Book;
import com.bookStore.Entity.OrderItem;
import com.bookStore.Entity.User;
import com.bookStore.Util.DateUtil;
import com.bookStore.Util.bookStoreUtil;
import com.bookStore.dao.OrderItemDao;
import com.bookStore.dao.baseDao;

public class OrderItemDaoImpl extends baseDao implements OrderItemDao {
	ResultSet set = null;

	public List<OrderItem> getUserIndent(User user) {
		// 获取链接
		this.getConnection();
		// 产生一个列表用于保存获取到的所有记录
		List<OrderItem> items = new ArrayList<OrderItem>();
		// 查询语句
		String sql = "select * from indent where user_name=?";
		try {
			// 预编译
			this.pstmt = this.conn.prepareStatement(sql);
			// 设置值
			this.pstmt.setString(1, user.getUserName());
			// 执行查询
			set = this.pstmt.executeQuery();
			while (set.next()) {
				OrderItem item = new OrderItem();

				item.setUser_Name(set.getString("user_name"));
				System.out.println("------" + set.getString("user_name"));

				item.setIndent_status(set.getInt("indent_no"));
				System.out.println("------" + set.getInt("indent_no"));

				item.setConsignee(set.getString("consignee"));
				System.out.println("------" + set.getString("consignee"));

				item.setOrder_time(set.getTimestamp("order_time"));
				System.out.println(DateUtil.dateFormat(set.getTimestamp("order_time")));

				item.setIndent_No(set.getInt("indent_status"));
				System.out.println(set.getInt("indent_status"));

				item.setGoods_id(set.getInt("goods_id"));
				System.out.println(set.getInt("goods_id"));

				items.add(item);
			}
			this.closeAll(set);
			return items;
		} catch (SQLException e) {
			e.printStackTrace();
		}
		return null;
	}

	public int delItem(OrderItem item, User user) {
		String sql = "delete from indent where indent_no=?";
		int rows = 0;
		this.getConnection();

		try {
			// 预编译
			this.pstmt = this.conn.prepareStatement(sql);
			// 设置值
			this.pstmt.setInt(1, item.getIndent_No());
			// 更新
			rows = this.pstmt.executeUpdate();
			System.out.println("----------执行删除订单成功--------------");
			return rows;
		} catch (SQLException e) {
			e.printStackTrace();
		}
		return 0;
	}

	public int add(Book item, User user) {
		String sql = "insert into indent(indent_no,goods_id,consignee,order_time,indent_status,user_name) "
				+ "values(seq_indent_no.nextval,?,?,sysdate,2,?)";
		int rows = 0;
		this.getConnection();

		try {
			// 预编译
			this.pstmt = this.conn.prepareStatement(sql);
			// 设置值
			this.pstmt.setInt(1, item.getBook_id());
			this.pstmt.setString(2, user.getUserName());
			this.pstmt.setString(3, user.getUserName());
			// 更新
			rows = this.pstmt.executeUpdate();
			System.out.println("----------执行增加订单成功--------------");
			return rows;
		} catch (SQLException e) {
			e.printStackTrace();
		}
		return 0;
	}

}
