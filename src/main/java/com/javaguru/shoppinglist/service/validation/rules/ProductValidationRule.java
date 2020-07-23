package com.javaguru.shoppinglist.service.validation.rules;

import com.javaguru.shoppinglist.dto.ProductDto;

public interface ProductValidationRule {

    void validate(ProductDto productDto);

    void validate(ProductDto productDto, Boolean ShouldNameBeValidatedForExistence);

    default void checkProductNotNull(ProductDto productDto) {
        if (productDto == null) {
            throw new IllegalArgumentException("Product should be not null");
        }
    }

}
