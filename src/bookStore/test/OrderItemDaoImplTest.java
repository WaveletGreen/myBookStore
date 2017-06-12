package bookStore.test;

import java.util.ArrayList;

import com.bookStore.Entity.Book;
import com.bookStore.Entity.OrderItem;
import com.bookStore.Entity.User;
import com.bookStore.Util.DateUtil;
import com.bookStore.Util.bookStoreUtil;
import com.bookStore.impl.dao.OrderItemDaoImpl;

public class OrderItemDaoImplTest {

	public static void main(String[] args) {
		OrderItemDaoImpl impl = new OrderItemDaoImpl();
		User user = new User("admin", "111111", "admin@qq.com");
		Book book = new Book(1, "泰戈尔诗集", 18.00, 999, "images/book/book_01.gif");
		OrderItem item = new OrderItem(10019, 9, "a7",
				bookStoreUtil.parse("2017-5-16 0:02:00"), 1, user.getUserName());
		ArrayList<OrderItem> lists = (ArrayList<OrderItem>) impl
				.getUserIndent(user);

		for (OrderItem orderItem : lists) {

			System.out.println("------>>" + orderItem.getGoods_id());
			System.out.println("------>>" + orderItem.getConsignee());
			System.out.println("------>>" + orderItem.getIndent_No());
			System.out.println("------>>" + orderItem.getIndent_status());
			System.out.println("------>>" + orderItem.getUser_Name());
			System.out.println("------>>"
					+ DateUtil.dateFormat(orderItem.getOrder_time()));
			System.out.println();
		}
		impl.delItem(item, user);
		impl.add(book, user);
	}

}
