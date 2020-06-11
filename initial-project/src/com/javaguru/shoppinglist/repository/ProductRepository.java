package com.javaguru.shoppinglist.repository;

import com.javaguru.shoppinglist.domain.Product;

import java.util.Optional;
import java.util.Set;

public interface ProductRepository {

    Product save(Product product);

    Optional<Product> findByID(Long ID);

    Set<Product> getList();

    void deleteByID(Long id);

    Boolean findByName(String name);


}
