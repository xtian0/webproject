package com.fruit.web;

import com.fruit.pojo.Cart;
import com.fruit.pojo.User;
import com.fruit.service.OrderService;
import com.fruit.service.impl.OrderServiceImpl;
import com.fruit.utils.JdbcUtils;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;

/**
 * @author : Xin Tian
 * @date : 7:20 pm 24/7/20
 */
public class OrderServlet extends BaseServlet {

    private OrderService orderService = new OrderServiceImpl();
    protected void createOrder(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        Cart cart = (Cart) req.getSession().getAttribute("cart");
        User loginUser = (User) req.getSession().getAttribute("user");
        if (loginUser == null){
            req.getRequestDispatcher("/pages/user/login.jsp").forward(req, resp);
            return;
        }
        int userId = loginUser.getId();

        String orderId = orderService.createOrder(cart, userId);

        req.setAttribute("orderId", orderId);
        req.getSession().setAttribute("orderId", orderId);
        resp.sendRedirect(req.getContextPath()+"/pages/cart/checkout.jsp");
    }
}
