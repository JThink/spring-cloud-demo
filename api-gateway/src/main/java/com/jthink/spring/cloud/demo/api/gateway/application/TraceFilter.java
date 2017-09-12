package com.jthink.spring.cloud.demo.api.gateway.application;

import com.netflix.zuul.ZuulFilter;
import com.netflix.zuul.context.RequestContext;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import java.util.Map;

/**
 * Created by levi on 2017/9/11.
 */
public class TraceFilter extends ZuulFilter {

    private static final Logger LOGGER = LoggerFactory.getLogger(TraceFilter.class);

    @Override
    public String filterType() {
        return "pre";
    }

    @Override
    public int filterOrder() {
        return 0;
    }

    @Override
    public boolean shouldFilter() {
        LOGGER.info("1111");
        return true;
    }

    @Override
    public Object run() {
        LOGGER.info("2222");
        RequestContext context = RequestContext.getCurrentContext();
        Map<String, String> headers = context.getZuulRequestHeaders();

        headers.forEach((k,v) -> LOGGER.info("key: {}, value: {}", k, v));

        return null;
    }
}
