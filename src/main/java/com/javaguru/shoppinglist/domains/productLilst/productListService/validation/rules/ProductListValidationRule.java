package com.javaguru.shoppinglist.domains.productLilst.productListService.validation.rules;

import com.javaguru.shoppinglist.domains.productLilst.productListDto.ProductListDto;
import com.javaguru.shoppinglist.domains.productLilst.productListService.validation.exceptions.ProductListNullException;

public interface ProductListValidationRule {

    void validate(ProductListDto dto);

    default void validateNotNull(ProductListDto dto) {
        if (dto == null) {
            throw new ProductListNullException("ProductList should not be null");
        }
    }

}
