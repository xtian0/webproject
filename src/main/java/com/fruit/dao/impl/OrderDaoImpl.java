package com.fruit.dao.impl;

import com.fruit.dao.BaseDao;
import com.fruit.dao.OrderDao;
import com.fruit.pojo.Order;

/**
 * @author : Xin Tian
 * @date : 7:51 pm 24/7/20
 */
public class OrderDaoImpl extends BaseDao implements OrderDao {
    @Override
    public int saveOrder(Order order) {
        String sql = "insert into t_order (order_id, create_time, price, status, user_id) values(?,?,?,?,?)";
        return update(sql, order.getOrderId(), order.getCreateTime(), order.getPrice(), order.getStatus(), order.getUserId());
    }
}
