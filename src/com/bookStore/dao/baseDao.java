package com.bookStore.dao;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.List;
import java.util.Properties;

/**
 * 连接数据库的基类
 */
public class baseDao {
	public static final String CLASS_JAR_NAME = "oracle.jdbc.driver.OracleDriver";
	public static final String URL = "jdbc:oracle:thin:@localhost:1521:ORCL";
	public static final String USER = "book";
	public static final String PASSWORD = "book";
	public Connection conn = null;
	public PreparedStatement pstmt = null;
	Properties propt = null;

	/**
	 * 获取数据库连接
	 */
	public Connection getConnection() {
		try {
			Class.forName(CLASS_JAR_NAME);
			conn = DriverManager.getConnection(URL, USER, PASSWORD);
		} catch (ClassNotFoundException e) {
			e.printStackTrace();
		} catch (SQLException e) {
			e.printStackTrace();
		}
		return conn;
	}

	/**
	 * 释放资源
	 * 
	 * @param rs
	 */
	public void closeAll(ResultSet rs) {
		try {
			if (rs != null) {
				rs.close();
			}
			if (pstmt != null) {
				pstmt.close();
			}
			if (conn != null) {
				conn.close();
			}
		} catch (Exception e) {
			e.printStackTrace();
		}
	}

	public void closeAll(ResultSet rs,PreparedStatement pstmt,Connection conn){
		try{
			if(rs!=null){
				rs.close();
			}
			if(pstmt!=null){
				pstmt.close();
			}
			if(conn!=null){
				conn.close();
			}
		}catch(Exception ex){
			ex.printStackTrace();
		}
	}
	
	/**
	 * 泛型设置PreparedStatement的各个参数
	 * 
	 * @param psttm
	 *            传入的PreparedStatement对象
	 * @param list
	 *            泛型的形参，重用代码
	 */
	public <T> void setParam(List<T> list) {
		for (int i = 0; i < list.size(); i++) {
			try {
				this.pstmt.setObject(i + 1, list.get(i));
			} catch (SQLException e) {
				e.printStackTrace();
			}
		}

	}

	public int executeUpdate(String sql, Object[] params) {
		int rows = 0;
		try {
			pstmt = conn.prepareStatement(sql);
			for (int i = 0; i < params.length; i++) {
				pstmt.setObject(i + 1, params[i]);
			}
			rows = pstmt.executeUpdate();
		} catch (SQLException e) {
			e.printStackTrace();
		}
		return rows;
	}
}