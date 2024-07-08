package com.ecommerceapp.inventory_service.service;

import com.ecommerceapp.inventory_service.dto.InventoryResponse;
import com.ecommerceapp.inventory_service.repository.InventoryRepository;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

@Service
public class InventoryService {
     private final InventoryRepository inventoryRepository;

    public InventoryService(InventoryRepository inventoryRepository) {
        this.inventoryRepository = inventoryRepository;
    }

    //  using path variable http://localhost:8082/api/inventory/IPhone_13,IPhone14
    //  Using Request param http://localhost:8082/api/inventory?skuCode=IPhone_13&skuCode=IPhone14
    //  in one order we have multiple order line Item
    //  for each order line item we have skucode
    //  so suppose we have 100 or 500 order line item
    //  making 100 call to inventory service is not sufficient so we will
    //  pass all skucode as request param and we will check for all skucode
    //that whether its in stock or not
    @Transactional(readOnly = true)
    public List<InventoryResponse> isInStock(List<String> skuCode){
          return inventoryRepository.findBySkuCodeIn(skuCode).stream().
                  map(inventory->
                       InventoryResponse.builder()
                               .skuCode(inventory.getSkuCode())
                               .isInStock(inventory.getQuantity()>0).build()
                  ).toList();
     }
}
