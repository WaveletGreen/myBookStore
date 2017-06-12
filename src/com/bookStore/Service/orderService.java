package com.bookStore.Service;

import java.util.List;

import com.bookStore.Entity.order;
import com.bookStore.Entity.orderD;

public interface orderService {

	/**
	 * 
	 * @param ord
	 * @return
	 */
	public boolean insertOrder(order ord);

	public int getTotalPage(int pageSize);
	
	public List<order> getOrderDList(int pageIndex,int pageSize);
}
