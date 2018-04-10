package com.ch.service.core.controller;

import com.ch.service.api.feign.FeignService;
import com.ch.service.api.model.User;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestHeader;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

/**
 * @author cj-ch
 * @date 2018/4/9 上午9:16
 * 测试feign的继承特性
 */
@RestController
public class Feign2Controller implements FeignService {

    @Override
    public String feign4() {
        return "测试feign4的功能";
    }

    @Override
    public String feign5(@RequestHeader("name") String name) {
        return "测试feign5的功能,有请求头name="+name;
    }

    @Override
    public String feign6(@RequestBody User user) {
        return "测试feign6的功能,有请求体user="+user;
    }
}
