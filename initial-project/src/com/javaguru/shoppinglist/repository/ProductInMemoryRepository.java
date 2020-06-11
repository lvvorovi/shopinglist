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

    public Boolean findByName(String name) {
        for (Product product:repository.values()) {
            if(product.getName().equals(name)){
                return true;
            }
        }
        return false;
    }

    @Override
    public Set<Product> getList() {
        return new HashSet<>(repository.values());
    }

    @Override
    public void deleteByID(Long id) {
        repository.remove(id);
    }
}
