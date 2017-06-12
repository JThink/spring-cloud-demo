package com.jthink.spring.cloud.demo.feign.consumer.client;

import org.springframework.cloud.netflix.feign.FeignClient;
import org.springframework.web.bind.annotation.RequestMapping;

/**
 * Copyright (C), 2017, xgroup
 *
 * @author qianjc
 * @version 0.0.1
 * @desc feign客户端接口
 * @date 2017-06-12 16:18:24
 */
@FeignClient("eureka-client-test")
public interface HelloService {

    @RequestMapping("/hello")
    String hello();
}
