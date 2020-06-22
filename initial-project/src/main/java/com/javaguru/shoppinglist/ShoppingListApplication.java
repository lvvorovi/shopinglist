package com.javaguru.shoppinglist;

import com.javaguru.shoppinglist.mappers.ProductMapper;
import com.javaguru.shoppinglist.repository.ProductInMemoryRepository;
import com.javaguru.shoppinglist.repository.ProductRepository;
import com.javaguru.shoppinglist.service.ProductService;
import com.javaguru.shoppinglist.service.validation.ProductValidationService;
import com.javaguru.shoppinglist.service.validation.rules.ProductValidationRule;

import java.util.LinkedList;
import java.util.List;

class ShoppingListApplication {

    public static void main(String[] args) {

        ProductRepository productRepository = new ProductInMemoryRepository();
        ProductMapper productMapper = new ProductMapper();
        List<ProductValidationRule> validationRuleList = new LinkedList<>();
        ProductValidationService validationService = new ProductValidationService(validationRuleList, productRepository);
        ProductService productService = new ProductService(productRepository, validationService, productMapper);
        Console console = new Console(productService);
        console.execute();

    }
}
