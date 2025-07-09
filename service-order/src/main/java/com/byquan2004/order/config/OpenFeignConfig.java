package com.byquan2004.order.config;

import feign.Logger;
import feign.Retryer;

//@Configuration
public class OpenFeignConfig {

    /**
     * 配置feign重试机制 默认openfeign不开启重试机制
     * @return
     */
//    @Bean
    public Retryer simpleRetryer() {
        return new Retryer.Default();
    }

    /**
     * 配置feign请求日志级别 可以基于配置文件方式也可以ioc注入方式
     * @return
     */
//     @Bean
    Logger.Level feignLoggerLevel() {
        // 记录全量日志
        return Logger.Level.FULL;
    }
}
