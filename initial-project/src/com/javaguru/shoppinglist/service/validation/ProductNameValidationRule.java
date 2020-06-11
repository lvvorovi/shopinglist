package com.javaguru.shoppinglist.service.validation;

import com.javaguru.shoppinglist.domain.Product;
import com.javaguru.shoppinglist.repository.ProductInMemoryRepository;
import com.javaguru.shoppinglist.repository.ProductRepository;
import com.javaguru.shoppinglist.service.ProductService;
import com.javaguru.shoppinglist.service.validation.exceptions.ProductNameAlreadyExistsException;
import com.javaguru.shoppinglist.service.validation.exceptions.ProductNameIllegalException;

import java.util.ArrayList;
import java.util.List;

public class ProductNameValidationRule implements ProductValidationRule {

    private ProductRepository productRepository;

    public ProductNameValidationRule(ProductRepository productRepository) {
        this.productRepository = productRepository;
    }

    @Override
    public void validate(Product product) {
        if (product.getName() == null){
            throw new IllegalArgumentException("Name should be not null");
        }
        if (product.getName().length() < 3 && product.getName().length() > 32){
            throw new ProductNameIllegalException("Name should be 3-32 characters long");
        }
        for (Product entry : productRepository.getList()) {
            if (entry.getName().equals(product.getName())){
                throw new ProductNameIllegalException("Name already exists");
            }
        }

    }
}
