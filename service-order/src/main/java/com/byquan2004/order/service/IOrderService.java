package com.byquan2004.order.service;

import com.byquan2004.domain.pojo.Order;

public interface IOrderService {
    Order createOrder(Long userId, Long productId);
}
