package com.mybusiness.backend.product.usecase;

import com.mybusiness.backend.product.domain.Product;
import com.mybusiness.backend.product.port.FindProductById;
import com.mybusiness.backend.product.port.FindProducts;
import com.mybusiness.backend.product.port.SaveProducts;
import lombok.AllArgsConstructor;
import org.springframework.stereotype.Component;

import java.util.List;

@Component
@AllArgsConstructor
public class ProductsUseCase {
    private final FindProductById findProductById;
    private final FindProducts findProducts;

    private final SaveProducts saveProducts;

    public List<Product> getProducts() {
        return this.findProducts.getProducts();
    }
    public Product getProductById(String id) {
        return this.findProductById.getProductById(id);
    }

    public List<Product> saveProducts(List<Product> products) {
        return this.saveProducts.putProducts(products);
    }
}
