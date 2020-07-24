package com.fruit.test;

import com.fruit.dao.OrderDao;
import com.fruit.dao.impl.OrderDaoImpl;
import com.fruit.pojo.Order;
import org.junit.Test;

import java.math.BigDecimal;
import java.util.Date;

import static org.junit.Assert.*;

/**
 * @author : Xin Tian
 * @date : 7:56 pm 24/7/20
 */
public class OrderDaoTest {

    @Test
    public void saveOrder() {
        OrderDao orderDao = new OrderDaoImpl();
        System.out.println(orderDao.saveOrder(new Order("12345", new Date(), new BigDecimal(100), 1, 1)));
    }
}