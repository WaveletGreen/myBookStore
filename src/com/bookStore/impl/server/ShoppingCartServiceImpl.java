package com.bookStore.impl.server;

import java.util.ArrayList;
import java.util.List;

import com.bookStore.Entity.Book;
import com.bookStore.Entity.ShoppingCart;
import com.bookStore.Entity.User;
import com.bookStore.Service.ShoppingCartService;
import com.bookStore.impl.dao.BookDaoImpl;
import com.bookStore.impl.dao.ShoppingCartDaoImp;

public class ShoppingCartServiceImpl implements ShoppingCartService {
	ShoppingCartDaoImp dao = new ShoppingCartDaoImp();

	public List<ShoppingCart> getUserCart(User user) {
		// 获取购物车信息
		List<ShoppingCart> list = dao.getUserCart(user.getUserName());
		return list;
	}

	public int addItem(ShoppingCart item) {
		List<ShoppingCart> list = dao.getUserCart(item.getUserName());
		int rows = -1;
		boolean isHave = false;
		int index = 0;
		for (int i = 0; i < list.size(); i++) {
			if (list.get(i).getBookId() == item.getBookId()) {
				isHave = true;
				index = i;
				break;
			}
		}
		System.out.println(isHave);
		if (isHave) {
			System.out.println("有指定内容");
			rows = dao.updateItemMsg(item, list.get(index).getAmount() + item.getAmount());
		} else {
			System.out.println("没有指定内容");
			rows = dao.addItem(item);
		}
		return rows;
	}

	public int delItem(ShoppingCart item) {
		return dao.delItem(item);
	}

	public int updateItemMsg(ShoppingCart item, int amount) {
		return dao.updateItemMsg(item, amount);
	}

	public List<Book> getBookLists(ArrayList<Integer> list) {
		return new BookDaoImpl().getBookLists(list);
	}

}
