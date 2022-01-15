package com.commerce.jpa;

import com.commerce.dto.OrderDto;
import lombok.Getter;
import lombok.NoArgsConstructor;
import org.hibernate.annotations.ColumnDefault;

import javax.persistence.*;
import java.io.Serializable;
import java.util.Date;
import java.util.UUID;

@Getter
@Entity
@Table(name = "orders")
@NoArgsConstructor
public class OrderEntity implements Serializable {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @Column(nullable = false, length = 120, unique = true)
    private String productId;
    @Column(nullable = false)
    private Integer qty;
    @Column(nullable = false)
    private Integer unitPrice;
    @Column(nullable = false)
    private Integer totalPrice;
    @Column(nullable = false)
    private String userId;
    @Column(nullable = false, unique = true)
    private String orderId;

    @Column(nullable = false, updatable = false, insertable = false)
    @ColumnDefault(value = "CURRENT_TIMESTAMP")
    private Date createdAt;

    public OrderEntity(final OrderDto orderDto) {
        this.productId = orderDto.getProductId();
        this.qty = orderDto.getQty();
        this.unitPrice = orderDto.getUnitPrice();
        this.totalPrice = this.qty * this.unitPrice;
        this.userId = orderDto.getUserId();
        this.orderId = UUID.randomUUID().toString();
    }

}
