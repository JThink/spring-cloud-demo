package com.jthink.spring.cloud.demo.eureka.client.test.controller;

import com.jthink.spring.cloud.demo.feign.client.dto.UserDto;
import com.jthink.spring.cloud.demo.feign.client.iface.HelloService;
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
public class HelloController implements HelloService {

    private static final Logger LOGGER = LoggerFactory.getLogger(HelloController.class);

    @Override
    public String hello(@RequestParam(value = "name", required = false) String name) {
        return "Hello " + name;
    }

    @Override
    public MatchMessage hello(@RequestHeader(value = "name", required = false) String name,
                         @RequestHeader(value = "age", required = false) Integer age) {
        UserDto userDto = new UserDto(name, age);
        return new MatchMessage(userDto, MatchMessage.RESULT_MATCHED);
    }

    @Override
    public MatchMessage hello(@RequestBody(required = false) UserDto userDto) {
        return new MatchMessage(userDto, MatchMessage.RESULT_MATCHED);
    }
}

