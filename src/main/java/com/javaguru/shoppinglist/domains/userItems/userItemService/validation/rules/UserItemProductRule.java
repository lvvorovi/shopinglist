package com.javaguru.shoppinglist.domains.userItems.productListService.validation.rules;

import com.javaguru.shoppinglist.domains.userItems.UserItemDto;
import com.javaguru.shoppinglist.domains.userItems.productListService.validation.exceptions.ProductListProductException;
import org.springframework.stereotype.Component;

@Component
public class ProductListProductRule implements ProductListValidationRule {

    @Override
    public void validate(UserItemDto dto) {
        validateNotNull(dto);

        if (dto.getProduct().equals(null)) {
            throw new ProductListProductException("Product in ProductList should be not null");
        }
    }
}
