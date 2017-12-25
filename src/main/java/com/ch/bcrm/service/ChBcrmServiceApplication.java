package com.ch.bcrm.service;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.client.discovery.EnableDiscoveryClient;

/**
 * Created by admin on 2017/12/24.
 */
@SpringBootApplication
@EnableDiscoveryClient
public class ChBcrmServiceApplication {
    public static void main(String[] args) {
        SpringApplication.run(ChBcrmServiceApplication.class,args);
    }
}
