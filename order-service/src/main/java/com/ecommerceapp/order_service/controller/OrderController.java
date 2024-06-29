package com.ecommerceapp.order_service.controller;

import com.ecommerceapp.order_service.dto.OrderRequest;
import com.ecommerceapp.order_service.service.OrderService;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/api/order")
public class OrderController {

    private OrderService orderService;

    OrderController(OrderService orderService){
        this.orderService=orderService;
    }

    @ResponseStatus(HttpStatus.CREATED)
    @PostMapping
    public String placeOrder(@RequestBody OrderRequest orderRequest){
        orderService.placeOrder(orderRequest);
        return "new order created";
    }
}
