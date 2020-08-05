package com.javaguru.shoppinglist.console.appActions.productActions;

import com.javaguru.shoppinglist.domains.products.productService.ProductService;
import org.springframework.core.annotation.Order;
import org.springframework.stereotype.Component;

@Component
@Order(3)
public class PrintAllProductsAction implements ProductMenuAction {

    private final ProductService productService;

    public PrintAllProductsAction(ProductService productService) {
        this.productService = productService;
    }

    @Override
    public String getName() {
        return "Print all products";
    }

    @Override
    public void execute() {
        productService.findAll().forEach(System.out::println);
    }

}
