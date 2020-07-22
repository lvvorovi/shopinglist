package com.javaguru.shoppinglist.console;

import com.javaguru.shoppinglist.service.ProductService;
import org.springframework.core.annotation.Order;
import org.springframework.stereotype.Component;

@Component
@Order(1)
public class CreateAction implements MenuAction {

    private final ProductService productService;

    public CreateAction(ProductService productService) {
        this.productService = productService;
    }

    @Override
    public String getName() {
        return "Create Product";
    }

    @Override
    public void execute() {
        System.out.println(productService.save(userProductBuilder()));
    }

}
