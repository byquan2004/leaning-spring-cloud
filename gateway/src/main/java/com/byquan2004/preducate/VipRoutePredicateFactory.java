package com.byquan2004.preducate;

import jakarta.validation.constraints.NotEmpty;
import lombok.Data;
import org.springframework.cloud.gateway.handler.predicate.AbstractRoutePredicateFactory;
import org.springframework.http.server.reactive.ServerHttpRequest;
import org.springframework.stereotype.Component;
import org.springframework.util.StringUtils;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.server.ServerWebExchange;

import java.util.Arrays;
import java.util.List;
import java.util.function.Predicate;

@Component
public class VipRoutePredicateFactory extends AbstractRoutePredicateFactory<VipRoutePredicateFactory.Config> {
    public static final String MY_KEY = "myKey";
    public static final String MY_VALUE = "myValue";

    public VipRoutePredicateFactory() {
        super(Config.class);
    }

    @Override
    public Predicate<ServerWebExchange> apply(Config config) {
        return new Predicate<ServerWebExchange>() {
            @Override
            public boolean test(ServerWebExchange exchange) {
                ServerHttpRequest request = exchange.getRequest();
                // 获取路径参数 比较是否跟配置的一致
                String key = request.getQueryParams().getFirst(config.getMyKey());
                return StringUtils.hasText(key) && key.equals(config.getMyValue());
            }
        };
    }

    /**
     * 快捷方式配置 遵循的顺序
     * @example - Vip=myKey,myValue
     * @return
     */
    @Override
    public List<String> shortcutFieldOrder() {
        return Arrays.asList(MY_KEY, MY_VALUE);
    }

    /**
     * 可配置参数
     */
    @Data
    @Validated
    public static class Config {
        private @NotEmpty String myKey;
        private @NotEmpty String myValue;
    }
}
