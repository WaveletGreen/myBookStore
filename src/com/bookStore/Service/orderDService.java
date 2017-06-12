package com.bookStore.Service;

import java.util.List;

import com.bookStore.Entity.orderD;

public interface orderDService {

	/**
	 * 插入数据
	 * @param ordD
	 * @return
	 */
	public boolean insertOrderD(List<orderD> ordDlist);
	
	public int getTotalPage(int pageSize);
	
	public List<orderD> getOrderDList(int order_id,int pageIndex,int pageSize);
} 
