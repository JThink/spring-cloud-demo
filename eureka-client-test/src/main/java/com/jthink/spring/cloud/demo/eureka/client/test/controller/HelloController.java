package com.jthink.spring.cloud.demo.eureka.client.test.controller;

import com.jthink.spring.cloud.demo.feign.client.dto.UserDto;
import com.jthink.spring.cloud.demo.feign.client.message.MatchMessage;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.cloud.client.ServiceInstance;
import org.springframework.cloud.client.discovery.DiscoveryClient;
import org.springframework.cloud.client.serviceregistry.Registration;
import org.springframework.web.bind.annotation.*;

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
    public String hello() {
        String serviceId = this.registration.getServiceId();
        LOGGER.info("get service id from registration: {}", serviceId);

        ServiceInstance instance = this.client.getLocalServiceInstance();
        LOGGER.info("get from the discovery client, host: {}, port: {}, serviceId: {}", instance.getHost(), instance.getPort(), instance.getServiceId());

        return "hello world";
    }

    @RequestMapping(value = "hello1", method = RequestMethod.GET)
    public String hello1(@RequestParam(value = "name", required = false) String name) {
        return "Hello " + name;
    }

    @RequestMapping(value = "hello2", method = RequestMethod.GET)
    public MatchMessage hello2(@RequestHeader(value = "name", required = false) String name,
                         @RequestHeader(value = "age", required = false) Integer age) {
        UserDto userDto = new UserDto(name, age);
        return new MatchMessage(userDto, MatchMessage.RESULT_MATCHED);
    }

    @RequestMapping(value = "hello3", method = RequestMethod.POST)
    public MatchMessage hello3(@RequestBody(required = false) UserDto userDto) {
        return new MatchMessage(userDto, MatchMessage.RESULT_MATCHED);
    }
}

