package com.jthink.spring.cloud.demo.eureka.server.application;

import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.builder.SpringApplicationBuilder;
import org.springframework.cloud.netflix.eureka.server.EnableEurekaServer;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.context.annotation.PropertySource;


/**
 * JThink@JThink
 *
 * @author JThink
 * @version 0.0.1
 * @desc
 * @date 2017-06-05 10:10:57
 */
@EnableEurekaServer
@SpringBootApplication
@PropertySource("file:/opt/jthink/jthink-config/spring-cloud-demo/eureka-server.properties")
//@PropertySource("classpath:properties/eureka-server.properties")
public class Application {

    private static final Logger LOGGER = LoggerFactory.getLogger(Application.class);

    public static void main(String[] args) {
        new SpringApplicationBuilder(Application.class).run(args);
        LOGGER.info("eureka server start successfully");
    }
}

