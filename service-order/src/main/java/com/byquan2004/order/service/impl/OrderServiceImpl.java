package com.byquan2004.order.service.impl;

import com.byquan2004.domain.pojo.Order;
import com.byquan2004.domain.pojo.Product;
import com.byquan2004.domain.pojo.R;
import com.byquan2004.order.client.OpenApiClient;
import com.byquan2004.order.client.ProductFeignClient;
import com.byquan2004.order.service.IOrderService;
import com.fasterxml.jackson.databind.ObjectMapper;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Service;

import java.util.Map;

@Slf4j
@Service
@RequiredArgsConstructor
public class OrderServiceImpl implements IOrderService {

    private final ProductFeignClient productFeignClient;
    private final OpenApiClient openApiClient;
    private final ObjectMapper objectMapper;

    @Override
    public Order createOrder(Long userId, Long productId) {
        //++========测试========
        Map<String, Object> res = openApiClient.getVideo(1, 20);
        log.info("首次获取的结果》〉》：{}", res);
//        try {
//            Map<String, Object> map = objectMapper.readValue(res, Map.class);
//            log.info("解析后的结果》〉》：{}", map);
//        } catch (JsonProcessingException e) {
//            e.printStackTrace();
//        }

        //++=================

        R<Product> product = productFeignClient.getByProductId(productId);
        log.info("查询到商品的结果为：{}", product);


        Order order = new Order();
        order.setOrderNo("20220101000001");
        order.setUserId(userId);
        order.setStatus("待付款");
        order.setTotalAmount(product.getData().getPrice()); // 从商品服务中获取商品价格
        order.setShippingAddress("中国上海");
        order.setPaymentMethod("支付宝");
        order.setRemark("无");
        return order;
    }
}
