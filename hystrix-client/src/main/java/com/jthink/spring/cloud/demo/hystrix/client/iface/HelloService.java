package com.jthink.spring.cloud.demo.hystrix.client.iface;

import com.jthink.spring.cloud.demo.hystrix.client.dto.UserDto;
import com.jthink.spring.cloud.demo.hystrix.client.fallback.UserFallbackFactory;
import com.jthink.spring.cloud.demo.hystrix.client.message.MatchMessage;
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
@FeignClient(name = "eureka-client-test", fallbackFactory = UserFallbackFactory.class)
@RequestMapping("spring-cloud")
public interface HelloService {

    @RequestMapping(value = "hello1", method = RequestMethod.GET)
    String hello(@RequestParam(value = "name", required = false) String name);

    @RequestMapping(value = "hello2", method = RequestMethod.GET)
    MatchMessage hello(@RequestHeader(value = "name", required = false) String name,
                        @RequestHeader(value = "age", required = false) Integer age);

    @RequestMapping(value = "hello3", method = RequestMethod.POST)
    MatchMessage hello(@RequestBody(required = false) UserDto userDto);
}
