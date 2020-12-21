package com.http.httpservice.intercept;

import org.springframework.boot.web.servlet.FilterRegistrationBean;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.web.servlet.config.annotation.InterceptorRegistry;
import org.springframework.web.servlet.config.annotation.WebMvcConfigurer;

import javax.servlet.Filter;

/**
 * 自定义web mvc 配置
 * @see WebMvcConfigurer
 * @author mengqianxiang
 * @date: 2020/12/21 17:20
 */

@Configuration
public class WebMvcConfiguration implements WebMvcConfigurer {

    /**
     * 注册拦截器，拦截请求
     * @param registry
     */

    @Override
    public void addInterceptors(InterceptorRegistry registry) {
        registry.addInterceptor(new RequestInterceptor())
                .addPathPatterns("/**");
    }

    /**
     * 注册请求过滤器
     * @return
     */
    @Bean
    public FilterRegistrationBean myFilter() {
        FilterRegistrationBean<Filter> filterFilterRegistrationBean = new FilterRegistrationBean<>();
        filterFilterRegistrationBean.setFilter(new RequestFilter());
        filterFilterRegistrationBean.addUrlPatterns("/*");
        filterFilterRegistrationBean.setName(RequestFilter.class.getName());
        filterFilterRegistrationBean.setOrder(1);
        return filterFilterRegistrationBean;
    }

    /**
     * 注册自定义servlet
     * @return
     */
   /* @Bean
    public ServletRegistrationBean myServlet() {
        return new ServletRegistrationBean<>(new MyServlet());
    }*/

    /**
     * 注册自定义监听器
     * @return
     */
    /*@Bean
    public ServletListenerRegistrationBean myListener() {
        return new ServletListenerRegistrationBean(new MyListener());
    }*/
}