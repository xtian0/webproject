package com.fruit.service;

import com.fruit.pojo.Cart;

/**
 * @author : Xin Tian
 * @date : 8:10 pm 24/7/20
 */
public interface OrderService {
    public String createOrder(Cart cart, Integer userId);
}
