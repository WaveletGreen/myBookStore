package com.bookStore.Entity;

import java.util.Date;

/**
 * 订单实体类，用于传输订单信息的类
 * 
 * @author Administrator
 * 
 */
public class OrderItem {
	private int indent_No;
	private int goods_id;
	private String consignee;
	private Date order_time;
	private int indent_status;
	private String user_Name;

	public OrderItem() {
	}

	public OrderItem(int indent_No, int goods_id, String consignee,
			Date order_time, int indent_status, String user_Name) {
		super();
		this.indent_No = indent_No;
		this.goods_id = goods_id;
		this.consignee = consignee;
		this.order_time = order_time;
		this.indent_status = indent_status;
		this.user_Name = user_Name;
	}

	public int getIndent_No() {
		return indent_No;
	}

	public void setIndent_No(int indent_No) {
		this.indent_No = indent_No;
	}

	public int getGoods_id() {
		return goods_id;
	}

	public void setGoods_id(int goods_id) {
		this.goods_id = goods_id;
	}

	public String getConsignee() {
		return consignee;
	}

	public void setConsignee(String consignee) {
		this.consignee = consignee;
	}

	public Date getOrder_time() {
		return order_time;
	}

	public void setOrder_time(Date order_time) {
		this.order_time = order_time;
	}

	public int getIndent_status() {
		return indent_status;
	}

	public void setIndent_status(int indent_status) {
		this.indent_status = indent_status;
	}

	public String getUser_Name() {
		return user_Name;
	}

	public void setUser_Name(String user_Name) {
		this.user_Name = user_Name;
	}

}
