package com.javaguru.shoppinglist.service.validation.exceptions;

public class ProductPriceIllegalException extends RuntimeException {

    public ProductPriceIllegalException() {
    }

    public ProductPriceIllegalException(String message) {
        super(message);
    }
}
