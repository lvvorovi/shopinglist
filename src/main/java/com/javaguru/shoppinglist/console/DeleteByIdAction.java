package com.javaguru.shoppinglist.console;

import com.javaguru.shoppinglist.service.ProductService;
import org.springframework.core.annotation.Order;
import org.springframework.stereotype.Component;

import java.util.Scanner;

@Component
@Order(5)
public class DeleteByIdAction implements MenuAction {

    private final ProductService productService;

    public DeleteByIdAction(ProductService productService) {
        this.productService = productService;
    }

    @Override
    public String getName() {
        return "Delete product by ID";
    }

    @Override
    public void execute() {
        Scanner scanner = new Scanner(System.in);

        System.out.println("Enter product ID: ");
        long id = Long.parseLong(scanner.nextLine());

        if (productService.deleteByID(id)) {
            System.out.println("Product wtih ID " + id + " deleted successfully.");
        } else {
            System.out.println("Product with ID " + id + " was not deleted.");
        }
    }
}
