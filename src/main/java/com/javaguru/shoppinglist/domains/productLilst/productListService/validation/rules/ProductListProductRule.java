package com.javaguru.shoppinglist.domains.productLilst.productListService.validation.rules;

import com.javaguru.shoppinglist.domains.productLilst.productListDto.ProductListDto;
import com.javaguru.shoppinglist.domains.productLilst.productListService.validation.exceptions.ProductListProductException;
import org.springframework.stereotype.Component;

@Component
public class ProductListProductRule implements ProductListValidationRule {

    @Override
    public void validate(ProductListDto dto) {
        validateNotNull(dto);

        if (dto.getProduct().equals(null)) {
            throw new ProductListProductException("Product in ProductList should be not null");
        }
    }
}
