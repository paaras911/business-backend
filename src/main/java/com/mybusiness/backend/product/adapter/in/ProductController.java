package com.mybusiness.backend.product.adapter.in;

import com.mybusiness.backend.product.adapter.in.resource.ProductResource;
import com.mybusiness.backend.product.domain.Product;
import com.mybusiness.backend.product.usecase.ProductsUseCase;
import lombok.AllArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@AllArgsConstructor
@RequestMapping("/product")
public class ProductController {
    private final ProductsUseCase productsUseCase;

    @GetMapping(produces = "application/json")
    public ResponseEntity<ProductResource> productById(@RequestParam(name = "id") String id) {
        return ResponseEntity.ok()
                .header("Access-Control-Allow-Origin", "*")
                .body(mapToDto(productsUseCase.getProductById(id)));
    }

    @GetMapping(produces = "application/json", path = "/products")
    public ResponseEntity<List<ProductResource>> products() {
        return ResponseEntity.ok()
                .header("Access-Control-Allow-Origin", "*")
                .body(mapToDtos(productsUseCase.getProducts()));
    }

    @PostMapping(value = "/save")
    public ResponseEntity <List<ProductResource>> createProducts(@Validated @RequestBody List<ProductResource> productResource) {

        return ResponseEntity.ok()
                .header("Access-Control-Allow-Origin", "*")
                .body(mapToDtos(productsUseCase.saveProducts(mapToDomain(productResource))));
    }

    private List<Product> mapToDomain(List<ProductResource> productResource) {
        return productResource.stream().map(this::mapToDomain).toList();
    }

    private Product mapToDomain(ProductResource productResource) {
        return new Product(
                productResource.id(),
                productResource.name(),
                productResource.description(),
                productResource.price(),
                productResource.quantity()
        );
    }

    private List<ProductResource> mapToDtos(List<Product> products) {
        return products.stream().map(this::mapToDto).toList();
    }

    private ProductResource mapToDto(Product productById) {
        return new ProductResource(
                productById.id(),
                productById.name(),
                productById.description(),
                productById.price(),
                productById.quantity()
        );
    }
}
