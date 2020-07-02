package com.javaguru.shoppinglist;

import com.javaguru.shoppinglist.mappers.ProductMapper;
import com.javaguru.shoppinglist.repository.ProductInMemoryRepository;
import com.javaguru.shoppinglist.repository.ProductRepository;
import com.javaguru.shoppinglist.service.ProductService;
import com.javaguru.shoppinglist.service.validation.ProductValidationService;
import com.javaguru.shoppinglist.service.validation.rules.*;

import java.util.LinkedList;
import java.util.List;

class ShoppingListApplication {

    public static void main(String[] args) {

        ProductRepository productRepository = new ProductInMemoryRepository();

        ProductValidationRule nameValidationRule = new NameValidationRule(productRepository);
        ProductValidationRule priceValidationRule = new PriceValidationRule();
        ProductValidationRule discountValidationRule = new DiscountValidationRule();

        List<ProductValidationRule> validationRuleList = new LinkedList<>();
        validationRuleList.add(nameValidationRule);
        validationRuleList.add(priceValidationRule);
        validationRuleList.add(discountValidationRule);

        ProductValidationService validationService = new ProductValidationService(validationRuleList);

        ProductMapper productMapper = new ProductMapper();

        ProductService productService = new ProductService(productRepository, validationService, productMapper);

        Console console = new Console(productService);
        console.execute();
    }
}
