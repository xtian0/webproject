package com.fruit.web;

import com.fruit.pojo.User;
import com.fruit.service.UserService;
import com.fruit.service.impl.UserServiceImpl;
import com.fruit.utils.WebUtils;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;


import static com.google.code.kaptcha.Constants.KAPTCHA_SESSION_KEY;

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
        User loginUser = userService.login(new User(null, user.getUsername(), user.getPassword(), null));
        if (loginUser != null){
            //Login success
            //save user to session
            req.getSession().setAttribute("user", loginUser);
            if (loginUser.getUsername().equals("admin")){
                req.getRequestDispatcher("/pages/manager/manager.jsp").forward(req, resp);
            } else{
                req.getRequestDispatcher("/pages/user/login_success.jsp").forward(req, resp);
            }

        } else {
            //Go back to login page
            req.setAttribute("msg","Incorrect user name or password");
            req.setAttribute("username",user.getUsername());
            req.getRequestDispatcher("/pages/user/login.jsp").forward(req, resp);

        }
    }

    protected void logout(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        req.getSession().invalidate();
        resp.sendRedirect(req.getContextPath());
    }

    protected void register(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
//        获取session中的验证码
        String token = (String) req.getSession().getAttribute(KAPTCHA_SESSION_KEY);
//        删除session中的验证码
        req.getSession().removeAttribute(KAPTCHA_SESSION_KEY);


//        1.获取请求参数
        String username = req.getParameter("username");
        String password = req.getParameter("password");
        String email = req.getParameter("email");
        String code = req.getParameter("code");
//        User user = WebUtils.copyParaToBean(req.getParameterMap(), new User());
//        检查验证码是否正确
        if (token != null && token.equalsIgnoreCase(code)){
            //        2. 检查用户名是否可用
            if (userService.existsUsername(username)){
                System.out.println("username " + username + " is not valid");
                //go back to register page with echo information
                req.setAttribute("msg","Username is not valid!!");
                req.setAttribute("username",username);
                req.setAttribute("email",email);
                req.getRequestDispatcher("/pages/user/register.jsp").forward(req, resp);
            } else {
                //save to the database
                userService.register(new User(null, username, password, email));

                //go to register success page
                req.getRequestDispatcher("/pages/user/register_success.jsp").forward(req, resp);

            }
        } else {
            // 把回显信息，保存到Request域中
            req.setAttribute("msg", "Incorrect verify code！！");
            req.setAttribute("username", username);
            req.setAttribute("email", email);

            System.out.println("验证码[" + code + "]错误");
            req.getRequestDispatcher("/pages/user/register.jsp").forward(req, resp);
        }


    }

}
