package com.javaguru.shoppinglist.domains.userItems.productListService.validation.rules;

import com.javaguru.shoppinglist.domains.userItems.UserItemDto;
import com.javaguru.shoppinglist.domains.userItems.productListService.validation.exceptions.ProductListNullException;

public interface ProductListValidationRule {

    void validate(UserItemDto dto);

    default void validateNotNull(UserItemDto dto) {
        if (dto == null) {
            throw new ProductListNullException("ProductList should not be null");
        }
    }

}
