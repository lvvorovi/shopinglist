package com.javaguru.shoppinglist.service.validation.exceptions;

public class ProductNameIllegalException extends RuntimeException {

    public ProductNameIllegalException() {
    }

    public ProductNameIllegalException(String message) {
        super(message);
    }
}
