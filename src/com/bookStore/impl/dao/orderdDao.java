package com.bookStore.impl.dao;

import java.util.List;

import com.bookStore.Entity.orderD;

/**
 * 订单明细数据连接数据库接口
 * @author Administrator
 *
 */
public interface orderdDao {
	
	
	/**
	 *写入数据库
	 * @param ordD
	 * @return
	 */
	public int addOrderD(orderD ordD);
	
	public int  getOrderdRecords();
	
	public List<orderD> getOrderList(int order_id,int pageIndex,int pageSize);
}
