package com.http.httpservice;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

/**
 *
 * @author mengqianxiang
 * @date: 2020/12/16 15:25
 */

@RestController()
@RequestMapping("/test")
public class TestController {

    private final static Logger LOGGER = LoggerFactory.getLogger(TestController.class);

    @RequestMapping("getRequest")
    public String getRequest(){

        return "Hello,word!";
    }

}