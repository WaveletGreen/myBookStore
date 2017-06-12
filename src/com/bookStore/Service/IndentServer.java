package com.bookStore.Service;

import java.util.List;

import com.bookStore.Entity.Book;
import com.bookStore.Entity.OrderItem;
import com.bookStore.Entity.User;

public interface IndentServer {
	/**
	 * 查看购物车内容
	 * 
	 * @param user
	 *            登录的用户
	 * @return
	 */
	public List<OrderItem> viewIndent(User user);

	/**
	 * 删除购物车物品内容
	 * 
	 * @return
	 */
	public int delIndentItem(User user, OrderItem item);

	/**
	 * 增加到购物车
	 * 
	 * @param user
	 *            操作的用户
	 * @param item
	 *            添加的商品
	 * @return
	 */
	public int addToIndent(User user, Book item);
}
