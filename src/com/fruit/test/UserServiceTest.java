package com.fruit.test;

import com.fruit.pojo.User;
import com.fruit.service.UserService;
import com.fruit.service.impl.UserServiceImpl;
import org.junit.Test;

/**
 * @author : Xin Tian
 * @date : 3:51 pm 14/7/20
 */
public class UserServiceTest {

    UserService userService = new UserServiceImpl();
    User userTest = new User(null, "Xiaofeng", "123456", "Xiaofeng@gmail.com");
    @Test
    public void register() {
        userService.register(userTest);
    }

    @Test
    public void login() {
        System.out.println(userService.login(userTest));
    }

    @Test
    public void existsUsername() {
        System.out.println(userService.existsUsername("admin"));
    }
}