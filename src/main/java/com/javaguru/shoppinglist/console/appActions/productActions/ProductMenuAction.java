package com.javaguru.shoppinglist.console.appActions.productActions;

import com.javaguru.shoppinglist.console.MenuAction;
import com.javaguru.shoppinglist.domains.products.productDto.ProductDto;

import java.math.BigDecimal;
import java.util.Scanner;

public interface ProductMenuAction extends MenuAction {

    @Override
    void execute();

    @Override
    String getName();

    default ProductDto consoleProductBuilder() {
        ProductDto dto = new ProductDto();
        Scanner scanner = new Scanner(System.in);

        System.out.println("Enter product name");
        dto.setName(scanner.nextLine());

        System.out.println("Enter product price");
        dto.setPrice(new BigDecimal(scanner.nextLine()));

        System.out.println("Enter product discount in %");
        dto.setDiscount(new BigDecimal(scanner.nextLine()));

        System.out.println("Enter product SKU");
        dto.setSku(scanner.nextLine());

        System.out.println("Enter product description");
        dto.setDescription(scanner.nextLine());

        return dto;
    }

}
