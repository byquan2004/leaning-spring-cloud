package com.byquan2004.order.client;

import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestParam;

import java.util.Map;

@FeignClient(name = "custom-service", url = "https://api.apiopen.top/api")
public interface OpenApiClient {

    /**
     * 获取视频
     * @param page 当前页
     * @param size 每页数量
     * @return <自定义> json字符串
     */
    @GetMapping("/getMiniVideo")
    Map<String, Object> getVideo(@RequestParam("page") Integer page, @RequestParam("size") Integer size);
}
