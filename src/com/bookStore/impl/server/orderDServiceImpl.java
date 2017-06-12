package com.bookStore.impl.server;

import java.util.List;

import com.bookStore.Entity.orderD;
import com.bookStore.Service.orderDService;
import com.bookStore.dao.orderdDao;
import com.bookStore.impl.dao.orderdDaoImpl;

public class orderDServiceImpl implements orderDService {
	
	orderdDao odd=new orderdDaoImpl();
	

	public List<orderD> getOrderDList(int pageIndex, int pageSize) {
		return odd.getOrderList(pageIndex, pageSize);
	}

	public int getTotalPage(int pageSize) {
		int totalrecords=odd.getOrderdRecords();
		int totalPage=totalrecords%pageSize==0?totalrecords/pageSize:totalrecords/pageSize+1;
		return totalPage;
	}

	public boolean insertOrderD(List<orderD> ordDlist) {
		int count=0;
		for (int i = 0; i < ordDlist.size(); i++) {
			odd.addOrderD(ordDlist.get(i));
			count++;
		}
		return count==ordDlist.size();
	}

	public List<orderD> getOrderDList(int order_id, int pageIndex, int pageSize) {
		return odd.getOrderList(pageIndex, pageSize);
	}

}
