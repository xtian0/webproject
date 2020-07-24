package com.fruit.service.impl;

import com.fruit.dao.ItemDao;
import com.fruit.dao.OrderDao;
import com.fruit.dao.OrderItemDao;
import com.fruit.dao.impl.ItemDaoImpl;
import com.fruit.dao.impl.OrderDaoImpl;
import com.fruit.dao.impl.OrderItemDaoImpl;
import com.fruit.pojo.*;
import com.fruit.service.OrderService;

import java.util.Date;
import java.util.Map;

/**
 * @author : Xin Tian
 * @date : 8:13 pm 24/7/20
 */
public class OrderServiceImpl implements OrderService {
    private OrderDao orderDao = new OrderDaoImpl();
    private OrderItemDao orderItemDao = new OrderItemDaoImpl();
    private ItemDao itemDao = new ItemDaoImpl();
    @Override
    public String createOrder(Cart cart, Integer userId) {
        String orderId = System.currentTimeMillis()+""+userId;
        Order order = new Order(orderId, new Date(), cart.getTotalPrice(), 0, userId);
        orderDao.saveOrder(order);
        for (Map.Entry<Integer, CartItem> entry : cart.getItems().entrySet()){
            CartItem cartItem = entry.getValue();
            OrderItem orderItem = new OrderItem(null, cartItem.getName(), cartItem.getCount(), cartItem.getPrice(), cartItem.getTotalPrice(), orderId);
            orderItemDao.saveOrderItem(orderItem);

            //Update sales and count
            Item item = itemDao.queryItemById(cartItem.getId());
            item.setSales(item.getSales() + cartItem.getCount());
            item.setStock(item.getStock() - cartItem.getCount());
            itemDao.updateItem(item);
        }
        cart.clean();
        return orderId;
    }
}
