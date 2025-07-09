package com.byquan2004.order.exception;

import com.byquan2004.domain.pojo.R;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.RestControllerAdvice;

/**
 * 全局异常处理 如：对于sentinelResource注解的保护资源未做兜底毁掉或者抛出的异常未做处理 最终会由这个类处理
 */
@RestControllerAdvice
public class GlobalExceptionHandler {

    @ExceptionHandler(Exception.class)
    public R<String> handleException(Exception e){
        e.printStackTrace();
        return R.error(500, e.getMessage());
    }
}
