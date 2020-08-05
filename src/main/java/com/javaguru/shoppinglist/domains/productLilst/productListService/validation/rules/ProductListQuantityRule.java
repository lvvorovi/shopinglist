package com.javaguru.shoppinglist.domains.productLilst.productListService.validation.rules;

import com.javaguru.shoppinglist.domains.productLilst.productListDto.ProductListDto;
import com.javaguru.shoppinglist.domains.productLilst.productListService.validation.exceptions.ProductListQuantityException;
import org.springframework.stereotype.Component;

@Component
public class ProductListQuantityRule implements ProductListValidationRule {

    @Override
    public void validate(ProductListDto dto) {
        validateNotNull(dto);

        Integer quantity = dto.getQuantity();
        if (quantity == null) {
            throw new ProductListQuantityException("Quantity for ProductList should be not null");
        }
        if (quantity < 1) {
            throw new ProductListQuantityException("Quantity for ProductList should be at least 1");
        }
    }
}
