package com.javaguru.shoppinglist;

import com.javaguru.shoppinglist.mappers.ProductMapper;
import com.javaguru.shoppinglist.repository.ProductInMemoryRepository;
import com.javaguru.shoppinglist.repository.ProductRepository;
import com.javaguru.shoppinglist.service.ProductService;
import com.javaguru.shoppinglist.service.validation.ProductValidationService;

class ShoppingListApplication {

    public static void main(String[] args) {

        final ProductRepository productRepository = new ProductInMemoryRepository();
        final ProductMapper productMapper = new ProductMapper();
        final ProductValidationService validationService = new ProductValidationService(productRepository);
        final ProductService productService = new ProductService(productRepository, validationService, productMapper);
        final Console console = new Console(productService);
        console.execute();

    }
}
