package com.fruit.filter;

import com.fruit.utils.JdbcUtils;

import javax.servlet.*;
import java.io.IOException;

/**
 * @author : Xin Tian
 * @date : 12:51 am 25/7/20
 */
public class TransactionFilter implements Filter {
    @Override
    public void init(FilterConfig filterConfig) throws ServletException {

    }

    @Override
    public void doFilter(ServletRequest servletRequest, ServletResponse servletResponse, FilterChain filterChain) throws IOException, ServletException {
        try {
            filterChain.doFilter(servletRequest, servletResponse);
            JdbcUtils.commitAndClose();
        } catch (Exception e) {
            JdbcUtils.rollBackAndClose();
            e.printStackTrace();
            throw new RuntimeException(e);  //把异常抛给tomcat
        }
    }

    @Override
    public void destroy() {

    }
}
