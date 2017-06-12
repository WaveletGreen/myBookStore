package web.servlet;

import java.io.IOException;
import java.util.List;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import com.bookStore.Entity.Book;
import com.bookStore.Entity.User;
import com.bookStore.Service.UserService;
import com.bookStore.impl.server.BookServiceImpl;
import com.bookStore.impl.server.UserServiceImple;

public class doLoginServlet extends HttpServlet {

	/**
	 * 
	 */
	private static final long serialVersionUID = -7379071853211000418L;

	public void doGet(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		// 设置字符集编码
		request.setCharacterEncoding("UTF-8");
		// 获取用户请求
		String strUserName = request.getParameter("userName");
		String strPassword = request.getParameter("password");
		// 对用户信息进行处理，创建用户对象，接受参数
		User user = new User();
		user.setUserName(strUserName);
		user.setPassword(strPassword);
		// 创建业务对象进一步处理
		UserService us = new UserServiceImple();
		User result = us.login(user);
		// 根据处理结果，实现页面跳转
		if (result != null) {
			HttpSession session = request.getSession();
			session.setAttribute("loginedUser", result);
			response.sendRedirect("toIndexServlet");
		} else {
			request.setAttribute("msg", "用户名或密码错误,请重试!");
			request.getRequestDispatcher("/jsp/login.jsp").forward(request,
					response);
		}
	}

	public void doPost(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		doGet(request, response);

	}

}
