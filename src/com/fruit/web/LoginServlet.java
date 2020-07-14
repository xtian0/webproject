package com.fruit.web;

import com.fruit.pojo.User;
import com.fruit.service.UserService;
import com.fruit.service.impl.UserServiceImpl;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;

/**
 * @author : Xin Tian
 * @date : 6:18 pm 14/7/20
 */
public class LoginServlet extends HttpServlet {

    private UserService userService = new UserServiceImpl();
    @Override
    protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        String username = req.getParameter("username");
        String password = req.getParameter("password");
        if (userService.login(new User(null, username, password, null)) != null){
            req.getRequestDispatcher("/pages/user/login_success.html").forward(req, resp);
        } else {
            req.getRequestDispatcher("/pages/user/login.html").forward(req, resp);
        }

    }
}
