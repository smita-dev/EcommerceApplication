package com.ecommereceApp.product_service.controller;

import com.ecommereceApp.product_service.dto.ProductRequest;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/api/product")
public class ProductController {

    @GetMapping("/pr")
    //@RequestBody ProductRequest productRequest
    public String createProduct(){
        return "Hello from server";
    }
}
