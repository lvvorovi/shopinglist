package com.javaguru.shoppinglist.repository;

import com.javaguru.shoppinglist.domain.ProductEntity;

import java.util.*;

public class ProductInMemoryRepository implements ProductRepository {

    private final Map<Long, ProductEntity> repository = new HashMap<>();
    private Long productIdSequence = 0L;

    @Override
    public void save(ProductEntity product) {
        product.setId(productIdSequence++);
        repository.put(product.getId(), product);
    }

    @Override
    public Optional<ProductEntity> findByID(Long id) {
        return Optional.ofNullable(repository.get(id));
    }

    @Override
    public List<ProductEntity> findAll() {
        return new LinkedList<>(repository.values());
    }

    @Override
    public void deleteByID(Long id) {
        repository.remove(id);
    }
}
