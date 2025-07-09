package com.byquan2004.product.service.impl;

import com.byquan2004.domain.pojo.Product;
import com.byquan2004.product.service.IProductService;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Service;

@Slf4j
@Service
public class ProductServiceImpl implements IProductService {
    @Override
    public Product getById(Long productId) {

        Product product = new Product();
        product.setId(productId);
        product.setName("测试商品");
        product.setDescription("测试商品描述");
        product.setPrice(9.99);
        product.setStock(100);
        product.setCategory("测试商品类别");
        product.setImageUrl("https://example.com/test.jpg");

//        try {
//            log.info("正在查询商品信息...");
//            Thread.sleep(5000L);
//        } catch (InterruptedException e) {
//            throw new RuntimeException(e);
//        }

        return product;
    }
}
