package com.bookStore.dao;

import java.util.List;

import com.bookStore.Entity.User;

/**用户访问用户信息数据库接口
 * 
 * @author Administrator
 *
 */
public interface UserDao {
	/**
	 * 根据用户名  ，查询用户信息
	 * @return
	 */
	public List<User> getByName(String userName);
	/**
	 * 添加用户
	 * @param user
	 * @return
	 */
	public int add(User user);
}
