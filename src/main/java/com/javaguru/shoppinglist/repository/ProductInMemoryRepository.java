package com.javaguru.shoppinglist.repository;

import com.javaguru.shoppinglist.domain.ProductEntity;
import org.springframework.context.annotation.Profile;
import org.springframework.stereotype.Repository;

import java.util.*;

@Repository
@Profile("inmemory")
public class ProductInMemoryRepository implements ProductRepository {

    private final Map<Long, ProductEntity> repository = new HashMap<>();
    private Long productIdSequence = 0L;

    @Override
    public ProductEntity save(ProductEntity product) {
        product.setId(productIdSequence++);
        return repository.put(product.getId(), product);
    }

    @Override
    public Optional<ProductEntity> findByID(Long id) {
        return Optional.ofNullable(repository.get(id));
    }

    @Override
    public Optional<ArrayList<ProductEntity>> findAll() {
        ArrayList<ProductEntity> enttityList = (ArrayList<ProductEntity>)repository.values();
        return Optional.of(enttityList);
    }

    @Override
    public Boolean isByName(String name) {
        for (ProductEntity entry : repository.values()) {
            if (entry.getName().equals(name)) {
                return true;
            }
        }
        return false;
    }

    @Override
    public Boolean deleteByID(Long id) {
        for (ProductEntity entry : repository.values()) {
            if (entry.getId().equals(id)) {
                repository.remove(id);
                return true;
            }
        }
        return false;
    }

    @Override
    public ProductEntity updateById(Long id, ProductEntity entity) {
        return null;
    }

    @Override
    public Boolean isById(Long id) {
        return null;
    }
}
