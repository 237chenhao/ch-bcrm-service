package com.ch.bcrm.service.controller;

import com.ch.bcrm.service.model.User;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestHeader;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

/**
 * @author cj-ch
 * @date 2018/4/9 上午9:16
 */
@RestController
@RequestMapping("")
public class FeignController {

    @RequestMapping("/feign1")
    public String feign(){
        return "测试feign的功能";
    }

    @RequestMapping("/feign2")
    public String feign2(@RequestHeader("name") String name){
        return "测试feign的功能,有请求头name="+name;
    }

    @RequestMapping("/feign3")
    public String feign3(@RequestBody User user){
        return "测试feign的功能,有请求体user="+user;
    }
}
