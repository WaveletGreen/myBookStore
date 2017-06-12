package web.servlet;
/**、
 * 获得订单。插入数据库
 */
import java.io.IOException;
import java.io.PrintWriter;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import com.bookStore.Entity.User;
import com.bookStore.Entity.order;
import com.bookStore.Service.orderService;
import com.bookStore.Util.DateUtil;
import com.bookStore.impl.server.orderServiceImpl;

public class getOrderServlet extends HttpServlet {

	public void doGet(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		request.setCharacterEncoding("UTF-8");
		String strGetman = request.getParameter("userName");// 收件人
		String strStatus = request.getParameter("orderStatus");// 订单状态
		String strTotalPrice = request.getParameter("totalCost");// 总价
		HttpSession session = request.getSession();

		User user = (User) session.getAttribute("loginedUser");
		
		orderService os=new orderServiceImpl();
		order ord = new order();
		ord.setOrderPrice(Double.parseDouble(strTotalPrice));
		ord.setOrderGetman(strGetman);
		ord.setOrderUser(user.getUserName());
		ord.setOrderStatus(Integer.parseInt(strStatus));
		
		if(os.insertOrder(ord)){
			session.setAttribute("order",ord);
			request.setAttribute("buyed", "yes");
			request.getRequestDispatcher("/jsp/shoppingSuccess.jsp").forward(request, response);
		}else{
			request.getRequestDispatcher("/jsp/shopping.jsp").forward(request, response);
		}
	}

	public void doPost(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		doGet(request, response);
	}

}
