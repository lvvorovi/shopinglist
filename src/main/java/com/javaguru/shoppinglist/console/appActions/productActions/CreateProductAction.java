package com.javaguru.shoppinglist.console.appActions.productActions;

import com.javaguru.shoppinglist.domains.products.productService.ProductService;
import org.springframework.core.annotation.Order;
import org.springframework.stereotype.Component;

@Component
@Order(1)
public class CreateProductAction implements ProductMenuAction {

    private final ProductService productService;

    public CreateProductAction(ProductService productService) {
        this.productService = productService;
    }

    @Override
    public String getName() {
        return "Create Product";
    }

    @Override
    public void execute() {
        System.out.println(productService.save(consoleProductBuilder()));
    }

}
