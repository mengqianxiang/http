package com.http.httpclient;

import org.junit.jupiter.api.Test;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.boot.test.context.SpringBootTest;

import java.nio.charset.StandardCharsets;

@SpringBootTest
class HttpclientApplicationTests {

    private static final Logger LOGGER = LoggerFactory.getLogger(HttpclientApplicationTests.class);

    @Test
    void getRequestTest() {
        String url = "http://127.0.0.1:8080/test/getRequest";
        HttpResult httpResult = HttpUtils.sendGet(url, null, null, null, StandardCharsets.UTF_8.displayName());
        String stringContent = httpResult.getStringContent();
        LOGGER.info("getRequestTest ,result={}",stringContent);
    }

}
