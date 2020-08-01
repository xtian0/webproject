package com.fruit.dao;

import com.fruit.pojo.User;

/**
 * @author : Xin Tian
 * @date : 1:54 pm 14/7/20
 */
public interface UserDao {


    /**
     * 根据用户名查询用户信息
     * @return 用户名存在，返回User，不存在返回null
     */
    public User queryUserByUsername(String username);


    /**
     * 保存用户信息
     * @return
     */
    public int saveUser(User user);


    /**
     * 根据用户名密码
     * @param username
     * @param password
     * @return 用户名/密码错误，返回null，正确返回User
     */
    public User queryUserByUsernameAndPwd(String username, String password);
}
