package com.javaguru.shoppinglist.console.appActions.userItemActions;

import com.javaguru.shoppinglist.domains.userItems.productListService.ProductListService;
import org.springframework.core.annotation.Order;
import org.springframework.stereotype.Component;

import java.util.Scanner;

@Component
@Order(10)
public class AddUserItemAction implements UserItemMenuAction {

    ProductListService productListService;

    public AddUserItemAction(ProductListService productListService) {
        this.productListService = productListService;
    }

    @Override
    public void execute() {
        Scanner scanner = new Scanner(System.in);

        System.out.println("Enter user id");
        Long userId = Long.parseLong(scanner.nextLine());

        System.out.println("Enter product id");
        Long productId = Long.parseLong(scanner.nextLine());

        System.out.println("Enter amount");
        int quantity = Integer.parseInt(scanner.nextLine());

        System.out.println(productListService.save(userId, productId, quantity));
    }

    @Override
    public String getName() {
        return "Add product to basket";
    }
}
