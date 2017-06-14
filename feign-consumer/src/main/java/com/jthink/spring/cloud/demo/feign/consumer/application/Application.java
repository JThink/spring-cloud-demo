package com.jthink.spring.cloud.demo.feign.consumer.application;

import org.apache.http.impl.conn.PoolingHttpClientConnectionManager;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.builder.SpringApplicationBuilder;
import org.springframework.cloud.client.discovery.EnableDiscoveryClient;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.cloud.netflix.feign.EnableFeignClients;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.PropertySource;

/**y
 * JThink@JThink
 *
 * @author JThink
 * @version 0.0.1
 * @desc
 * @date 2017-06-05 10:10:57
 */
@EnableFeignClients(basePackages = {"com.jthink.spring.cloud.demo.feign.client.iface"})
@EnableDiscoveryClient
@SpringBootApplication
@ComponentScan(basePackages = {"com.jthink.spring.cloud.demo.feign.consumer"})
@PropertySource("classpath:properties/feign-consumer.properties")
public class Application {

    private static final Logger LOGGER = LoggerFactory.getLogger(Application.class);

    private static PoolingHttpClientConnectionManager cm = null;

    public static void main(String[] args) {
        new SpringApplicationBuilder(Application.class).run(args);
        LOGGER.info("feign consumer start successfully");
    }
}

