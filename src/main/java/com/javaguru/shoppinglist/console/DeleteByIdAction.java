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
    public void execute() {
        Scanner scanner = new Scanner(System.in);
        System.out.println("Enter product id: ");
        long id = scanner.nextLong();
        productService.deleteByID(id);
        System.out.println("product deleted");
    }

    @Override
    public String toString() {
        return "Delete product by ID";
    }
}
