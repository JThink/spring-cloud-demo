package com.jthink.spring.cloud.demo.feign.client.iface;

import com.jthink.spring.cloud.demo.feign.client.dto.UserDto;
import com.jthink.spring.cloud.demo.feign.client.message.MatchMessage;
import org.springframework.cloud.netflix.feign.FeignClient;
import org.springframework.web.bind.annotation.*;

/**
 * Copyright (C), 2017, xgroup
 *
 * @author qianjc
 * @version 0.0.1
 * @desc client iface
 * @date 2017-06-13 09:29:09
 */
@FeignClient("eureka-client-test")
public interface HelloService {

    @RequestMapping("/hello")
    String hello();

    @RequestMapping(value = "/hello1", method = RequestMethod.GET)
    String hello1(@RequestParam(value = "name", required = false) String name);

    @RequestMapping(value = "/hello2", method = RequestMethod.GET)
    MatchMessage hello2(@RequestHeader(value = "name", required = false) String name,
                        @RequestHeader(value = "age", required = false) Integer age);

    @RequestMapping(value = "/hello3", method = RequestMethod.POST)
    MatchMessage hello3(@RequestBody(required = false) UserDto userDto);
}
