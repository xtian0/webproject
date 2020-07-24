package com.fruit.dao.impl;

import com.fruit.dao.BaseDao;
import com.fruit.dao.OrderDao;
import com.fruit.dao.OrderItemDao;
import com.fruit.pojo.Order;
import com.fruit.pojo.OrderItem;

/**
 * @author : Xin Tian
 * @date : 7:48 pm 24/7/20
 */
public class OrderItemDaoImpl extends BaseDao implements OrderItemDao {

    @Override
    public int saveOrderItem(OrderItem orderItem) {
        String sql = "insert into `order_item`(name, count, price, total_price, order_id) values(?,?,?,?,?)";
        return update(sql, orderItem.getName(), orderItem.getCount(), orderItem.getPrice(), orderItem.getTotalPrice(), orderItem.getOrderId());
    }
}
