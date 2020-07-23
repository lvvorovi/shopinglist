package com.javaguru.shoppinglist.service.validation.rules;

import com.javaguru.shoppinglist.dto.ProductDto;
import com.javaguru.shoppinglist.repository.ProductRepository;
import com.javaguru.shoppinglist.service.validation.exceptions.NameAlreadyExistsException;
import com.javaguru.shoppinglist.service.validation.exceptions.NameIllegalException;
import org.springframework.stereotype.Component;

@Component
public class NameValidationRule implements ProductValidationRule {

    private final ProductRepository productRepository;

    public NameValidationRule(ProductRepository productRepository) {
        this.productRepository = productRepository;
    }

    @Override
    public void validate(ProductDto dto, Boolean ShouldNameBeValidatedForExistence) {
        checkProductNotNull(dto);

        if (dto.getName() == null) {
            throw new IllegalArgumentException("Name should be not null");
        }
        if (dto.getName().length() < 3 || dto.getName().length() > 32) {
            throw new NameIllegalException("Name should be 3-32 characters long");
        }
        if (ShouldNameBeValidatedForExistence && productRepository.isByName(dto.getName())) {
            throw new NameAlreadyExistsException("Name already exist");
        }
    }

    public void validate(ProductDto dto) {
        checkProductNotNull(dto);

        if (dto.getName() == null) {
            throw new IllegalArgumentException("Name should be not null");
        }
        if (dto.getName().length() < 3 || dto.getName().length() > 32) {
            throw new NameIllegalException("Name should be 3-32 characters long");
        }
        if (productRepository.isByName(dto.getName())) {
            throw new NameAlreadyExistsException("Name already exist");
        }
    }
}
