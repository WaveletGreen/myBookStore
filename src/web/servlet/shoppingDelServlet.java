package web.servlet;

import java.io.IOException;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import com.bookStore.Entity.ShoppingCart;
import com.bookStore.Entity.User;
import com.bookStore.impl.server.ShoppingCartServiceImpl;

public class shoppingDelServlet extends HttpServlet {

	public void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		ShoppingCartServiceImpl imp = new ShoppingCartServiceImpl();
		int book_id = Integer.parseInt(request.getParameter("book_id"));
		HttpSession session = request.getSession();
		ShoppingCart item = new ShoppingCart(book_id, ((User) session.getAttribute("loginedUser")).getUserName(), 0, 0);
		imp.delItem(item);
		request.getRequestDispatcher("shoppingCartServlet").forward(request, response);

	}

	public void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		doGet(request, response);
	}

}
