package com.ch.service.core.controller;


import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.cloud.client.ServiceInstance;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
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
        int i = new Random().nextInt(2000);
        try {
            //测试断路器
            TimeUnit.MILLISECONDS.sleep(i);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
        LOGGER.info("业务处理时间:"+i);
        return "hello word!我是服务提供者！";
    }


    @RequestMapping("/get-user")
    public String getUser(@RequestParam Long id){
        LOGGER.info("根据用户ID{},获取信息",id);
        int i = new Random().nextInt(1000);
        try {
            //测试断路器
            TimeUnit.MILLISECONDS.sleep(i);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
        LOGGER.info("业务处理时间:"+i);
        return "某某用户的信息：{xxx=xxxx,xxx=xxxxx}";
    }
}
