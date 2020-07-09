package com.javaguru.shoppinglist.service.validation.rules;

import com.javaguru.shoppinglist.dto.ProductDto;
import com.javaguru.shoppinglist.service.validation.exceptions.PriceIllegalException;
import org.springframework.stereotype.Component;

import java.math.BigDecimal;

@Component
public class PriceValidationRule implements ProductValidationRule {

    @Override
    public void validate(ProductDto productDto) {
        checkProductNotNull(productDto);

        if (productDto.getPrice() == null) {
            throw new IllegalArgumentException("Price should be not null");
        }
        if ((productDto.getPrice().compareTo(new BigDecimal(0))) <= 0) {
            throw new PriceIllegalException("Price must be greater than 0");
        }
    }

}