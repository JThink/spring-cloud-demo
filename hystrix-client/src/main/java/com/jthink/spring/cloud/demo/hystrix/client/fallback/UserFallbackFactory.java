package com.jthink.spring.cloud.demo.hystrix.client.fallback;

import com.jthink.spring.cloud.demo.hystrix.client.dto.UserDto;
import com.jthink.spring.cloud.demo.hystrix.client.iface.HelloService;
import com.jthink.spring.cloud.demo.hystrix.client.message.MatchMessage;
import feign.hystrix.FallbackFactory;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Component;

/**
 * Copyright (C), 2017, xgroup
 *
 * @author qianjc
 * @version 0.0.1
 * @desc 服务降级
 * @date 2017-06-19 14:26:12
 */
@Component
public class UserFallbackFactory implements FallbackFactory<HelloService> {

    private static final Logger LOGGER = LoggerFactory.getLogger(UserFallbackFactory.class);

    @Override
    public HelloService create(final Throwable cause) {
        return new HelloService() {
            @Override
            public String hello(String name) {
                UserFallbackFactory.LOGGER.info(cause.toString());
                UserFallbackFactory.LOGGER.info("call the fallback code");
                return "this is fallback hello";
            }

            @Override
            public MatchMessage hello(String name, Integer age) {
                UserFallbackFactory.LOGGER.info(cause.toString());
                UserFallbackFactory.LOGGER.info("call the fallback code");
                return new MatchMessage(new UserDto("default name", 20), MatchMessage.RESULT_NO_MATCH);
            }

            @Override
            public MatchMessage hello(UserDto userDto) {
                UserFallbackFactory.LOGGER.info(cause.toString());
                UserFallbackFactory.LOGGER.info("call the fallback code");
                return new MatchMessage(userDto, MatchMessage.RESULT_NO_MATCH);
            }
        };
    }
}