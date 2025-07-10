package com.byquan2004.filters;

import lombok.extern.slf4j.Slf4j;
import org.springframework.cloud.gateway.filter.GatewayFilterChain;
import org.springframework.cloud.gateway.filter.GlobalFilter;
import org.springframework.core.Ordered;
import org.springframework.http.HttpHeaders;
import org.springframework.http.server.reactive.ServerHttpRequest;
import org.springframework.stereotype.Component;
import org.springframework.web.server.ServerWebExchange;
import reactor.core.publisher.Mono;

import java.util.List;

/**
 * 自定义全局过滤器
 */
@Slf4j
@Component
public class MyGlobalFilter implements GlobalFilter, Ordered {
    @Override
    public Mono<Void> filter(ServerWebExchange exchange, GatewayFilterChain chain) {

        ServerHttpRequest request = exchange.getRequest();
        HttpHeaders headers = request.getHeaders();

        // 测试获取请求头
        List<String> token = headers.get("Authorization");
        log.info(">>>>全局拦截器中打印token：{}", token);

        //测试修改请求头
        ServerWebExchange swe = exchange.mutate()
                .request(b -> b
                        .header("x-token", "1234567890")
                        .build())
                .build();


        return chain.filter(swe);
    }

    @Override
    public int getOrder() {
        // 过滤顺序
        return 1;
    }
}
