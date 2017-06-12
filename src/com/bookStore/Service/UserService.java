package com.bookStore.Service;

import com.bookStore.Entity.User;

public interface UserService {
/**
 * 注册
 * @param user
 * @return
 */
 public boolean register(User user);
 /**
  * 登录
  * @param user
  * @return
  */
 public User login(User user);
}
