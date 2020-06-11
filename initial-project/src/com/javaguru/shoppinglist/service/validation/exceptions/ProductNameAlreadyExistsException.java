package com.javaguru.shoppinglist.service.validation.exceptions;

public class ProductNameAlreadyExistsException extends RuntimeException {

    public ProductNameAlreadyExistsException(String message) {
        super(message);
    }
}
