package com.javaguru.shoppinglist.console.appActions.productActions;

import com.javaguru.shoppinglist.domains.products.productService.ProductService;
import org.springframework.core.annotation.Order;
import org.springframework.stereotype.Component;

import java.util.Scanner;

@Component
@Order(5)
public class DeleteProductByIdAction implements ProductMenuAction {

    private final ProductService productService;

    public DeleteProductByIdAction(ProductService productService) {
        this.productService = productService;
    }

    @Override
    public void execute() {
        Scanner scanner = new Scanner(System.in);

        System.out.println("Enter product ID: ");
        long id = Long.parseLong(scanner.nextLine());

        productService.deleteById(id);
        System.out.println("Product with ID " + id + " deleted successfully.");
    }

    @Override
    public String getName() {
        return "Delete product by ID";
    }
}
