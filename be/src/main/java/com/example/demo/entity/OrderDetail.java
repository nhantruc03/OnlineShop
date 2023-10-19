package com.example.demo.entity;


import java.math.BigDecimal;

import jakarta.persistence.EmbeddedId;
import jakarta.persistence.Entity;
import jakarta.persistence.ManyToOne;
import jakarta.persistence.MapsId;
import jakarta.persistence.Table;
import lombok.Builder;
import lombok.Data;

@Entity
@Table(name = "tbl_orderdetail")
@Data
@Builder
public class OrderDetail {

    @EmbeddedId
    private OrderDetailId id;
    
    @MapsId("product_id")
    @ManyToOne   
    private Product product;

    @MapsId("order_id")
    @ManyToOne
    private Order order;

    private Integer quantity;
    private BigDecimal price;
}



