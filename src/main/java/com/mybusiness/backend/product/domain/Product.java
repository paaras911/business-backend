package com.mybusiness.backend.product.domain;

import java.math.BigDecimal;

public record Product(String id,
                      String name,
                      String description,
                      BigDecimal price,
                      Integer quantity) {
}
