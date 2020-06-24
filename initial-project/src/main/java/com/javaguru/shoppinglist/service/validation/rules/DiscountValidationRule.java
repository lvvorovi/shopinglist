package com.javaguru.shoppinglist.service.validation.rules;

import com.javaguru.shoppinglist.dto.ProductDto;
import com.javaguru.shoppinglist.service.validation.exceptions.DiscountIllegalException;

import java.math.BigDecimal;

public class DiscountValidationRule implements ProductValidationRule {

    @Override
    public void validate(ProductDto productDto) {
        checkProductNotNull(productDto);

        if (productDto.getDiscount() == null) {
            throw new IllegalArgumentException("Discount should be not null");
        }
        if (productDto.getDiscount().compareTo(new BigDecimal(100)) > 0
                || productDto.getDiscount().compareTo(new BigDecimal(0)) < 0) {
            throw new DiscountIllegalException("Discount shall not be less than 0 or greater than 100");
        }
        if (new BigDecimal(20).compareTo(productDto.getPrice()) > 0
                && productDto.getDiscount().compareTo(new BigDecimal(0)) > 0) {
            throw new DiscountIllegalException("Discount shall be 0 if product price less than 20$");
        }
    }
}
