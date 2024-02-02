package com.mybusiness.backend.product.adapter.out;

import com.mybusiness.backend.product.adapter.out.entity.ProductEntity;
import com.mybusiness.backend.product.domain.Product;
import com.mybusiness.backend.product.port.FindProductById;
import com.mybusiness.backend.product.port.FindProducts;
import com.mybusiness.backend.product.port.SaveProducts;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Component;

import java.math.BigDecimal;
import java.util.List;

@Component
@RequiredArgsConstructor
public class ProductPostgresAdapter implements FindProductById, FindProducts, SaveProducts {

    private final ProductRepository productRepository;
    @Override
    public Product getProductById(String id) {
        return new Product(id, "Product1", "This is our first product", BigDecimal.valueOf(100), 10);
    }

    @Override
    public List<Product> getProducts() {
        return productRepository.findAll().stream().map(this::mapToDomain).toList();
    }

    @Override
    public List<Product> putProducts(final List<Product> products) {

        return productRepository.saveAll(products.stream()
                .map(this::mapToDto).toList()).stream()
                .map(this::mapToDomain).toList();
    }

    private Product mapToDomain(ProductEntity productEntity) {
        return new Product(
                productEntity.getProductId(),
                productEntity.getName(),
                productEntity.getDescription(),
                productEntity.getPrice(),
                productEntity.getQuantity());
    }

    private ProductEntity mapToDto(Product product) {
        return ProductEntity.builder().productId(product.id())
                .description(product.description())
                .price(product.price())
                .name(product.name())
                .quantity(product.quantity())
                .build();
    }

}
