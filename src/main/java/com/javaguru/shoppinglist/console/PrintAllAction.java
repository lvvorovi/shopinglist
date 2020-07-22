package com.javaguru.shoppinglist.console;

import com.javaguru.shoppinglist.service.ProductService;
import org.springframework.core.annotation.Order;
import org.springframework.stereotype.Component;

@Component
@Order(3)
public class PrintAllAction implements MenuAction {

    private final ProductService productService;

    public PrintAllAction(ProductService productService) {
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
