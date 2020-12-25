package com.http.httpclient;

import org.apache.http.cookie.Cookie;
import org.apache.http.impl.cookie.BasicClientCookie;
import org.junit.jupiter.api.Test;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.boot.test.context.SpringBootTest;

import java.nio.charset.StandardCharsets;

@SpringBootTest
class HttpclientApplicationTests {

    private static final Logger LOGGER = LoggerFactory.getLogger(HttpclientApplicationTests.class);

    @Test
    void getRequestTest1() {
        String url = "http://127.0.0.1:8080/test/getRequestTest1";
        HttpResult httpResult = HttpUtils.sendGet(url, null, null, null, StandardCharsets.UTF_8.displayName());
        String stringContent = httpResult.getStringContent();
        LOGGER.info("getRequestTest ,result={}",stringContent);
    }

    @Test
    void getRequestTest2() {
        String url = "http://127.0.0.1:8080/test/getRequestTest2";
        BasicClientCookie basicClientCookie = new BasicClientCookie("哈萨克", "盲流");
        basicClientCookie.setDomain("http://127.0.0.1:8080");
        HttpResult httpResult = HttpUtils.sendGet(url, null, null,new Cookie[]{basicClientCookie}, StandardCharsets.UTF_8.displayName());
        String stringContent = httpResult.getStringContent();
        LOGGER.info("getRequestTest ,result={}",stringContent);
    }

}
