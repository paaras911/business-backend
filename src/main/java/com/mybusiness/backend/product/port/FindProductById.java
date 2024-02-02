package com.mybusiness.backend.product.port;

import com.mybusiness.backend.product.domain.Product;

public interface FindProductById {
     Product getProductById(String id);
}
