package com.jthink.spring.cloud.demo.eureka.client.test.application;

import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.builder.SpringApplicationBuilder;
import org.springframework.cloud.client.discovery.EnableDiscoveryClient;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.PropertySource;

/**
 * JThink@JThink
 *
 * @author JThink
 * @version 0.0.1
 * @desc
 * @date 2017-06-05 10:10:57
 */
@EnableDiscoveryClient
@SpringBootApplication
@ComponentScan(basePackages = {"com.jthink.spring.cloud.demo.eureka.client.test"})
@PropertySource("classpath:properties/eureka-client-test.properties")
public class Application {

    private static final Logger LOGGER = LoggerFactory.getLogger(Application.class);

    public static void main(String[] args) {
        new SpringApplicationBuilder(Application.class).run(args);
        LOGGER.info("eureka client start successfully");
    }
}

