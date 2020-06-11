package com.javaguru.shoppinglist.service.validation;

import com.javaguru.shoppinglist.domain.Product;
import com.javaguru.shoppinglist.repository.ProductRepository;

import java.util.HashSet;
import java.util.Set;

public class ProductValidationService {

    private Set<ProductValidationRule> validationRules = new HashSet<>();


    public ProductValidationService(ProductRepository productRepository) {
        validationRules.add(new ProductNameValidationRule(productRepository));
        validationRules.add(new ProductPriceValidationRule());
        validationRules.add(new ProductDiscountValidationRule());
    }

    public void validate(Product product){
        validationRules.forEach(rule -> rule.validate(product));
    }

}
