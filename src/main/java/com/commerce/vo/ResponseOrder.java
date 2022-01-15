package com.commerce.vo;

import com.commerce.dto.OrderDto;
import com.commerce.jpa.OrderEntity;
import com.fasterxml.jackson.annotation.JsonInclude;
import lombok.Getter;

import java.util.Date;
import java.util.List;
import java.util.stream.Collectors;

@Getter
@JsonInclude(JsonInclude.Include.NON_NULL)
public class ResponseOrder {
    private String productId;
    private Integer qty;
    private Integer unitPrice;
    private Integer totalPrice;
    private Date createdAt;

    public ResponseOrder(final OrderEntity entity) {
        this.productId = entity.getProductId();
        this.qty = entity.getQty();
        this.unitPrice = entity.getUnitPrice();
        this.totalPrice = entity.getTotalPrice();
        this.createdAt = entity.getCreatedAt();
    }

    public ResponseOrder(final OrderDto d) {
        this.productId = d.getProductId();
        this.qty = d.getQty();
        this.unitPrice = d.getUnitPrice();
        this.totalPrice = d.getTotalPrice();
    }

    public static List<ResponseOrder> from(final List<OrderEntity> orderList) {
        return orderList.stream()
                .map(ResponseOrder::new)
                .collect(Collectors.toList());
    }
}
