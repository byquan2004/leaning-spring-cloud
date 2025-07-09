package com.byquan2004.order.exception;

import com.alibaba.csp.sentinel.adapter.spring.webmvc_v6x.callback.BlockExceptionHandler;
import com.alibaba.csp.sentinel.slots.block.BlockException;
import com.alibaba.fastjson.JSONObject;
import com.byquan2004.domain.pojo.R;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import org.springframework.stereotype.Component;

import java.io.PrintWriter;

/**
 * 注册到spring容器中替换默认的异常处理器
 * 自定义 服务熔断 异常处理器
 * 该异常处理器针对web接口资源 生效
 */
@Component
public class MySentinelExceptionHandler implements BlockExceptionHandler {
    @Override
    public void handle(HttpServletRequest request, HttpServletResponse response, String s, BlockException e) throws Exception {
        response.setStatus(429);
        PrintWriter out = response.getWriter();

        response.setContentType("application/json,charset=utf-8;");
        // 返回统一格式的数据
        String data = JSONObject.toJSONString(
                R.error(429, "请求被限流了")
        );

        out.print(data);
        out.flush();
        out.close();
    }
}
