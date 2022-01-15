package com.commerce.service;

import com.commerce.dto.OrderDto;
import com.commerce.jpa.OrderEntity;
import com.commerce.jpa.OrderRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;
import java.util.UUID;

@Service
@Transactional
@RequiredArgsConstructor
public class OrderService {

    private final OrderRepository orderRepository;

    public OrderDto createOrder(final OrderDto orderDto) {
        final OrderEntity orderEntity = new OrderEntity(orderDto);
        final OrderEntity savedOrderEntity = orderRepository.save(orderEntity);
        return new OrderDto(savedOrderEntity);
    }

    @Transactional(readOnly = true)
    public OrderDto getOrderByOrderId(final String orderId) {
        return new OrderDto(orderRepository.findByOrderId(orderId));
    }

    @Transactional(readOnly = true)
    public List<OrderEntity> getOrdersByUserId(final String userId) {
        return orderRepository.findByUserId(userId);
    }

}
