package web.servlet;
/**
 * 获得订单心详情，插入数据库
 */
import java.io.IOException;


import java.util.ArrayList;
import java.util.LinkedHashMap;
import java.util.List;
import java.util.Map;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import com.bookStore.Entity.Book;
import com.bookStore.Entity.orderD;
import com.bookStore.Service.orderDService;
import com.bookStore.impl.server.orderDServiceImpl;

public class getOrderListServlet extends HttpServlet {

	public void doGet(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		request.setCharacterEncoding("UTF-8");
		String strOrderId=request.getParameter("orderid");
		HttpSession session=request.getSession();
		Map<Book, Integer> cart=new LinkedHashMap<Book, Integer>();
		cart=(Map<Book, Integer>)session.getAttribute("shoppingCart");
		
		List<orderD> ordDlist=new ArrayList<orderD>();
		for(Book book:cart.keySet()){
			orderD ordD=new orderD();
			ordD.setOrder_id(Integer.parseInt(strOrderId));
			ordD.setOdbook_amount(cart.get(book));
			ordD.setOdbook_name(book.getBook_name());
			ordD.setOdbook_price(book.getPrice());
			ordDlist.add(ordD);
		}
		
		orderDServiceImpl ods=new orderDServiceImpl();
		if(ods.insertOrderD(ordDlist)){
			session.setAttribute("orderDList", ordDlist);
			response.sendRedirect("../servlet/orderListServlet");
		}else{
			request.getRequestDispatcher("/jsp/orderlist.jsp");
		}
		
	}

	public void doPost(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		doGet(request, response);
	}

}
