package com.mybusiness.backend.product.port;

import com.mybusiness.backend.product.domain.Product;

import java.util.List;

public interface SaveProducts {
    List<Product> putProducts(List<Product> products);
}
