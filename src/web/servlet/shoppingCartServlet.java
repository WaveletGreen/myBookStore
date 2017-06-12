package web.servlet;

import java.io.IOException;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.LinkedHashMap;
import java.util.List;
import java.util.Map;
import java.util.TreeMap;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import com.bookStore.Entity.Book;
import com.bookStore.Entity.ShoppingCart;
import com.bookStore.Entity.User;
import com.bookStore.impl.dao.BookDaoImpl;
import com.bookStore.impl.server.ShoppingCartServiceImpl;

public class shoppingCartServlet extends HttpServlet {

	private static final long serialVersionUID = 8878352663928786301L;

	/**
	 * ss
	 */
	public void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		HttpSession session = request.getSession();
		if (session.getAttribute("loginedUser") == null) {
			response.sendRedirect("../jsp/login.jsp");
			return;
		}
		System.out.println(((User) session.getAttribute("loginedUser")).getUserName());
		ShoppingCartServiceImpl impl = new ShoppingCartServiceImpl();
		List<ShoppingCart> list = impl.getUserCart((User) session.getAttribute("loginedUser"));
		System.out.println("-----" + session.getAttribute("loginedUser"));
		BookDaoImpl bookDaoImpl = new BookDaoImpl();
		// 存储商品列表
		List<Book> bookLists = new ArrayList<Book>();
		// 存储商品ID
		ArrayList<Integer> bookIdLists = new ArrayList();
		for (int i = 0; i < list.size(); i++) {
			bookIdLists.add(list.get(i).getBookId());
		}
		Map<Book, Integer> cart = new LinkedHashMap<Book, Integer>();
		bookLists = bookDaoImpl.getBookLists(bookIdLists);
		for (int i = 0; i < bookIdLists.size(); i++) {
			cart.put(bookLists.get(i), list.get(i).getAmount());
		}
		// 将结果放在request作用域中
		session.setAttribute("shoppingCart", cart);
		response.sendRedirect("../jsp/shopping.jsp");
	}

	public void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		doGet(request, response);
	}

}
