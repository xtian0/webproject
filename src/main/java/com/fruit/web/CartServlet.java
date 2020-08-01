package com.fruit.web;

import com.fruit.pojo.Cart;
import com.fruit.pojo.CartItem;
import com.fruit.pojo.Item;
import com.fruit.service.ItemService;
import com.fruit.service.impl.ItemServiceImpl;
import com.fruit.utils.WebUtils;
import com.google.gson.Gson;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.util.HashMap;
import java.util.Map;

/**
 * @author : Xin Tian
 * @date : 1:39 pm 22/7/20
 */
public class CartServlet extends BaseServlet {

    private ItemService itemService = new ItemServiceImpl();

    protected void addItem(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
//        System.out.println("add to cart!!!");
        Integer id = WebUtils.parseInt(req.getParameter("id"),0);
        Item item = itemService.queryItemById(id);
        CartItem cartItem = new CartItem(item.getId(), item.getName(), 1, item.getPrice(), item.getPrice());
        Cart cart = (Cart) req.getSession().getAttribute("cart");
        if (cart == null) {
            cart = new Cart();
            req.getSession().setAttribute("cart", cart);
        }
        cart.addItem(cartItem);

        //重定向回原来商品的地址页面
        resp.sendRedirect(req.getHeader("Referer"));
    }

    protected void ajaxAddItem(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
//        System.out.println("add to cart!!!");
        Integer id = WebUtils.parseInt(req.getParameter("id"),0);
        Item item = itemService.queryItemById(id);
        CartItem cartItem = new CartItem(item.getId(), item.getName(), 1, item.getPrice(), item.getPrice());
        Cart cart = (Cart) req.getSession().getAttribute("cart");
        if (cart == null) {
            cart = new Cart();
            req.getSession().setAttribute("cart", cart);
        }
        cart.addItem(cartItem);

        Map<String, Object> resultMap = new HashMap<String, Object>();
        resultMap.put("totalCount", cart.getTotalCount());
        Gson gson = new Gson();
        String json = gson.toJson(resultMap);
        resp.getWriter().write(json);
    }



    protected void deleteItem(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        Integer id = WebUtils.parseInt(req.getParameter("id"),0);
        Cart cart = (Cart) req.getSession().getAttribute("cart");
        if (cart != null) {
            cart.deleteItem(id);
            resp.sendRedirect(req.getHeader("Referer"));
        }
    }

    protected void clean(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        Cart cart = (Cart) req.getSession().getAttribute("cart");
        if (cart != null) {
            cart.clean();
            resp.sendRedirect(req.getHeader("Referer"));
        }
    }

    protected void updateCount(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        Cart cart = (Cart) req.getSession().getAttribute("cart");
        if (cart != null) {
            Integer count = WebUtils.parseInt(req.getParameter("count"),1);
            Integer id = WebUtils.parseInt(req.getParameter("id"),0);
            cart.updateCount(id, count);
            resp.sendRedirect(req.getHeader("Referer"));
        }
    }
}
