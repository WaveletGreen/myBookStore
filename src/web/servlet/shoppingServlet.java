package web.servlet;

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
import com.bookStore.Entity.ShoppingCart;
import com.bookStore.Entity.User;
import com.bookStore.Service.BookService;
import com.bookStore.impl.dao.BookDaoImpl;
import com.bookStore.impl.dao.ShoppingCartDaoImp;
import com.bookStore.impl.server.BookServiceImpl;
import com.bookStore.impl.server.ShoppingCartServiceImpl;

public class shoppingServlet extends HttpServlet {

	public void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {

		request.setCharacterEncoding("UTF-8");
		// 获取Session
		HttpSession session = request.getSession();
		User user = (User) session.getAttribute("loginedUser");
		if (user == null) {
			response.sendRedirect("/bookStore/jsp/login.jsp");
			return;
		}
		// 获取一组选中商品的ID
		String[] strBookIds = request.getParameterValues("book_id");
		// 获取设置增量
		String[] strAmount = request.getParameterValues("amount");

		ShoppingCartServiceImpl server = new ShoppingCartServiceImpl();
		// 缓存购物车列表
		List<ShoppingCart> list = new ArrayList<ShoppingCart>();
		// 根据ID获取Book集合
		List<Book> bookList = new ArrayList<Book>();
		// 获取装载的bookID
		ArrayList<Integer> idList = new ArrayList<Integer>();

		for (int i = 0; i < strBookIds.length; i++) {
			idList.add(Integer.parseInt(strBookIds[i]));
		}
		// 根据id获取Book的整体信息
		bookList = server.getBookLists(idList);
		for (int i = 0; i < bookList.size(); i++) {
			list.add(new ShoppingCart(bookList.get(i).getBook_id(), user.getUserName(), bookList.get(i).getPrice(),
					Integer.parseInt(strAmount[0])));
			server.addItem(list.get(i));
		}
		request.getRequestDispatcher("shoppingCartServlet").forward(request, response);
	}

	public void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		doGet(request, response);
	}

}
