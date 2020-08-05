package com.javaguru.shoppinglist.domains.productLilst.productListService.validation.rules;

import com.javaguru.shoppinglist.domains.productLilst.productListDto.ProductListDto;
import com.javaguru.shoppinglist.domains.productLilst.productListService.validation.exceptions.ProductListUserException;
import org.springframework.stereotype.Component;

@Component
public class ProductListUserRule implements ProductListValidationRule {

    @Override
    public void validate(ProductListDto dto) {
        validateNotNull(dto);

        if (dto.getUser() == null) {
            throw new ProductListUserException("User in ProductList should be not null");
        }

    }
}
