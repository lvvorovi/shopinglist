package com.javaguru.shoppinglist.console;

import com.javaguru.shoppinglist.dto.ProductDto;
import com.javaguru.shoppinglist.service.ProductService;
import org.springframework.core.annotation.Order;
import org.springframework.stereotype.Component;

import java.math.BigDecimal;
import java.util.Scanner;

@Component
@Order(1)
public class CreateAction implements MenuAction {

    private final ProductService productService;

    public CreateAction(ProductService productService) {
        this.productService = productService;
    }

    @Override
    public void execute() {
        ProductDto productDto = new ProductDto();
        Scanner scanner = new Scanner(System.in);

        System.out.println("Enter product name");
        productDto.setName(scanner.nextLine());

        System.out.println("Enter product price");
        productDto.setPrice(new BigDecimal(scanner.nextLine()));

        System.out.println("Enter product discount in %");
        productDto.setDiscount(new BigDecimal(scanner.nextLine()));

        System.out.println("Enter product description");
        productDto.setDescription(scanner.nextLine());

        System.out.println("Enter product category");
        productDto.setCategory(scanner.nextLine());

        System.out.println("Product saved as: " + productService.save(productDto));
    }

    @Override
    public String toString() {
        return "Create product";
    }
}
