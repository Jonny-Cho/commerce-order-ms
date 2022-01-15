package com.commerce.vo;

import lombok.Getter;

@Getter
public class RequestOrder {
    private String productId;
    private Integer qty;
    private Integer unitPrice;
}
