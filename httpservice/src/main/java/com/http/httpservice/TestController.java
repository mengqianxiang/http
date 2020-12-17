package com.http.httpservice;

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

    @RequestMapping("getRequest")
    public String getRequest(){

        return "Hello,word!";
    }
}