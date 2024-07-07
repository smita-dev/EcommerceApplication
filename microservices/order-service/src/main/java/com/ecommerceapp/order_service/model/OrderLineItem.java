package com.ecommerceapp.order_service.model;

import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import java.math.BigDecimal;

@Entity
@Table(name="order_line_items")
@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
public class OrderLineItem {

    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Id
    private long id;
    private String skuCode;
    private BigDecimal price;
    private Integer quantity;
}
