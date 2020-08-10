package com.javaguru.shoppinglist.domains.userItems.productListService.validation;

import com.javaguru.shoppinglist.domains.userItems.UserItemDto;
import com.javaguru.shoppinglist.domains.userItems.productListService.validation.rules.ProductListValidationRule;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class ProductListValidationService {

    private final List<ProductListValidationRule> productListValidationRules;

    public ProductListValidationService(List<ProductListValidationRule> productListValidationRules) {
        this.productListValidationRules = productListValidationRules;
    }

    public void validate(UserItemDto dto) {
        productListValidationRules.forEach(rule -> rule.validate(dto));
    }


}
