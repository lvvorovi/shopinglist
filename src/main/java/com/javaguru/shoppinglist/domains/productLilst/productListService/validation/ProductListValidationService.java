package com.javaguru.shoppinglist.domains.productLilst.productListService.validation;

import com.javaguru.shoppinglist.domains.productLilst.productListDto.ProductListDto;
import com.javaguru.shoppinglist.domains.productLilst.productListService.validation.rules.ProductListValidationRule;
import org.springframework.stereotype.Service;

import java.util.ArrayList;

@Service
public class ProductListValidationService {

    private final ArrayList<ProductListValidationRule> productListValidationRules;

    public ProductListValidationService(ArrayList<ProductListValidationRule> productListValidationRules) {
        this.productListValidationRules = productListValidationRules;
    }

    public void validate(ProductListDto dto) {
        productListValidationRules.forEach(rule -> validate(dto));
    }


}
