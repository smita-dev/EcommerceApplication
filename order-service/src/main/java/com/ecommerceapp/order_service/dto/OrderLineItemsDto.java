package com.ecommerceapp.order_service.dto;

import java.math.BigDecimal;

public class OrderLineItemsDto {
    private long id;
    private String skuCode;
    private BigDecimal price;
    private Integer quantity;
}
