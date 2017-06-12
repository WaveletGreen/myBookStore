package com.bookStore.dao;

import java.util.List;

import com.bookStore.Entity.Book;
import com.bookStore.Entity.OrderItem;
import com.bookStore.Entity.User;

/**
 * 访问商品明细数据库接口
 * 
 * @author Administrator
 * 
 */
public interface OrderItemDao {
	/**
	 * 获取用户的订单
	 * 
	 * @param user
	 *            登录的用户
	 * @return
	 */
	public List<OrderItem> getUserIndent(User user);

	/**
	 * 将数据添加到购物车中，关联到用户的购物车
	 * 
	 * @param item
	 *            订单信息
	 * @param user
	 *            关联到的用户
	 * @return
	 */
	public int add(Book item, User user);

	/**
	 * 删除购物车内容
	 * 
	 * @param item
	 *            需要删除的记录
	 * @param user
	 *            操作的用户
	 * @return
	 */
	public int delItem(OrderItem item, User user);
}
