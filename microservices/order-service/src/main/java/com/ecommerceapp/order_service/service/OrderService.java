package com.ecommerceapp.order_service.service;

import com.ecommerceapp.order_service.dto.OrderLineItemsDto;
import com.ecommerceapp.order_service.dto.OrderRequest;
import com.ecommerceapp.order_service.model.Order;
import com.ecommerceapp.order_service.model.OrderLineItem;
import jakarta.transaction.Transactional;
import org.springframework.stereotype.Service;

import com.ecommerceapp.order_service.repository.OrderRepository;

import java.util.List;
import java.util.UUID;

@Transactional
@Service
public class OrderService {
    private final OrderRepository orderRepository;
    OrderService(OrderRepository orderRepository){
        this.orderRepository=orderRepository;
    }
    public void placeOrder(OrderRequest orderRequest){
        Order order=new Order();
        order.setOrderNumber(UUID.randomUUID().toString());
        List<OrderLineItem> orderLineItems=orderRequest.getOrderLineItemsDtoList().stream().map(orderLineItemDto->mapToDto(orderLineItemDto)
        ).toList();
        order.setOrderLineItemList(orderLineItems);

        orderRepository.save(order);
    }

    private OrderLineItem mapToDto(OrderLineItemsDto orderLineItemDto) {
        OrderLineItem orderLineItem=new OrderLineItem();
        orderLineItem.setSkuCode(orderLineItemDto.getSkuCode());
        orderLineItem.setPrice(orderLineItemDto.getPrice());
        orderLineItem.setQuantity(orderLineItemDto.getQuantity());
        return orderLineItem;
    }
}
