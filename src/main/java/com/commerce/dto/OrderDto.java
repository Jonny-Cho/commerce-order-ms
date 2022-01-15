package com.commerce.dto;

import com.commerce.jpa.OrderEntity;
import com.commerce.vo.RequestOrder;
import lombok.Getter;
import lombok.Setter;

import java.io.Serializable;

@Getter
@Setter
public class OrderDto implements Serializable {
    private String productId;
    private Integer qty;
    private Integer unitPrice;
    private Integer totalPrice;

    private String orderId;
    private String userId;

    public OrderDto(final OrderEntity entity) {
        this.productId = entity.getProductId();
        this.qty = entity.getQty();
        this.unitPrice = entity.getUnitPrice();
        this.totalPrice = entity.getTotalPrice();
        this.orderId = entity.getOrderId();
        this.userId = entity.getUserId();
    }

    public OrderDto(final RequestOrder r) {
        this.productId = r.getProductId();
        this.qty = r.getQty();
        this.unitPrice = r.getUnitPrice();
    }
}
