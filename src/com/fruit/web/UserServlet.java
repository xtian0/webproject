package com.fruit.web;

import com.fruit.pojo.User;
import com.fruit.service.UserService;
import com.fruit.service.impl.UserServiceImpl;
import com.fruit.utils.WebUtils;
import com.sun.xml.internal.rngom.parse.host.Base;
import org.apache.commons.beanutils.BeanUtils;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.lang.reflect.InvocationTargetException;
import java.lang.reflect.Method;

/**
 * @author : Xin Tian
 * @date : 2:13 pm 18/7/20
 */
public class UserServlet extends BaseServlet {
    private UserService userService = new UserServiceImpl();

    protected void login(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
//        String username = req.getParameter("username");
//        String password = req.getParameter("password");
        User user = WebUtils.copyParaToBean(req.getParameterMap(), new User());

        if (userService.login(new User(null, user.getUsername(), user.getPassword(), null)) != null){
            //Login success
            req.getRequestDispatcher("/pages/user/login_success.jsp").forward(req, resp);
        } else {

            //Go back to login page
            req.setAttribute("msg","Incorrect user name or password");
            req.setAttribute("username",user.getUsername());
            req.getRequestDispatcher("/pages/user/login.jsp").forward(req, resp);

        }
    }
    protected void register(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
//        1.获取请求参数
//        String username = req.getParameter("username");
//        String password = req.getParameter("password");
//        String email = req.getParameter("email");
        User user = WebUtils.copyParaToBean(req.getParameterMap(), new User());

//        2. 检查用户名是否可用
        if (userService.existsUsername(user.getUsername())){
            System.out.println("username " + user.getUsername() + " is not valid");
            //go back to register page with echo information
            req.setAttribute("msg","Username is not valid!!");
            req.setAttribute("username",user.getUsername());
            req.setAttribute("email",user.getEmail());
            req.getRequestDispatcher("/pages/user/register.jsp").forward(req, resp);
        } else {
            //save to the database
            userService.register(new User(null, user.getUsername(), user.getPassword(), user.getEmail()));

            //go to register success page
            req.getRequestDispatcher("/pages/user/register_success.jsp").forward(req, resp);

        }
    }

}
