package com.fruit.utils;

import javax.servlet.http.Cookie;

/**
 * @author : Xin Tian
 * @date : 11:57 am 21/7/20
 */
public class CookieUtils {
    public static Cookie findCookie(String name, Cookie[] cookies){
        if (name == null || cookies == null || cookies.length == 0){
            return null;
        }
        for (Cookie cookie: cookies){
            if (name.equals(cookie.getName())){
                return cookie;
            }
        }
        return null;
    }
}
