package com.javaguru.shoppinglist;

import com.javaguru.shoppinglist.domain.Product;
import com.javaguru.shoppinglist.service.ProductService;
import com.javaguru.shoppinglist.service.validation.exceptions.ProductDiscountIllegalException;
import com.javaguru.shoppinglist.service.validation.exceptions.ProductNameIllegalException;
import com.javaguru.shoppinglist.service.validation.exceptions.ProductNotFoundException;
import com.javaguru.shoppinglist.service.validation.exceptions.ProductPriceIllegalException;

import java.math.BigDecimal;
import java.util.Scanner;

public class Console {

    ProductService productService = new ProductService();

    private void createProduct(){
        Scanner scanner = new Scanner(System.in);
        System.out.println("Enter product name");
        String name = scanner.nextLine();
        System.out.println("Enter product price");
        BigDecimal price = new BigDecimal(scanner.nextLine());
        System.out.println("Enter product discount");
        float discount = scanner.nextFloat();
        Product product = new Product();
        product.setName(name);
        product.setPrice(price);
        product.setDiscount(discount);
        productService.save(product);
        System.out.println("Product saved with ID: " + product.getId());
    }

    private void findProductByID(){
        Scanner scanner = new Scanner(System.in);
        System.out.println("Enter product id: ");
        long id = scanner.nextLong();
        System.out.println(productService.findProductByID(id));
    }

    private void printAllProducts(){
        for (Product product : productService.getListOfProducts()) {
            System.out.println(product);
        }
    }

    private void editProductNameByID(){
        Scanner scanner = new Scanner(System.in);
        System.out.println("Enter product id: ");
        long id = scanner.nextLong();
        productService.findProductByID(id);
        System.out.println("Enter new name");
        String newName = scanner.next();
        productService.updateProductNameByID(id, newName);
        System.out.println(productService.findProductByID(id));
    }

    private void deleteProductByID() {
        Scanner scanner = new Scanner(System.in);
        System.out.println("Enter product id: ");
        long id = scanner.nextLong();
        productService.deleteProductByID(id);
        System.out.println("product deleted");
    }

    void execute(){
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
                        findProductByID();
                        continue;
                    case 3:
                        printAllProducts();
                        continue;
                    case 4:
                       editProductNameByID();
                        continue;
                    case 5:
                        deleteProductByID();
                        continue;
                    case 6:
                        return;
                }
            } catch (ProductNameIllegalException | ProductPriceIllegalException | ProductNotFoundException | ProductDiscountIllegalException e) {
                System.out.println(e.getMessage());
            } catch (Exception e) {
                e.printStackTrace();
                System.out.println(e.getMessage());
            }
        }
    }

}
