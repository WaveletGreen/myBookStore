package com.bookStore.Service;

import java.util.List;

import com.bookStore.Entity.Book;

public interface BookService {
	/**
	 * 根据查询的书名查询显示记录的总页数
	 * 
	 * @param bookName
	 *            查询条件的，书名。如果没有传入书名条件，怎默认查询全部记录

	 * @return 返回的查询记录总页数
	 */
	public int getTotalPage(String bookName,int pageSize);

	/**
	 * 分页查询，根据
	 * 
	 * @param bookName
	 *            查询条件的，书名。如果没有传入书名条件，怎默认查询全部记录
	 * 
	 * @param index
	 *            起始页数
	 * @param PageSize
	 *            每页最大记录数
	 * @return 查询得到的结果集，存储到集合中用于遍历
	 */
	public List<Book> getBooksPages(String bookName, int index, int PageSize);
}
