package com.ecommereceApp.product_service.service;

import ch.qos.logback.classic.Logger;
import com.ecommereceApp.product_service.dto.ProductRequest;
import com.ecommereceApp.product_service.model.Product;
import com.ecommereceApp.product_service.repository.ProductRepository;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Service;

@Service
@Slf4j
public class ProductService {
    private final ProductRepository productRepository;
//    private final Logger log=
    ProductService(ProductRepository productRepository){
        this.productRepository=productRepository;
    }
    public void createProduct(ProductRequest productRequest){
        Product product=Product.builder().name(productRequest.getName()).
                description(productRequest.getDescription()).
                price(productRequest.getPrice()).build();
        productRepository.save(product);
        log.info("product {}is saved",product);
    }
}
