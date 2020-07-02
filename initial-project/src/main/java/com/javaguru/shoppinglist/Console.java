package com.javaguru.shoppinglist;

import com.javaguru.shoppinglist.dto.ProductDto;
import com.javaguru.shoppinglist.service.ProductService;
import com.javaguru.shoppinglist.service.validation.exceptions.*;

import java.math.BigDecimal;
import java.util.Scanner;

public class Console {

    private final ProductService productService;

    public Console(ProductService productService) {
        this.productService = productService;
    }

    private void createProduct() {
        Scanner scanner = new Scanner(System.in);
        System.out.println("Enter product name");
        String name = scanner.nextLine();
        System.out.println("Enter product price");
        BigDecimal price = new BigDecimal(scanner.nextLine());
        System.out.println("Enter product discount in %");
        BigDecimal discount = scanner.nextBigDecimal();
        ProductDto productDto = new ProductDto();
        productDto.setName(name);
        productDto.setPrice(price);
        productDto.setDiscount(discount);
        System.out.println(productService.save(productDto));
    }

    private void findByID() {
        Scanner scanner = new Scanner(System.in);
        System.out.println("Enter product id: ");
        long id = scanner.nextLong();
        System.out.println(productService.findByID(id));
    }

    private void printAll() {
        for (ProductDto productDto : productService.findAll()) {
            System.out.println(productDto);
        }
    }

    private void updateNameByID() {
        Scanner scanner = new Scanner(System.in);
        System.out.println("Enter product id: ");
        long id = scanner.nextLong();
        productService.findByID(id);
        System.out.println("Enter new name");
        String newName = scanner.next();
        System.out.println(productService.updateNameByID(id, newName));
    }

    private void deleteByID() {
        Scanner scanner = new Scanner(System.in);
        System.out.println("Enter product id: ");
        long id = scanner.nextLong();
        productService.deleteByID(id);
        System.out.println("product deleted");
    }

    void execute() {
        Scanner scanner = new Scanner(System.in);

        while (true) {
            try {
                System.out.println("1. Create product");
                System.out.println("2. Find product by id");
                System.out.println("3. Print all products");
                System.out.println("4. Edit product name by id");
                System.out.println("5. Delete product by id");
                System.out.println("6. Exit");
                int userInput = Integer.parseInt(scanner.nextLine());
                switch (userInput) {
                    case 1:
                        createProduct();
                        continue;
                    case 2:
                        findByID();
                        continue;
                    case 3:
                        printAll();
                        continue;
                    case 4:
                        updateNameByID();
                        continue;
                    case 5:
                        deleteByID();
                        continue;
                    case 6:
                        return;
                }
            } catch (ValidationException e) {
                System.out.println(e.getMessage());
            } catch (Exception e) {
                e.printStackTrace();
                System.out.println(e.getMessage());
            }
        }
    }
}
