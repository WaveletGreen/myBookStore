package com.bookStore.Entity;

/**
 * 图书信息类
 * 
 * @author Administrator
 * 
 */
public class Book {
	private int book_id;
	private String book_name;
	private double price;
	private int amount;
	private String pic_path;

	public Book() {
	}

	public Book(int book_id, String book_name, double price, int amount,
			String pic_path) {
		this.book_id = book_id;
		this.book_name = book_name;
		this.price = price;
		this.amount = amount;
		this.pic_path = pic_path;
	}

	public int getBook_id() {
		return book_id;
	}

	public void setBook_id(int book_id) {
		this.book_id = book_id;
	}

	public String getBook_name() {
		return book_name;
	}

	public void setBook_name(String book_name) {
		this.book_name = book_name;
	}

	public double getPrice() {
		return price;
	}

	public void setPrice(double price) {
		this.price = price;
	}

	public int getAmount() {
		return amount;
	}

	public void setAmount(int amount) {
		this.amount = amount;
	}

	public String getPic_path() {
		return pic_path;
	}

	public void setPic_path(String pic_path) {
		this.pic_path = pic_path;
	}

}
