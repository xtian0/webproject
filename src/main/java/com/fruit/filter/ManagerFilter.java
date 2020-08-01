package com.fruit.filter;

import com.fruit.pojo.User;

import javax.servlet.*;
import javax.servlet.http.HttpServletRequest;
import java.io.IOException;

/**
 * @author : Xin Tian
 * @date : 11:13 pm 24/7/20
 */
public class ManagerFilter implements Filter {
    @Override
    public void init(FilterConfig filterConfig) throws ServletException {

    }

    @Override
    public void doFilter(ServletRequest servletRequest, ServletResponse servletResponse, FilterChain filterChain) throws IOException, ServletException {
        HttpServletRequest httpServletRequest = (HttpServletRequest) servletRequest;
        User user = (User) httpServletRequest.getSession().getAttribute("user");
        if (user.getUsername().equals("admin")){
            filterChain.doFilter(servletRequest, servletResponse);
        } else {
            httpServletRequest.getRequestDispatcher("/pages/user/login.jsp").forward(servletRequest, servletResponse);
        }

    }

    @Override
    public void destroy() {

    }
}
