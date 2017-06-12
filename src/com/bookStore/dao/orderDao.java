package com.bookStore.dao;


import java.util.List;

import com.bookStore.Entity.order;


/**
 * 订单数据链接数据库访问接口
 * @author Administrator
 *
 */
public interface orderDao {
	
	/**
	 * 添加生成的订单信息
	 * @param ord
	 * @return
	 */
	public int addOrder(order ord);
	
	//从session中获得 用户数据User 以及 购买书籍的数据book

	//再获得 收件人 下单时间  订单状态 参数
	
	//封装成一个order类
	
	//写入数据库
	
	public int getOrderRecords();
	
	public List<order> getAllOrder(int pageIndex,int pageSize);
}
