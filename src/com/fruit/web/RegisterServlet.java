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
 * @date : 4:21 pm 14/7/20
 */
public class RegisterServlet extends HttpServlet {

    private UserService userService = new UserServiceImpl();
    @Override
    protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
//        1.获取请求参数
        String username = req.getParameter("username");
        String password = req.getParameter("password");
        String email = req.getParameter("email");
//        2. 检查用户名是否可用
        if (userService.existsUsername(username)){
            System.out.println("username " + username + " is not valid");
            //go back to register page
            req.getRequestDispatcher("/pages/user/regist.html").forward(req, resp);
        } else {
            //save to the database
            userService.register(new User(null, username, password, email));

            //go to register success page
            req.getRequestDispatcher("/pages/user/regist_success.html").forward(req, resp);

        }

    }
}
