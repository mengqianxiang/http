package com.http.httpservice.intercept;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import javax.servlet.*;
import java.io.IOException;

/**
 * 请求过滤器：
 *
 * @author mengqianxiang
 * @date: 2020/12/21 17:28
 */
public class RequestFilter implements Filter {

    private final static Logger LOGGER = LoggerFactory.getLogger(RequestFilter.class);

    @Override
    public void doFilter(ServletRequest servletRequest, ServletResponse servletResponse, FilterChain filterChain) throws IOException, ServletException {
        LOGGER.debug("RequestFilter doFilter");
        filterChain.doFilter(servletRequest,servletResponse);
    }

    @Override
    public void init(FilterConfig filterConfig) throws ServletException {
        LOGGER.debug("RequestFilter init");
    }

    @Override
    public void destroy() {
        LOGGER.debug("RequestFilter destroy");
    }
}