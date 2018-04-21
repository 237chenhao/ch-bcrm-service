package com.ch.service.core.controller;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.cloud.client.ServiceInstance;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import javax.servlet.http.HttpServletRequest;

/**
 * @author cj-ch
 * @date 2018/4/20 下午2:44
 */
@RestController
@RequestMapping("/trace-test")
public class TaceController {
    final Logger logger = LoggerFactory.getLogger(getClass());
    @Autowired
    private ServiceInstance serviceInstance;
    @RequestMapping("")
    public String trace(@RequestParam String params,
                        HttpServletRequest request){
        logger.info("===== <call trace2:{},TraceId={},SpanId={}> =====",
                params,
                request.getHeader("X-B3-TraceId"),
                request.getHeader("X-B3-SpanId"));
        return "call trace:getServiceId="+serviceInstance.getServiceId()
                +",getMetadata="+serviceInstance.getMetadata();
    }
}
