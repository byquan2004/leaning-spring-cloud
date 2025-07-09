package com.byquan2004.order.client.fallback;

import com.byquan2004.domain.pojo.Product;
import com.byquan2004.domain.pojo.R;
import com.byquan2004.order.client.ProductFeignClient;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Component;

@Slf4j
@Component
public class ProductFeignClientImpl implements ProductFeignClient {
    /**
     * 兜底回调实现方法
     * 注意触发该兜底前提需要配置文件开启 并 引入熔断降级相关依赖如sentinel7小时-SpringCloud笔记.pdf
     * @param productId
     * @return
     */
    @Override
    public R<Product> getByProductId(Long productId) {
        Product product = new Product();

        product.setCategory("兜底");
        product.setDescription("兜底");
        product.setImageUrl("兜底");
        product.setName("兜底");
        product.setPrice(0.0);
        product.setStock(0);
        product.setId(productId);

        return R.success(product);
    }
}
