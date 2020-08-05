package com.javaguru.shoppinglist.domains.userItems.productListService.validation.exceptions;

import com.javaguru.shoppinglist.domains.ValidationException;

abstract class ProductListValidationException extends ValidationException {

    public ProductListValidationException(String message) {
        super(message);
    }
}
