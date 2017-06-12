package bookStore.test;

import java.util.List;

import com.bookStore.Entity.ShoppingCart;
import com.bookStore.Entity.User;
import com.bookStore.impl.dao.ShoppingCartDaoImp;

public class ShoppingCartDaoImplTest {

	public static void main(String[] args) {
		ShoppingCartDaoImp imp = new ShoppingCartDaoImp();
		ShoppingCart item = new ShoppingCart(1, "admin", 15.5, 10);
		User user = new User("admin", "111111", "admin@qq.com");
		List<ShoppingCart> list = imp.getUserCart(user.getUserName());
		for (ShoppingCart shoppingCart : list) {
			System.out.println("---UserName---" + shoppingCart.getUserName());
			System.out.println("---BookId---" + shoppingCart.getBookId());
			System.out.println("---Amount---" + shoppingCart.getAmount());
			System.out.println("---Price---" + shoppingCart.getPrice());
			System.out.println();
		}
		int rows = imp.addItem(item);
		System.out.println("-------受影响行数-------::::" + rows);
		// rows = imp.delItem(item);
		System.out.println("-------受影响行数-------::::" + rows);
		rows = imp.updateItemMsg(item, 11);
		System.out.println("-------受影响行数-------::::" + rows);

	}

}
