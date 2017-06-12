package com.bookStore.dao;

import java.util.List;

import com.bookStore.Entity.Book;

/**
 * 访问图书数据库接口
 * 
 * @author Administrator
 * 
 */
public interface BookDao {
	/**
	 * 查询的书名，支持模糊查询
	 * 
	 * @param bookName
	 * @return 查询到得结果集
	 */
	public List<Book> getBookList(String bookName);

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
