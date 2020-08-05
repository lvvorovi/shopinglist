package com.javaguru.shoppinglist.domains.products.productService.validation.rules;

import com.javaguru.shoppinglist.domains.products.productDto.ProductDto;

public interface ProductValidationRule {

    void validate(ProductDto productDto);

    default void checkProductNotNull(ProductDto productDto) {
        if (productDto == null) {
            throw new IllegalArgumentException("Product should be not null");
        }
    }

}
