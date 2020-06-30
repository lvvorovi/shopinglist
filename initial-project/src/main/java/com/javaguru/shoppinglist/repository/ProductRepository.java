package com.javaguru.shoppinglist.repository;

import com.javaguru.shoppinglist.domain.ProductEntity;

import java.util.List;
import java.util.Optional;

public interface ProductRepository {

    void save(ProductEntity product);

    Optional<ProductEntity> findByID(Long ID);

    List<ProductEntity> findAll();

    void deleteByID(Long id);

}
