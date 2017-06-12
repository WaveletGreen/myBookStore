package com.bookStore.Entity;

public class ShoppingCart {
	/**
	 * 购买的书
	 */
	private int bookId;
	/**
	 * 谁购买
	 */
	private String userName;
	/**
	 * 购买单价
	 */
	private double price;
	/**
	 * 购买数量
	 */
	private int amount;

	public ShoppingCart() {
	}

	public ShoppingCart(int bookId, String userName, double price, int amount) {
		this.bookId = bookId;
		this.userName = userName;
		this.price = price;
		this.amount = amount;
	}

	public int getBookId() {
		return bookId;
	}

	public void setBookId(int bookId) {
		this.bookId = bookId;
	}

	public String getUserName() {
		return userName;
	}

	public void setUserName(String userName) {
		this.userName = userName;
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

}
