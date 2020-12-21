package com.http.httpservice.intercept;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.web.servlet.HandlerInterceptor;
import org.springframework.web.servlet.ModelAndView;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

/**
 * 请求拦截器：
 * 1、进入 Handler 方法之前执行，一般用于身份认证授权等
 * 2、进入 Handler 方法之后返回 modelAndView 之前执行，一般用于塞入公共模型数据等。
 * 3、最后处理，一般用于日志收集，统一后续处理等。
 * @see HandlerInterceptor
 *
 * 实现原理：拦截器通常通过动态代理的方式来执行
 * @author mengqianxiang
 * @date: 2020/12/21 17:00
 */
public class RequestInterceptor implements HandlerInterceptor {

    private final static Logger LOGGER = LoggerFactory.getLogger(RequestInterceptor.class);


    @Override
    public boolean preHandle(HttpServletRequest request, HttpServletResponse response, Object handler) throws Exception {
        LOGGER.debug("RequestInterceptor preHandle");
        String scheme = request.getScheme();
        LOGGER.debug("RequestInterceptor preHandle scheme={}",scheme);
        return true;
    }

    @Override
    public void postHandle(HttpServletRequest request, HttpServletResponse response, Object handler, ModelAndView modelAndView) throws Exception {
        LOGGER.debug("RequestInterceptor postHandle");
    }

    @Override
    public void afterCompletion(HttpServletRequest request, HttpServletResponse response, Object handler, Exception ex) throws Exception {
        LOGGER.debug("RequestInterceptor afterCompletion");
    }
}