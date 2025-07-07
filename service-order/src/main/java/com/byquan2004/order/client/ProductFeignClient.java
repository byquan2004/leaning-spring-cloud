package com.byquan2004.order.client;

import com.byquan2004.domain.pojo.Product;
import com.byquan2004.domain.pojo.R;
import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;

// 开启feign客户端 访问product服务 注意微服务名称一致 自动负载均衡
@FeignClient(name = "product-service")
public interface ProductFeignClient {

    /**
     * @desc
     * 为了方便区分理解，可以与mvc注解相比这里可以理解为"向xxx发请求"如/product/{productId} ,
     * 而可以将controller中定义看做”接受什么的请求“如/product/{productId}
     *
     * 注意与商品服务的controller接口保持一致
     * @param productId
     * @return
     */
    @GetMapping("/product/{productId}")
    R<Product> getByProductId(@PathVariable("productId") Long productId);
}
