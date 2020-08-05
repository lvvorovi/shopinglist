package com.javaguru.shoppinglist.domains.products.productService.validation.rules;

import com.javaguru.shoppinglist.domains.products.ProductEntity;
import com.javaguru.shoppinglist.domains.products.productDto.ProductDto;
import com.javaguru.shoppinglist.domains.products.productRepository.ProductRepository;
import com.javaguru.shoppinglist.domains.products.productService.validation.exceptions.NameAlreadyExistsException;
import com.javaguru.shoppinglist.domains.products.productService.validation.exceptions.NameIllegalException;
import org.springframework.stereotype.Component;

@Component
public class NameValidationRule implements ProductValidationRule {

    private final ProductRepository productRepository;

    public NameValidationRule(ProductRepository productRepository) {
        this.productRepository = productRepository;
    }

    public void validate(ProductDto dto) {
        checkProductNotNull(dto);
        if (dto.getName() == null) {
            throw new IllegalArgumentException("Name should be not null");
        }
        if (dto.getName().length() < 3 || dto.getName().length() > 32) {
            throw new NameIllegalException("Name should be 3-32 characters long");
        }
        ProductEntity entity = productRepository.findByName(dto.getName());
        if (entity != null && !entity.getId().equals(dto.getId())) {
            throw new NameAlreadyExistsException("Name already exists");
        }
    }
}
