package com.bookStore.Entity;


import java.util.Date;

public class order {
	private int orderId;
	private String orderUser;
	private double orderPrice;
	private String orderGetman;
	private int orderStatus;
	private Date orderTime;
	
	public order() {
		super();
	}
	
	public int getOrderId() {
		return orderId;
	}

	public void setOrderId(int orderId) {
		this.orderId = orderId;
	}

	public String getOrderUser() {
		return orderUser;
	}

	public void setOrderUser(String orderUser) {
		this.orderUser = orderUser;
	}

	public double getOrderPrice() {
		return orderPrice;
	}

	public void setOrderPrice(double orderPrice) {
		this.orderPrice = orderPrice;
	}

	public String getOrderGetman() {
		return orderGetman;
	}

	public void setOrderGetman(String orderGetman) {
		this.orderGetman = orderGetman;
	}

	public int getOrderStatus() {
		return orderStatus;
	}

	public void setOrderStatus(int orderStatus) {
		this.orderStatus = orderStatus;
	}

	public Date getOrderTime() {
		return orderTime;
	}

	public void setOrderTime(Date orderTime) {
		this.orderTime = orderTime;
	}

	public order(int orderId, String orderUser, double orderPrice,
			String orderGetman, int orderStatus, Date orderTime) {
		super();
		this.orderId = orderId;
		this.orderUser = orderUser;
		this.orderPrice = orderPrice;
		this.orderGetman = orderGetman;
		this.orderStatus = orderStatus;
		this.orderTime = orderTime;
	}
	
	
}
