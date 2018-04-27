package com.itcast.DBCPUtil;

import org.apache.commons.beanutils.BeanUtils;
import javax.servlet.http.HttpServletRequest;


public class WebUtil {
    public static <T> T fillbean(HttpServletRequest request, Class<T> clazz) {
        try {
            T bean = clazz.newInstance();
            BeanUtils.populate(bean, request.getParameterMap());//POST方式
            return bean;
        } catch (Exception e) {
            e.printStackTrace();
            throw new RuntimeException("封装失败");
        }
    }
}


