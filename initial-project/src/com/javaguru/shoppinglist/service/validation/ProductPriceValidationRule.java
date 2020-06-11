package com.javaguru.shoppinglist.service.validation;

import com.javaguru.shoppinglist.domain.Product;
import com.javaguru.shoppinglist.service.validation.exceptions.ProductPriceIllegalException;

import java.math.BigDecimal;

public class ProductPriceValidationRule implements ProductValidationRule{

    @Override
    public void validate(Product product) {
        if ((product.getPrice().compareTo(new BigDecimal(0))) <= 0 ) {
            throw new ProductPriceIllegalException("Price must be greater than 0");
        }
    }
}
