package com.javaguru.shoppinglist.service.validation;

import com.javaguru.shoppinglist.dto.ProductDto;
import com.javaguru.shoppinglist.repository.ProductRepository;
import com.javaguru.shoppinglist.service.validation.rules.DiscountValidationRule;
import com.javaguru.shoppinglist.service.validation.rules.NameValidationRule;
import com.javaguru.shoppinglist.service.validation.rules.PriceValidationRule;
import com.javaguru.shoppinglist.service.validation.rules.ProductValidationRule;

import java.util.List;

public class ProductValidationService {

    private List<ProductValidationRule> validationRules;

    public ProductValidationService(List<ProductValidationRule> validationRules, ProductRepository productRepository) {
        this.validationRules = validationRules;
        validationRules.add(new NameValidationRule(productRepository));
        validationRules.add(new PriceValidationRule());
        validationRules.add(new DiscountValidationRule());
    }

    public void validate(ProductDto productDto) {
        validationRules.forEach(rule -> rule.validate(productDto));
    }

}
