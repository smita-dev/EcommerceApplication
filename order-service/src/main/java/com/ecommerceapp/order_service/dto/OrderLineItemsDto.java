package com.ecommerceapp.order_service.dto;

import lombok.Data;

import java.math.BigDecimal;

@Data
public class OrderLineItemsDto {
    private long id;
    private String skuCode;
    private BigDecimal price;
    private Integer quantity;
}
