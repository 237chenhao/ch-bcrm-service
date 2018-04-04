package com.ch.bcrm.service.controller;


import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.cloud.client.ServiceInstance;
import org.springframework.cloud.client.discovery.DiscoveryClient;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.Random;
import java.util.concurrent.TimeUnit;

/**
 * Created by admin on 2017/12/24.
 */
@RestController
public class HelloController {
    private static final Logger LOGGER = LoggerFactory.getLogger(HelloController.class);
    @Autowired
    private ServiceInstance serviceInstance;

    @RequestMapping("/hello")
    public String index(){
        LOGGER.info("/hello,host:{},service_id:{}",serviceInstance.getHost(),serviceInstance.getServiceId());
        int i = new Random().nextInt(3000);
        try {
            //测试断路器
            TimeUnit.MILLISECONDS.sleep(i);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
        LOGGER.info("业务处理时间:"+i);
        return "hello word!我是服务提供者！";
    }
}
