package com.javaguru.shoppinglist.domains.products.productService.validation.exceptions;

import com.javaguru.shoppinglist.domains.ValidationException;

public class ProductValidationException extends ValidationException {

    public ProductValidationException(String message) {
        super(message);
    }

}
