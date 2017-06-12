package bookStore.test;

import com.bookStore.Entity.ShoppingCart;
import com.bookStore.Entity.User;
import com.bookStore.impl.server.ShoppingCartServiceImpl;

public class ShoppingCartServiceImplTest {

	public static void main(String[] args) {
		ShoppingCartServiceImpl impl = new ShoppingCartServiceImpl();
		ShoppingCart item = new ShoppingCart(1, "admin", 15.5, 11);
		User user = new User("admin", "111111", "admin@qq.com");
		int rows = -1;
		rows = impl.addItem(item);
		System.out.println("----------影响行数为：" + rows);
		rows = impl.delItem(item);
		System.out.println("----------影响行数为：" + rows);

	}

}
