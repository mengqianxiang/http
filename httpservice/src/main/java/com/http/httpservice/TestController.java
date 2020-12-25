package com.http.httpservice;

import com.alibaba.fastjson.JSON;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import javax.servlet.ServletOutputStream;
import javax.servlet.http.Cookie;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;

/**
 *
 * @author mengqianxiang
 * @date: 2020/12/16 15:25
 */

@RestController
@RequestMapping("/test")
public class TestController {

    private final static Logger LOGGER = LoggerFactory.getLogger(TestController.class);

    @RequestMapping("getRequestTest1")
    public String getRequestTest1(){
        return "Hello,word!";
    }

    @RequestMapping("getRequestTest2")
    public void getRequestTest2(HttpServletRequest request, HttpServletResponse response) throws IOException {
        String id = request.getSession().getId();

        LOGGER.info("getRequestTest2 sessionId ={}",id);

        Cookie[] cookies = request.getCookies();

        LOGGER.info("getRequestTest2 cookies={}", JSON.toJSONString(cookies));

        response.addCookie(new Cookie("sessionId",id));

        ServletOutputStream outputStream = response.getOutputStream();

        outputStream.write("Hello,word!".getBytes());
    }

}