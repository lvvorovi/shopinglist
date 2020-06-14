package com.javaguru.shoppinglist.service.validation;

import com.javaguru.shoppinglist.domain.Product;
import com.javaguru.shoppinglist.repository.ProductRepository;
import com.javaguru.shoppinglist.service.validation.exceptions.NameIllegalException;

public class NameValidationRule implements ProductValidationRule {

    private ProductRepository productRepository;

    public NameValidationRule(ProductRepository productRepository) {
        this.productRepository = productRepository;
    }

    @Override
    public void validate(Product product) {
        if (product.getName() == null) {
            throw new IllegalArgumentException("Name should be not null");
        }
        if (product.getName().length() < 3 && product.getName().length() > 32) {
            throw new NameIllegalException("Name should be 3-32 characters long");
        }
        for (Product entry : productRepository.findAll()) {
            if (entry.getName().equals(product.getName())) {
                throw new NameIllegalException("Name already exist");
            }
        }

    }
}
