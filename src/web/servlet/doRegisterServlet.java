package web.servlet;

import java.io.IOException;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import com.bookStore.Entity.User;
import com.bookStore.Service.UserService;
import com.bookStore.impl.server.UserServiceImple;

public class doRegisterServlet extends HttpServlet {

	/**
	 * 
	 */
	private static final long serialVersionUID = -5428200119624031625L;

	public void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// 设置字符集编码
		request.setCharacterEncoding("UTF-8");
		// 获取用户请求
		String strUserName = request.getParameter("userName");
		String strPassword = request.getParameter("password");
		String strEmail = request.getParameter("email");
		// 对用户信息进行处理，创建用户对象，接受参数
		User user = new User();
		user.setUserName(strUserName);
		user.setPassword(strPassword);
		user.setEmail(strEmail);
		// 创建业务对象进一步处理
		UserService us = new UserServiceImple();
		boolean result = us.register(user);
		// 根据处理结果，实现页面跳转
		if (result) {
			HttpSession session = request.getSession();
			session.setAttribute("loginedUser", user);
			request.setAttribute("registSucz", result);
			request.getRequestDispatcher("/jsp/registerSuccess.jsp").forward(request, response);
		} else {
			request.setAttribute("msg", "注册失败，用户已存在，请重试");
			request.getRequestDispatcher("/jsp/register.jsp").forward(request, response);
		}
	}

	public void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		doGet(request, response);
	}

}
