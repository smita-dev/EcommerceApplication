package com.ecommerceapp.inventory_service.model;

import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Entity
@Table(name="inventory")
@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
public class Inventory {
    @Id
     @GeneratedValue(strategy = GenerationType.IDENTITY)
    long id;
    String skuCode;
    int quantity;

}
