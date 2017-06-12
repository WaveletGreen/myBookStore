package com.bookStore.impl.dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import com.bookStore.Entity.User;
import com.bookStore.dao.UserDao;
import com.bookStore.dao.baseDao;

public class UserDaoImple extends baseDao implements UserDao {

	public List<User> getByName(String userName) {
		List<User> userList = new ArrayList<User>();
		Connection conn = null;
		PreparedStatement pstmt = null;
		ResultSet rs = null;
		try {
			conn = this.getConnection();
			pstmt = conn.prepareStatement("select * from user_info where user_name=?");
			pstmt.setString(1, userName);
			rs = pstmt.executeQuery();
			if (rs.next()) {
				User user = new User();
				user.setUserName(rs.getString("user_name"));
				user.setPassword(rs.getString("password"));
				userList.add(user);
			}
		} catch (SQLException e) {
			e.printStackTrace();
		}

		return userList;
	}

	public int add(User user) {
		int result = 0;
		Connection conn = null;
		PreparedStatement pstmt = null;
		StringBuilder sql = new StringBuilder().append("insert into user_info(user_name,PASSWORD,email) values(?,?,?)");
		try {
			conn = this.getConnection();
			pstmt = conn.prepareStatement(sql.toString());
			pstmt.setString(1, user.getUserName());
			pstmt.setString(2, user.getPassword());
			pstmt.setString(3, user.getEmail());
			result = pstmt.executeUpdate();
		} catch (SQLException e) {
			e.printStackTrace();
		}
		return result;
	}
}
