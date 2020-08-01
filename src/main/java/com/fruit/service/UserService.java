package com.fruit.service;

import com.fruit.pojo.User;

/**
 * @author : Xin Tian
 * @date : 3:39 pm 14/7/20
 */
public interface UserService {

    /**
     * Sign up
     * @param user
     */
    public void register(User user);

    /**
     * Sign in
     * @param user
     * @return User: Successful login, null: failed login
     */
    public User login(User user);


    /**
     * Check username validation
     * @param username
     * @return true: already exists, false: valid
     */
    public boolean existsUsername(String username);
}
