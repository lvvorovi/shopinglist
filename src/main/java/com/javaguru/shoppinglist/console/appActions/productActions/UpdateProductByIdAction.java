package com.javaguru.shoppinglist.console.appActions.productActions;

import com.javaguru.shoppinglist.domains.products.productDto.ProductDto;
import com.javaguru.shoppinglist.domains.products.productService.ProductService;
import org.springframework.core.annotation.Order;
import org.springframework.stereotype.Component;

import java.util.Scanner;

@Component
@Order(4)
public class UpdateProductByIdAction implements ProductMenuAction {

    private final ProductService productService;

    public UpdateProductByIdAction(ProductService productService) {
        this.productService = productService;
    }

    @Override
    public void execute() {
        Scanner scanner = new Scanner(System.in);
        System.out.println("Enter product ID: ");
        long id = Long.parseLong(scanner.nextLine());

        ProductDto dto = consoleProductBuilder();
        dto.setId(id);

        ProductDto updateDto = productService.update(dto);
        System.out.println("Product updated succesfully." + '\n' + updateDto);
    }

    @Override
    public String getName() {
        return "Update product by ID";
    }
}
