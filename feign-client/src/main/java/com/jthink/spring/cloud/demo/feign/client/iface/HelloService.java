package com.jthink.spring.cloud.demo.feign.client.iface;

import org.springframework.cloud.netflix.feign.FeignClient;
import org.springframework.web.bind.annotation.RequestMapping;

/**
 * Copyright (C), 2017, xgroup
 *
 * @author qianjc
 * @version 0.0.1
 * @desc
 * @date 2017-06-13 09:29:09
 */
@FeignClient("eureka-client-test")
public interface HelloService {

    @RequestMapping("/hello")
    String hello();
}
