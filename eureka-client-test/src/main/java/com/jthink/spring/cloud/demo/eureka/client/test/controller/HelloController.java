package com.jthink.spring.cloud.demo.eureka.client.test.controller;

import com.jthink.spring.cloud.demo.feign.client.dto.UserDto;
import com.jthink.spring.cloud.demo.feign.client.iface.HelloService;
import com.jthink.spring.cloud.demo.feign.client.message.MatchMessage;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.cloud.client.ServiceInstance;
import org.springframework.cloud.client.discovery.DiscoveryClient;
import org.springframework.cloud.client.serviceregistry.Registration;
import org.springframework.cloud.context.config.annotation.RefreshScope;
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
@RefreshScope
public class HelloController implements HelloService {

    @Value("${the.test.key}")
    private String test;

    @Value("${the.test.key2}")
    private String test2;

    @RequestMapping(value = "test", method = RequestMethod.GET)
    public String hello3() {
        LOGGER.info("call hello, simple");
        return this.test2;
    }

    @RequestMapping(value = "test2", method = RequestMethod.GET)
    public String hello4() {
        LOGGER.info("call hello, simple2");
        return this.test;
    }

    private static final Logger LOGGER = LoggerFactory.getLogger(HelloController.class);

    @Override
    public String hello(@RequestParam(value = "name", required = false) String name) {
        LOGGER.info("call hello, simple");
        return "Hello " + name;
    }

    @Override
    public MatchMessage hello(@RequestHeader(value = "name", required = false) String name,
                         @RequestHeader(value = "age", required = false) Integer age) {
        UserDto userDto = new UserDto(name, age);
        LOGGER.info("call hello, GET");
        return new MatchMessage(userDto, MatchMessage.RESULT_MATCHED);
    }

    @Override
    public MatchMessage hello(@RequestBody(required = false) UserDto userDto) {
        LOGGER.info("call hello, POST");
        return new MatchMessage(userDto, MatchMessage.RESULT_MATCHED);
    }
}

