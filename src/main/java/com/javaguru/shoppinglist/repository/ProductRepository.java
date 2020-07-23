package com.javaguru.shoppinglist.repository;

import com.javaguru.shoppinglist.domain.ProductEntity;

import java.util.List;
import java.util.Optional;

public interface ProductRepository {

    ProductEntity save(ProductEntity entity);

    Optional<ProductEntity> findById(Long ID);

    Optional<List<ProductEntity>> findAll();

    ProductEntity updateById(Long id, ProductEntity entity);

    Boolean deleteById(Long id);

    Boolean isByName(String name);

    Boolean isById(Long id);
}
