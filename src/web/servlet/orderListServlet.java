package web.servlet;
/**
 * 进入订单详情
 */
import java.io.IOException;
import java.util.ArrayList;
import java.util.LinkedHashMap;
import java.util.LinkedHashSet;
import java.util.List;
import java.util.Map;
import java.util.Set;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import com.bookStore.Entity.Book;
import com.bookStore.Entity.orderD;
import com.bookStore.Service.orderDService;
import com.bookStore.Util.StringUtil;
import com.bookStore.impl.server.orderDServiceImpl;


public class orderListServlet extends HttpServlet {


	public void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		request.setCharacterEncoding("UTF-8");
		String strpageIndex=request.getParameter("pageIndex");
		
		HttpSession session=request.getSession();
		List<orderD> orderDList=null;
		orderDList=(List<orderD>)session.getAttribute("orderDList");
		int order_id=orderDList.get(0).getOrder_id();
//		HttpSession session=request.getSession();
//		Map<Book, Integer> cart=new LinkedHashMap<Book, Integer>();
//		cart=(Map<Book, Integer>)session.getAttribute("shoppingCart");
		
//		Set<Book> buk=new LinkedHashSet<Book>();
//		buk=cart.keySet();
//		List<Integer> bookid=null;
//		for (Book book : buk) {
//			bookid.add(book.getBook_id());
//		}
//		
//		orderD ordD=new orderD();
//		for(Book book:cart.keySet()){
//			ordD.setOdbook_amount(cart.get(book));
//		}
//		
//		for(Book book:cart.keySet()){
//			ordD.setOdbook_name(book.getBook_name());
//			ordD.setOdbook_price(book.getPrice());
//		}
//		
		
		int pageIndex=1;
		
		if(!StringUtil.isNullOrEmpty(strpageIndex)){
			pageIndex=Integer.parseInt(strpageIndex);
		}
		int pageSize=24;
		int totalPage=0;
		int prePageIndex=0;
		int nextPageIndex=0;
		List<orderD> orderDlist;
		
		
		orderDServiceImpl ods=new orderDServiceImpl();
		totalPage=ods.getTotalPage(pageSize);
		orderDlist=ods.getOrderDList(order_id,pageIndex, pageSize);
		
		prePageIndex=pageIndex-1;
		if(prePageIndex<1){
			prePageIndex=1;
		}
		
		nextPageIndex=pageIndex+1;
		if(nextPageIndex>totalPage){
			nextPageIndex=totalPage;
		}
		
		request.setAttribute("pageIndex", pageIndex);
		request.setAttribute("pageSize", pageSize);
		request.setAttribute("totalPage", totalPage);
		request.setAttribute("prePageIndex", prePageIndex);
		request.setAttribute("nextPageIndex", nextPageIndex);
		request.getSession().setAttribute("orderDlist", orderDlist);
		request.getRequestDispatcher("../jsp/orderD.jsp").forward(request, response);
		
	}
		

	public void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		doGet(request, response);
	}

}
