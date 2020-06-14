package com.javaguru.shoppinglist.service.validation;

import com.javaguru.shoppinglist.domain.Product;
import com.javaguru.shoppinglist.service.validation.exceptions.ProductDiscountIllegalException;

import java.math.BigDecimal;

public class ProductDiscountValidationRule implements ProductValidationRule {

    @Override
    public void validate(Product product) {
        if (product.getDiscount() > 100 || product.getDiscount() < 0) {
            throw new ProductDiscountIllegalException("Discount shall not be greater than 100");
        }
        if (new BigDecimal(20).compareTo(product.getPrice()) > 0 && product.getDiscount() > 0){
            throw new ProductDiscountIllegalException("Discount shall not be used if product price less than 20");
        }
    }
}
