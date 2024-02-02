package com.mybusiness.backend.product.adapter.out.entity;

import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Getter;
import lombok.RequiredArgsConstructor;

import java.math.BigDecimal;
@Builder
@Getter
@AllArgsConstructor
@RequiredArgsConstructor
@Entity
@Table(name = "BUSINESS_PRODUCT")
public class ProductEntity {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    private String productId;
    private String name;
    private String description;
    private BigDecimal price;
    private Integer quantity;

}
