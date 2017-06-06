package com.jthink.spring.cloud.demo.eureka.client.test.controller;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.cloud.client.ServiceInstance;
import org.springframework.cloud.client.discovery.DiscoveryClient;
import org.springframework.cloud.client.serviceregistry.Registration;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

/**
 * JThink@JThink
 *
 * @author JThink
 * @version 0.0.1
 * @desc 测试接口
 * @date 2017-06-05 11:36:52
 */
@RestController
public class HelloController {

    private static final Logger LOGGER = LoggerFactory.getLogger(HelloController.class);

    @Autowired
    private Registration registration;
    @Autowired
    private DiscoveryClient client;

    @RequestMapping(value = "hello", method = RequestMethod.GET)
    public String index() {
        String serviceId = this.registration.getServiceId();
        LOGGER.info("get service id from registration: {}", serviceId);

        ServiceInstance instance = this.client.getLocalServiceInstance();
        LOGGER.info("get from the discovery client, host: {}, port: {}, serviceId: {}", instance.getHost(), instance.getPort(), instance.getServiceId());

        return "hello world";
    }
}

