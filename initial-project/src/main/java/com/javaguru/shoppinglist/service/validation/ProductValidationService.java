package com.javaguru.shoppinglist.service.validation;

import com.javaguru.shoppinglist.dto.ProductDto;
import com.javaguru.shoppinglist.service.validation.rules.ProductValidationRule;

import java.util.List;

public class ProductValidationService {

    private final List<ProductValidationRule> validationRuleList;

    public ProductValidationService(List<ProductValidationRule> validationRuleList) {
        this.validationRuleList = validationRuleList;
    }

    public void validate(ProductDto productDto) {
        validationRuleList.forEach(rule -> rule.validate(productDto));
    }

}
