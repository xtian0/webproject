package com.fruit.service.impl;

import com.fruit.dao.UserDao;
import com.fruit.pojo.User;
import com.fruit.service.UserService;
import com.fruit.dao.impl.UserDaoImpl;

/**
 * @author : Xin Tian
 * @date : 3:45 pm 14/7/20
 */
public class UserServiceImpl implements UserService {

    private UserDao userDao = new UserDaoImpl();

    @Override
    public void register(User user) {
        userDao.saveUser(user);
    }

    @Override
    public User login(User user) {

        return userDao.queryUserByUsernameAndPwd(
                user.getUsername(), user.getPassword());
    }

    @Override
    public boolean existsUsername(String username) {
        if (userDao.queryUserByUsername(username) == null){
            return false;
        }
        return true;
    }
}
