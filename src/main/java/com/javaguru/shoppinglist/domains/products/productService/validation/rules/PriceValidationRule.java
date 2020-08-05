package com.javaguru.shoppinglist.domains.products.productService.validation.rules;

import com.javaguru.shoppinglist.domains.products.productDto.ProductDto;
import com.javaguru.shoppinglist.domains.products.productService.validation.exceptions.PriceIllegalException;
import org.springframework.stereotype.Component;

import java.math.BigDecimal;

@Component
public class PriceValidationRule implements ProductValidationRule {

    @Override
    public void validate(ProductDto dto) {
        checkProductNotNull(dto);

        if (dto.getPrice() == null) {
            throw new IllegalArgumentException("Price should be not null");
        }
        if ((dto.getPrice().compareTo(new BigDecimal(0))) <= 0) {
            throw new PriceIllegalException("Price must be greater than 0");
        }
    }

}
