package web.servlet;


/**
 * 进入订单
 */
import java.io.IOException;
import java.util.List;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import com.bookStore.Entity.order;
import com.bookStore.Service.orderService;
import com.bookStore.Util.StringUtil;
import com.bookStore.impl.server.orderServiceImpl;

public class orderServlet extends HttpServlet {

	public void doGet(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {

		request.setCharacterEncoding("UTF-8");
//		ord.setOrderPrice(Double.parseDouble(strTotalPrice));
//		ord.setOrderStatus(Integer.parseInt(strStatus));
//		ord.setOrderGetman(strGetman);
//		ord.setOrderUser(user.getUserName());
		HttpSession session = request.getSession();
		if (session.getAttribute("loginedUser") == null) {
			response.sendRedirect("../jsp/login.jsp");
			return;
		}
		orderService os = new orderServiceImpl();
		String strpageIndex=request.getParameter("pageIndex");
		int pageIndex=1;
		if(!StringUtil.isNullOrEmpty(strpageIndex)){
			pageIndex=Integer.parseInt(strpageIndex);
		}
		int pageSize=3;
		int totalPage=0;
		int prePageIndex=0;
		int nextPageIndex=0;
		List<order> orderlist;
		
	
		totalPage=os.getTotalPage(pageSize);
		orderlist=os.getOrderDList(pageIndex, pageSize);
		
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
		request.getSession().setAttribute("orderlist", orderlist);
		request.getRequestDispatcher("/jsp/orderList.jsp").forward(request, response);
		// shoppingCart cart=null;
		// cart=(shoppingCart)session.getAttribute("cart");
		// List<shoppingCartItem> sci=null;
		// List<book> buk=null;
		// for (int i = 0; i < cart.getCart().size(); i++) {
		// sci=(List<shoppingCartItem>)cart.getCart().get(i);
		// buk=(List<book>)sci.get(i).getBook();
		// }

	}

	public void doPost(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		doGet(request, response);
	}

}
