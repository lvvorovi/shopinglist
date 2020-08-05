package com.javaguru.shoppinglist.console.appActions.productActions;

import com.javaguru.shoppinglist.domains.products.productService.ProductService;
import org.springframework.core.annotation.Order;
import org.springframework.stereotype.Component;

import java.util.Scanner;

@Component
@Order(2)
public class FindProductByIdAction implements ProductMenuAction {

    private final ProductService productService;

    public FindProductByIdAction(ProductService productService) {
        this.productService = productService;
    }

    @Override
    public void execute() {
        Scanner scanner = new Scanner(System.in);
        System.out.println("Enter product ID: ");
        long id = scanner.nextLong();
        System.out.println(productService.findById(id));
    }

    @Override
    public String getName() {
        return "Find product by ID";
    }
}
