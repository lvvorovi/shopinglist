package com.javaguru.shoppinglist.domains;

import com.javaguru.shoppinglist.domains.products.productService.validation.exceptions.ProductValidationException;

public class WrongMenuInputException extends ProductValidationException {

    public WrongMenuInputException(String message) {
        super(message);
    }
}
