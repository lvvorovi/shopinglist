package com.javaguru.shoppinglist.domains.products.productService.validation;

import com.javaguru.shoppinglist.domains.products.productDto.ProductDto;
import com.javaguru.shoppinglist.domains.products.productService.validation.rules.ProductValidationRule;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class ProductValidationService {

    private final List<ProductValidationRule> productValidationRules;

    public ProductValidationService(List<ProductValidationRule> productValidationRules) {
        this.productValidationRules = productValidationRules;
    }

    public void validate(ProductDto dto) {
        for (ProductValidationRule rule : productValidationRules) {
            rule.validate(dto);
        }
    }

}
