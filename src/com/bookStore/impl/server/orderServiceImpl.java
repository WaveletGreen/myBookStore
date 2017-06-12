package com.bookStore.impl.server;

import java.util.List;

import com.bookStore.Entity.order;
import com.bookStore.Entity.orderD;
import com.bookStore.Service.orderService;
import com.bookStore.dao.orderDao;
import com.bookStore.impl.dao.orderDaoImpl;

public class orderServiceImpl implements orderService {

	orderDao od = new orderDaoImpl();

	public boolean insertOrder(order ord) {
		return od.addOrder(ord) > 0;
	}

	public int getTotalPage(int pageSize) {
		int totalrecords = od.getOrderRecords();
		int totalPage = totalrecords % pageSize == 0 ? totalrecords / pageSize : totalrecords / pageSize + 1;
		return totalPage;
	}

	public List<order> getOrderDList(int pageIndex, int pageSize) {
		return od.getAllOrder(pageIndex, pageSize);
	}

}
