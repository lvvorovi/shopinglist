package com.javaguru.shoppinglist.console;

import com.javaguru.shoppinglist.dto.ProductDto;
import com.javaguru.shoppinglist.service.ProductService;
import org.springframework.core.annotation.Order;
import org.springframework.stereotype.Component;

import java.util.Scanner;

@Component
@Order(4)
public class UpdateByIdAction implements MenuAction {

    private final ProductService productService;

    public UpdateByIdAction(ProductService productService) {
        this.productService = productService;
    }

    @Override
    public void execute() {
        Scanner scanner = new Scanner(System.in);
        System.out.println("Enter product ID: ");
        long id = Long.parseLong(scanner.nextLine());

        ProductDto dto = productService.updateByID(id, userProductBuilder());
        System.out.println("Product updated succesfully." + '\n' + dto);
    }

    @Override
    public String getName() {
        return "Update product by ID";
    }
}
