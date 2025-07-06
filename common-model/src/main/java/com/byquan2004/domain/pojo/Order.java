package com.byquan2004.domain.pojo;

import lombok.Data;

@Data
public class Order {
    private Long id;              // 订单唯一标识
    private String orderNo;       // 订单编号
    private Long userId;          // 用户ID
    private String status;        // 订单状态（例如：待支付、已发货、已完成）
    private Double totalAmount;   // 总金额
    private String shippingAddress; // 收货地址
    private String paymentMethod; // 支付方式
    private String remark;        // 备注信息
}
