package com.javaguru.shoppinglist.repository;

import com.javaguru.shoppinglist.domain.ProductEntity;

import java.util.ArrayList;
import java.util.Optional;

public interface ProductRepository {
    ProductEntity save(ProductEntity product);

    Optional<ProductEntity> findByID(Long ID);

    Optional<ArrayList<ProductEntity>> findAll();

    Boolean isByName(String name);

    Boolean deleteByID(Long id);

    ProductEntity updateById(Long id, ProductEntity entity);

    Boolean isById(Long id);
}
