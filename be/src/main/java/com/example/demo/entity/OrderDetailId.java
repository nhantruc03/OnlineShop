package com.example.demo.entity;

import java.io.Serializable;

import jakarta.persistence.Embeddable;
import lombok.Data;

@Embeddable
@Data
class OrderDetailId implements Serializable {
    private Long product_id;
    private Long order_id;
}
