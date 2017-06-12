package com.bookStore.impl.server;

import java.util.List;

import com.bookStore.Entity.User;
import com.bookStore.Service.UserService;
import com.bookStore.dao.UserDao;
import com.bookStore.impl.dao.UserDaoImple;

/**
 * 用户信息类的具体实现
 * @author Administrator
 *
 */
public class UserServiceImple implements UserService {
	private UserDao us=new UserDaoImple();
	/**
	 * 用户注册
	 */
	public boolean register(User user) {
		return us.add(user)>0;
	}
    /**
     * 用户登录
     */
	public User login(User user) {
		List<User> userList=us.getByName(user.getUserName());
		if(userList!=null&&!userList.isEmpty()){
			User usr=userList.get(0);
			if(user.getPassword().equals(usr.getPassword())){
				return usr;
			}
		}
		return null;
	}

}
