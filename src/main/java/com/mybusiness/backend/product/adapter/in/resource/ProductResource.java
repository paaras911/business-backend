package com.mybusiness.backend.product.adapter.in.resource;

import java.math.BigDecimal;

public record ProductResource(
        String id,
        String name,
        String description,
        BigDecimal price,
        Integer quantity
){}
