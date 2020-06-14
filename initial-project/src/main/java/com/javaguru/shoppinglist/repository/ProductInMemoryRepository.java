package com.javaguru.shoppinglist.repository;

import com.javaguru.shoppinglist.domain.Product;

import java.util.*;

public class ProductInMemoryRepository implements ProductRepository {

    private final Map<Long, Product> repository = new HashMap<>();
    private Long productIdSequence = 0L;

    public ProductInMemoryRepository() {
    }

    @Override
    public Product save(Product product) {
        product.setId(productIdSequence++);
        repository.put(product.getId(), product);
        return product;
    }

    @Override
    public Optional<Product> findByID(Long id) {
        return Optional.ofNullable(repository.get(id));
    }

    @Override
    public List<Product> findAll() {
        return new LinkedList<>(repository.values());
    }

    @Override
    public void deleteByID(Long id) {
        repository.remove(id);
    }
}
