package com.byquan2004.order.controller;

import com.byquan2004.domain.pojo.Order;
import com.byquan2004.domain.pojo.R;
import com.byquan2004.order.service.IOrderService;
import lombok.RequiredArgsConstructor;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/order")
@RequiredArgsConstructor
public class OrderController {

    private final IOrderService orderService;

    @PostMapping("/create")
    public R<Order> createOrder(@RequestParam("userId") Long userId,
                                @RequestParam("productId") Long productId)
    {
        return R.success(orderService.createOrder(userId, productId));
    }
}
