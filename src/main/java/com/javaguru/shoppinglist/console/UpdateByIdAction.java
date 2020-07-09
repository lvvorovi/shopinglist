package com.javaguru.shoppinglist.console;

import com.javaguru.shoppinglist.dto.ProductDto;
import com.javaguru.shoppinglist.service.ProductService;
import org.springframework.core.annotation.Order;
import org.springframework.stereotype.Component;

import java.math.BigDecimal;
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

        ProductDto temporaryDto = new ProductDto();

        System.out.println("Enter product id: ");
        long id = Long.parseLong(scanner.nextLine());
        System.out.println(productService.findByID(id));
        System.out.println("Enter new name");
        temporaryDto.setName(scanner.nextLine());
        System.out.println("Enter new description");
        temporaryDto.setDescription(scanner.nextLine());
        System.out.println("Enter new category");
        temporaryDto.setCategory(scanner.nextLine());
        System.out.println("Enter new price");
        temporaryDto.setPrice(new BigDecimal(scanner.nextLine()));
        System.out.println("Enter new discount");
        temporaryDto.setDiscount(new BigDecimal(scanner.nextLine()));
        System.out.println(productService.updateByID(id, temporaryDto));
    }

    @Override
    public String toString() {
        return "Update product by ID";
    }
}
