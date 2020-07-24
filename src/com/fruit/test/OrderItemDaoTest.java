package com.fruit.test;

import com.fruit.dao.OrderItemDao;
import com.fruit.dao.impl.OrderItemDaoImpl;
import com.fruit.pojo.OrderItem;
import org.junit.Test;

import java.math.BigDecimal;

import static org.junit.Assert.*;

/**
 * @author : Xin Tian
 * @date : 7:55 pm 24/7/20
 */
public class OrderItemDaoTest {

    @Test
    public void saveOrderItem() {
        OrderItemDao orderItemDao = new OrderItemDaoImpl();
        orderItemDao.saveOrderItem(new OrderItem(null, "Apple", 1, new BigDecimal(10), new BigDecimal(10), "12345"));
    }

}