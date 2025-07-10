package com.byquan2004.filters;

import lombok.Data;
import lombok.extern.slf4j.Slf4j;
import org.springframework.cloud.gateway.filter.GatewayFilter;
import org.springframework.cloud.gateway.filter.GatewayFilterChain;
import org.springframework.cloud.gateway.filter.factory.AbstractGatewayFilterFactory;
import org.springframework.stereotype.Component;
import org.springframework.web.server.ServerWebExchange;
import reactor.core.publisher.Mono;

import java.util.Arrays;
import java.util.List;

@Slf4j
@Component
public class MyCustomGatewayFilterFactory extends AbstractGatewayFilterFactory<MyCustomGatewayFilterFactory.Config> {

    public MyCustomGatewayFilterFactory() {
        super(Config.class);
    }

    @Override
    public GatewayFilter apply(MyCustomGatewayFilterFactory.Config config) {
        return new GatewayFilter() {
            @Override
            public Mono<Void> filter(ServerWebExchange exchange, GatewayFilterChain chain) {
                // 1.携带参数
                log.info(">>>>>携带自定义参数为：{}", config.toString());
                // 2.编写过滤逻辑
                log.info(">>>>>编写过滤逻辑...");
                return chain.filter(exchange);
            }
        };
    }

    @Override
    public List<String> shortcutFieldOrder() {
        return Arrays.asList("a","b","c");
    }

    /**
     * 配置类
     */
    @Data
    public static class Config {
        private String a;
        private String b;
        private String c;
    }
}
