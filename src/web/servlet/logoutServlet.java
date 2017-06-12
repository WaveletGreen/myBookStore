package web.servlet;

import java.io.IOException;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;


public class logoutServlet extends HttpServlet {

	
	public void doGet(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		HttpSession session = request.getSession();
		 //移除session中保存的用户信息
		if (session.getAttribute("registerUser")!=null) {
			session.removeAttribute("registerUser");
		}
		if (session.getAttribute("loginedUser")!=null) {
			session.removeAttribute("loginedUser");			
		}
		//销毁会话，强制使会话失效
		session.invalidate();
		response.sendRedirect("/bookStore/jsp/firstPage.jsp");
	}

	
	public void doPost(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
         doGet(request, response);
	}

	

}