package web.servlet;


import java.io.IOException;
import java.util.List;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.bookStore.Entity.Book;
import com.bookStore.Service.BookService;
import com.bookStore.impl.server.BookServiceImpl;

public class doBookListServlet extends HttpServlet {

	
	public void doGet(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		request.setCharacterEncoding("UTF-8");
 		String bookName=request.getParameter("bookName");
		System.out.println("----------bookName--------"+bookName);
		String strPageIndex=request.getParameter("pageIndex");
		int pageIndex=1;
		if(strPageIndex!=null){
			pageIndex=Integer.parseInt(strPageIndex);
		}
		int pageSize=5;
		int prePageIndex=0;
		int nextPageIndex=0;
		int totalPages=0;
		
		BookServiceImpl bs=new BookServiceImpl();
		List<Book> bookList=bs.getByPages(bookName, pageSize,pageIndex);
		totalPages=bs.getTotalPage(bookName, pageSize);
		//上一页
		prePageIndex=pageIndex-1;
		if(prePageIndex<1){
			prePageIndex=1;
		}
		//下一页
		nextPageIndex=pageIndex+1;
		if(nextPageIndex>totalPages){
			nextPageIndex=totalPages;
		}
		//将数据保存在作用域中
		request.setAttribute("pageIndex", pageIndex);
		request.setAttribute("prePageIndex", prePageIndex);
		request.setAttribute("nextPageIndex", nextPageIndex);
		request.setAttribute("totalPages", totalPages);
		request.setAttribute("bookName", bookName);
		request.setAttribute("bookList", bookList);
		//页面跳转
		request.getRequestDispatcher("/jsp/firstPage.jsp").forward(request, response);
	}

	
	public void doPost(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		doGet(request, response);
	}

}
