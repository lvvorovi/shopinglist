package com.javaguru.shoppinglist.service.validation;

import com.javaguru.shoppinglist.domain.Product;
import com.javaguru.shoppinglist.service.validation.exceptions.DiscountIllegalException;

import java.math.BigDecimal;

public class DiscountValidationRule implements ProductValidationRule {

    @Override
    public void validate(Product product) {
        if (product.getDiscount().compareTo(new BigDecimal(100)) > 0
                || product.getDiscount().compareTo(new BigDecimal(0)) < 0) {
            throw new DiscountIllegalException("Discount shall not be less than 0 or greater than 100");
        }
        if (new BigDecimal(20).compareTo(product.getPrice()) > 0
                && product.getDiscount().compareTo(new BigDecimal(0)) > 0) {
            throw new DiscountIllegalException("Discount shall be 0 if product price less than 20$");
        }
    }
}
