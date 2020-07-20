package com.fruit.utils;

import com.fruit.pojo.User;
import org.apache.commons.beanutils.BeanUtils;

import javax.servlet.http.HttpServletRequest;
import java.util.Map;

/**
 * @author : Xin Tian
 * @date : 4:29 pm 18/7/20
 */
public class WebUtils {

    public static <T> T copyParaToBean(Map value, T bean){
        try {
//            把所有请求参数注入user对象中
            BeanUtils.populate(bean, value);

        } catch (Exception e) {
            e.printStackTrace();
        }
        return bean;
    }

    public static int parseInt(String strInt, int defaultValue){
        try {
            return Integer.parseInt(strInt);
        } catch (Exception e) {
//            e.printStackTrace();
        }
        return defaultValue;
    }
}
