package com.commerce.jpa;

import org.springframework.data.repository.CrudRepository;

import java.util.List;

public interface OrderRepository extends CrudRepository<OrderEntity, Long> {
    OrderEntity findByOrderId(String orderId);

    List<OrderEntity> findByUserId(String userId);
}
