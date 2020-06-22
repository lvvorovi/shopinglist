package com.javaguru.shoppinglist.service.validation.rules;

import com.javaguru.shoppinglist.domain.ProductEntity;
import com.javaguru.shoppinglist.dto.ProductDto;
import com.javaguru.shoppinglist.repository.ProductRepository;
import com.javaguru.shoppinglist.service.validation.exceptions.NameIllegalException;

public class NameValidationRule implements ProductValidationRule {

    private ProductRepository productRepository;

    public NameValidationRule(ProductRepository productRepository) {
        this.productRepository = productRepository;
    }

    @Override
    public void validate(ProductDto productDto) {
        if (productDto.getName() == null) {
            throw new IllegalArgumentException("Name should be not null");
        }
        if (productDto.getName().length() < 3 && productDto.getName().length() > 32) {
            throw new NameIllegalException("Name should be 3-32 characters long");
        }
        for (ProductEntity entry : productRepository.findAll()) {
            //TODO chars to CAPS for comparison
            if (entry.getName().equals(productDto.getName())) {
                throw new NameIllegalException("Name already exist");
            }
        }
    }
}
