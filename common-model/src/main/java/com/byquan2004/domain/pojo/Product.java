package com.byquan2004.domain.pojo;

import lombok.Data;

@Data
public class Product {
    private Long id;              // 商品唯一标识
    private String name;          // 商品名称
    private String description;   // 商品描述
    private Double price;         // 商品价格
    private Integer stock;        // 库存数量
    private String category;      // 商品分类
    private String imageUrl;      // 商品图片链接
}
