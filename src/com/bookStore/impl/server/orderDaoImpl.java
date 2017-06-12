package com.bookStore.impl.server;



import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import com.bookStore.Entity.order;
import com.bookStore.Util.DateUtil;
import com.bookStore.dao.baseDao;
import com.bookStore.dao.orderDao;

public class orderDaoImpl implements orderDao {

	public int addOrder(order ord) {
		int rows=0;
		baseDao bd=new baseDao();
		bd.getConnection();
		String sql="insert into order_info(order_id,order_user,order_price,order_getman,order_status,order_time)" +
				   "values(seq_order.nextval,?,?,?,?,sysdate)";
		Object[] params=new Object[]{ord.getOrderUser(),ord.getOrderPrice(),ord.getOrderGetman(),ord.getOrderStatus()};
		rows=bd.executeUpdate(sql, params);
		return rows;
	}

	public int getOrderRecords() {
		int max_orderid=0;
		baseDao bd=new baseDao();
		Connection conn=null;
		PreparedStatement pstmt=null;
		ResultSet rs=null;
		conn=bd.getConnection();
		
		String sql="select max(order_id) from order_info";
		try {
			pstmt=conn.prepareStatement(sql);
			rs=pstmt.executeQuery();
		} catch (SQLException e) {
			e.printStackTrace();
		} finally{
			bd.closeAll(rs);
		}
		return max_orderid;
	}

	public List<order> getAllOrder(int pageIndex, int pageSize) {
		List<order> orderlist=new ArrayList<order>();
		ResultSet rs=null;
		baseDao bd=new baseDao();
		PreparedStatement pstmt=null;
		Connection conn=null;
		
		conn=bd.getConnection();
		StringBuilder sql=new StringBuilder();
		sql.append("select * ")
		   .append("from (select rownum r,o.* ")
		   .append("from (select * ")
		   .append("from order_info ")
		   .append("order by order_time desc) o ")
		   .append("where rownum<=?) ")
		   .append("where r>?");
		try {
			pstmt=conn.prepareStatement(sql.toString());
			int index=1;
			pstmt.setInt(index++, pageSize*pageIndex);
			pstmt.setInt(index++, pageSize*(pageIndex-1));
			rs=pstmt.executeQuery();
			while(rs.next()){
				order ord=new order();
				ord.setOrderId(rs.getInt("order_id"));
				ord.setOrderUser(rs.getString("order_user"));
				ord.setOrderPrice(rs.getInt("order_price"));
				ord.setOrderGetman(rs.getString("order_getman"));
				ord.setOrderTime(DateUtil.parse(rs.getString("order_time")));
				orderlist.add(ord);
			}
		} catch (SQLException e) {
			e.printStackTrace();
		} finally{
			bd.closeAll(rs, pstmt, conn);
		}
		return orderlist;
	}
}
