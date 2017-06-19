package com.jthink.spring.cloud.demo.hystrix.consumer.application;

import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.builder.SpringApplicationBuilder;
import org.springframework.cloud.client.discovery.EnableDiscoveryClient;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.cloud.client.loadbalancer.LoadBalanced;
import org.springframework.cloud.netflix.feign.EnableFeignClients;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.PropertySource;
import org.springframework.web.client.RestTemplate;

/**y
 * JThink@JThink
 *
 * @author JThink
 * @version 0.0.1
 * @desc
 * @date 2017-06-05 10:10:57
 */
@EnableFeignClients(basePackages = {"com.jthink.spring.cloud.demo.hystrix.client.iface"})
@EnableDiscoveryClient
@SpringBootApplication
@ComponentScan(basePackages = {"com.jthink.spring.cloud.demo.hystrix.consumer",
        "com.jthink.spring.cloud.demo.hystrix.client.fallback"})
@PropertySource("classpath:properties/hystrix-consumer.properties")
public class Application {

    private static final Logger LOGGER = LoggerFactory.getLogger(Application.class);

    @Bean
    @LoadBalanced
    RestTemplate restTemplate() {
        return new RestTemplate();
    }

    public static void main(String[] args) {
        new SpringApplicationBuilder(Application.class).run(args);
        LOGGER.info("hystrix consumer start successfully");
    }
}
