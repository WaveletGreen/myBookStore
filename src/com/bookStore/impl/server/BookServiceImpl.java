package com.bookStore.impl.server;

import java.util.List;

import com.bookStore.Entity.Book;
import com.bookStore.Service.BookService;
import com.bookStore.impl.dao.BookDaoImpl;

public class BookServiceImpl implements BookService {

	public int getTotalPage(String bookName, int pageSize) {

		List<Book> list = new BookDaoImpl().getBookList(bookName);
		return list.size() % pageSize == 0 ? list.size() / pageSize : list
				.size() / pageSize + 1;
	}

	public List<Book> getByPages(String bookName, int index, int PageSize) {
		return new BookDaoImpl().getByPage(bookName, index, PageSize);
	}

	public List<Book> getBooksPages(String bookName, int index, int PageSize) {
		return null;
	}

}
