package com.fruit.test;

import com.fruit.pojo.Cart;
import com.fruit.pojo.CartItem;
import com.fruit.service.OrderService;
import com.fruit.service.impl.OrderServiceImpl;
import org.junit.Test;

import java.math.BigDecimal;

import static org.junit.Assert.*;

/**
 * @author : Xin Tian
 * @date : 8:23 pm 24/7/20
 */
public class OrderServiceTest {

    @Test
    public void createOrder() {
        Cart cart = new Cart();
        cart.addItem(new CartItem(1, "Kiwi", 1, new BigDecimal(10), new BigDecimal(10)));
        cart.addItem(new CartItem(1, "Kiwi", 1, new BigDecimal(10), new BigDecimal(10)));
        cart.addItem(new CartItem(2, "Passion", 1, new BigDecimal(10), new BigDecimal(10)));
        OrderService orderService = new OrderServiceImpl();
        orderService.createOrder(cart, 1);
    }
}