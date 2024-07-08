package com.ecommerceapp.order_service.service;

import com.ecommerceapp.order_service.dto.OrderLineItemsDto;
import com.ecommerceapp.order_service.dto.OrderRequest;
import com.ecommerceapp.order_service.model.Order;
import com.ecommerceapp.order_service.model.OrderLineItem;
import jakarta.transaction.Transactional;
import org.springframework.stereotype.Service;

import com.ecommerceapp.order_service.repository.OrderRepository;
import org.springframework.web.reactive.function.client.WebClient;

import java.util.List;
import java.util.UUID;

@Transactional
@Service
public class OrderService {
    private final OrderRepository orderRepository;
    private final WebClient webClient;

    OrderService(OrderRepository orderRepository,WebClient webClient){
        this.orderRepository=orderRepository;
        this.webClient=webClient;
    }
    public void placeOrder(OrderRequest orderRequest){
        Order order=new Order();
        order.setOrderNumber(UUID.randomUUID().toString());
        List<OrderLineItem> orderLineItems=orderRequest.getOrderLineItemsDtoList().stream().map(orderLineItemDto->mapToDto(orderLineItemDto)
        ).toList();
        order.setOrderLineItemList(orderLineItems);

        //call inventory service to check if product is in stock or not
        //and place the order if product is available
        Boolean responseFromInventoryService=webClient.get().uri("http://localhost:8082/api/inventory")
                        .retrieve()
                                .bodyToMono(Boolean.class)
                                        .block();
        if(Boolean.TRUE.equals(responseFromInventoryService)){
            orderRepository.save(order);
        }else{
            throw new IllegalArgumentException("Product is not available. Please try again.");
        }

    }

    private OrderLineItem mapToDto(OrderLineItemsDto orderLineItemDto) {
        OrderLineItem orderLineItem=new OrderLineItem();
        orderLineItem.setSkuCode(orderLineItemDto.getSkuCode());
        orderLineItem.setPrice(orderLineItemDto.getPrice());
        orderLineItem.setQuantity(orderLineItemDto.getQuantity());
        return orderLineItem;
    }
}
