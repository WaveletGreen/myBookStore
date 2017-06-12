package com.bookStore.impl.server;

import java.util.List;

import com.bookStore.Entity.Book;
import com.bookStore.Entity.OrderItem;
import com.bookStore.Entity.User;
import com.bookStore.Service.IndentServer;
import com.bookStore.dao.OrderItemDao;
import com.bookStore.impl.dao.OrderItemDaoImpl;

public class IndentServerImpl implements IndentServer {

	private OrderItemDao dao = new OrderItemDaoImpl();

	public List<OrderItem> viewIndent(User user) {
		return dao.getUserIndent(user);
	}

	public int delIndentItem(User user, OrderItem item) {
		return dao.delItem(item, user);
	}

	public int addToIndent(User user, Book item) {
		return 0;
	}

}
