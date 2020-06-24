package com.javaguru.shoppinglist.service.validation.rules;

import com.javaguru.shoppinglist.dto.ProductDto;
import com.javaguru.shoppinglist.service.validation.exceptions.PriceIllegalException;

import java.math.BigDecimal;

public class PriceValidationRule implements ProductValidationRule {

    @Override
    public void validate(ProductDto productDto) {
        checkProductNotNull(productDto);

        if (productDto.getPrice() == null) {
            throw new IllegalArgumentException("Price should be not null");
        } else if ((productDto.getPrice().compareTo(new BigDecimal(0))) <= 0) {
            throw new PriceIllegalException("Price must be greater than 0");
        }
    }

}
