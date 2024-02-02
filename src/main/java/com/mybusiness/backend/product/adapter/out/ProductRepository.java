package com.mybusiness.backend.product.adapter.out;

import com.mybusiness.backend.product.adapter.out.entity.ProductEntity;
import org.springframework.data.domain.Sort;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;

public interface ProductRepository extends JpaRepository<ProductEntity, Long> {

    List<ProductEntity> findAllByProductId(String productId);
}
