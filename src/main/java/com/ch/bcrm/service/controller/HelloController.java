package com.ch.bcrm.service.controller;


import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.cloud.client.ServiceInstance;
import org.springframework.cloud.client.discovery.DiscoveryClient;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

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
        return "hello word!我是服务提供者！";
    }
}
