package com.byquan2004.product.controller;

import com.byquan2004.domain.pojo.Product;
import com.byquan2004.domain.pojo.R;
import com.byquan2004.product.service.IProductService;
import lombok.RequiredArgsConstructor;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/product")
@RequiredArgsConstructor
public class ProductController {

    private final IProductService productService;

    @GetMapping("/{productId}")
    public R<Product> getByProductId(@PathVariable("productId") Long productId)
    {
        return R.success(productService.getById(productId));
    }
}
