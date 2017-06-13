package com.jthink.spring.cloud.demo.feign.consumer.controller;

import com.jthink.spring.cloud.demo.feign.client.dto.UserDto;
import com.jthink.spring.cloud.demo.feign.client.iface.HelloService;
import com.jthink.spring.cloud.demo.feign.client.message.MatchMessage;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
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
    private HelloService helloService;

    @RequestMapping(value = "feign-consumer", method = RequestMethod.GET)
    public String consume() {
        return this.helloService.hello();
    }

    @RequestMapping(value = "feign-consumer1", method = RequestMethod.GET)
    public MatchMessage consume1() {
        LOGGER.info(this.helloService.hello1("levi.qian"));
        MatchMessage message = this.helloService.hello2("levi.qian", 20);
        LOGGER.info(message.getResult() + "");
        return this.helloService.hello3(new UserDto("levi.qian", 27));
    }
}

