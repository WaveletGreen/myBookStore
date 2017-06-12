package com.bookStore.impl.dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import com.bookStore.Entity.orderD;
import com.bookStore.dao.baseDao;
import com.bookStore.dao.orderdDao;

public class orderdDaoImpl implements orderdDao {

	public int addOrderD(orderD ordD) {
		int rows = 0;
		baseDao bd = new baseDao();
		bd.getConnection();
		String sql = "insert into orderd_info(orderd_id,order_id_d,odbook_name,odbook_price,odbook_amount)"
				+ "values(seq_orderd.nextval,?,?,?,?)";
		Object[] params = new Object[] { ordD.getOrder_id(), ordD.getOdbook_name(), ordD.getOdbook_price(),
				ordD.getOdbook_amount() };
		rows = bd.executeUpdate(sql, params);
		return rows;
	}

	public int getOrderdRecords() {
		int max_orderdid = 0;
		baseDao bd = new baseDao();
		Connection conn = null;
		PreparedStatement pstmt = null;
		ResultSet rs = null;
		conn = bd.getConnection();

		String sql = "select max(orderd_id) from orderd_info";
		try {
			pstmt = conn.prepareStatement(sql);
			rs = pstmt.executeQuery();
		} catch (SQLException e) {
			e.printStackTrace();
		} finally {
			bd.closeAll(rs);
		}
		return max_orderdid;
	}

	public List<orderD> getOrderList(int pageIndex, int pageSize) {
		List<orderD> orderDlist = new ArrayList<orderD>();
		ResultSet rs = null;
		baseDao bd = new baseDao();
		PreparedStatement pstmt = null;
		Connection conn = null;

		conn = bd.getConnection();
		StringBuilder sql = new StringBuilder();
		sql.append("select * ")
				.append("from (select rownum r,orderd_info.* ").append("from orderd_info ").append("where 1=1 ")
				.append("and rownum<=?) ").append("where r>?");
		try {
			pstmt = conn.prepareStatement(sql.toString());
			int index = 1;
			pstmt.setInt(index++, pageSize * pageIndex);
			pstmt.setInt(index++, pageSize * (pageIndex - 1));
			rs = pstmt.executeQuery();
			while (rs.next()) {
				orderD ordD = new orderD();
				ordD.setOrderD_id(rs.getInt("orderd_id"));
				ordD.setOrder_id(rs.getInt("order_id_d"));
				ordD.setOdbook_name(rs.getString("odbook_name"));
				ordD.setOdbook_price(rs.getDouble("odbook_price"));
				ordD.setOdbook_amount(rs.getInt("odbook_amount"));
				orderDlist.add(ordD);
			}
		} catch (SQLException e) {
			e.printStackTrace();
		} finally {
			bd.closeAll(rs, pstmt, conn);
		}
		return orderDlist;
	}

	public List<orderD> getOrderList(int order_id,int pageIndex, int pageSize) {
		List<orderD> orderDlist = new ArrayList<orderD>();
		ResultSet rs = null;
		baseDao bd = new baseDao();
		PreparedStatement pstmt = null;
		Connection conn = null;

		conn = bd.getConnection();
		StringBuilder sql = new StringBuilder();
		sql.append("select * ")
				.append("from (select rownum r,orderd_info.* ").append("from orderd_info ").append("where 1=1 ")
				.append("order_id_d=?").append("and rownum<=?) ").append("where r>?");
		try {
			pstmt = conn.prepareStatement(sql.toString());
			int index = 1;
			pstmt.setInt(index++, order_id);
			pstmt.setInt(index++, pageSize * pageIndex);
			pstmt.setInt(index++, pageSize * (pageIndex - 1));
			rs = pstmt.executeQuery();
			while (rs.next()) {
				orderD ordD = new orderD();
				ordD.setOrderD_id(rs.getInt("orderd_id"));
				ordD.setOrder_id(rs.getInt("order_id"));
				ordD.setOdbook_name(rs.getString("orderd_name"));
				ordD.setOdbook_price(rs.getDouble("odbook_price"));
				ordD.setOdbook_amount(rs.getInt("odbook_amount"));
				orderDlist.add(ordD);
			}
		} catch (SQLException e) {
			e.printStackTrace();
		} finally {
			bd.closeAll(rs, pstmt, conn);
		}
		return orderDlist;
	}
}
