package com.byquan2004.order.service.impl;

import com.byquan2004.domain.pojo.Order;
import com.byquan2004.order.service.IOrderService;
import org.springframework.stereotype.Service;

@Service
public class OrderServiceImpl implements IOrderService {
    @Override
    public Order createOrder(Long userId, Long productId) {
        Order order = new Order();
        order.setOrderNo("20220101000001");
        order.setUserId(userId);
        order.setStatus("待付款");
        order.setTotalAmount(100.0); // todo 从商品服务中获取商品价格
        order.setShippingAddress("中国上海");
        order.setPaymentMethod("支付宝");
        order.setRemark("无");
        return order;
    }
}
