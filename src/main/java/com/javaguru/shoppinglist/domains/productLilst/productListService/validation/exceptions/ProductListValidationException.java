package com.javaguru.shoppinglist.domains.productLilst.productListService.validation.exceptions;

import com.javaguru.shoppinglist.domains.ValidationException;

abstract class ProductListValidationException extends ValidationException {

    public ProductListValidationException(String message) {
        super(message);
    }
}
