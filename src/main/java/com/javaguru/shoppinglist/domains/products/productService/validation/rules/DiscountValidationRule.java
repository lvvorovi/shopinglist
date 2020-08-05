package com.javaguru.shoppinglist.domains.products.productService.validation.rules;

import com.javaguru.shoppinglist.domains.products.productDto.ProductDto;
import com.javaguru.shoppinglist.domains.products.productService.validation.exceptions.DiscountIllegalException;
import org.springframework.stereotype.Component;

import java.math.BigDecimal;

@Component
public class DiscountValidationRule implements ProductValidationRule {

    @Override
    public void validate(ProductDto dto) {
        checkProductNotNull(dto);

        if (dto.getDiscount() == null) {
            throw new IllegalArgumentException("Discount should be not null");
        }
        if (dto.getDiscount().compareTo(new BigDecimal(100)) > 0
                || dto.getDiscount().compareTo(new BigDecimal(0)) < 0) {
            throw new DiscountIllegalException("Discount shall not be less than 0 or greater than 100");
        }
        if (new BigDecimal(20).compareTo(dto.getPrice()) > 0
                && dto.getDiscount().compareTo(new BigDecimal(0)) > 0) {
            throw new DiscountIllegalException("Discount shall be 0 if product price less than 20$");
        }
    }
}
