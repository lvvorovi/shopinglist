package com.javaguru.shoppinglist.domains.userItems.productListService.validation.rules;

import com.javaguru.shoppinglist.domains.userItems.UserItemDto;
import com.javaguru.shoppinglist.domains.userItems.productListService.validation.exceptions.ProductListUserException;
import org.springframework.stereotype.Component;

@Component
public class ProductListUserRule implements ProductListValidationRule {

    @Override
    public void validate(UserItemDto dto) {
        validateNotNull(dto);

        if (dto.getUser() == null) {
            throw new ProductListUserException("User in ProductList should be not null");
        }

    }
}
