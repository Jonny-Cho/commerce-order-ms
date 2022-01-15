package com.commerce.controller;

import com.commerce.dto.OrderDto;
import com.commerce.jpa.OrderEntity;
import com.commerce.service.OrderService;
import com.commerce.vo.RequestOrder;
import com.commerce.vo.ResponseOrder;
import lombok.RequiredArgsConstructor;
import org.springframework.core.env.Environment;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequiredArgsConstructor
public class OrderController {

    private final Environment env;
    private final OrderService orderService;

    @GetMapping("/health_check")
    public String status() {
        return String.format("It's Working in Order Service on PORT %s", env.getProperty("local.server.port"))
    }

    @PostMapping("/{userId}/orders")
    public ResponseEntity<ResponseOrder> createOrder(
        @PathVariable("userId") final String userId,
        @RequestBody final RequestOrder requestOrder) {

        final OrderDto orderDto = new OrderDto(requestOrder);
        final OrderDto createdOrder = orderService.createOrder(orderDto);
        final ResponseOrder result = new ResponseOrder(createdOrder);

        return ResponseEntity.status(HttpStatus.CREATED).body(result);
    }

    @GetMapping("/{userId}/orders")
    public ResponseEntity<List<ResponseOrder>> getOrder(@PathVariable("userId") final String userId) {
        final List<OrderEntity> orderList = orderService.getOrdersByUserId(userId);
        final List<ResponseOrder> result = ResponseOrder.from(orderList);

        return ResponseEntity.status(HttpStatus.OK).body(result);
    }

}
