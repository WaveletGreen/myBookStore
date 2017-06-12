package com.bookStore.dao;

import java.util.List;

import com.bookStore.Entity.ShoppingCart;
import com.bookStore.Entity.User;

public interface ShoppingCartDao {
	/**
	 * 根据实际用户返回用户的购物车信息
	 * 
	 * @param user
	 *            操作购物车的用户
	 * @return 返回查询到的购物车内容
	 */
	public List<ShoppingCart> getUserCart(String user);

	/**
	 * 添加到购物车内容
	 * 
	 * @param item
	 *            购物车信息
	 * @return 影响行数，返回-1则代表传入参数为null
	 */
	public int addItem(ShoppingCart item);

	/**
	 * 删除购物车项目
	 * 
	 * @param item
	 *            需要删除的项目
	 * @return 受影响的行数
	 */
	public int delItem(ShoppingCart item);

	/**
	 * 更新购物车内容
	 * ,还要判断购物车是否已经添加过该物品，添加过了则直接加数量amount，否则应添加物品所以信息,这里应该是server做的事情，不应该交由该函数处理
	 * 
	 * @param item
	 *            需要更新的项目
	 * @param amount
	 *            更新的数量
	 * @return 受影响的行数
	 */
	public int updateItemMsg(ShoppingCart item, int amount);
}
