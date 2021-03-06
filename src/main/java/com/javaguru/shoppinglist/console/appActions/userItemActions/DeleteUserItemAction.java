package com.javaguru.shoppinglist.console.appActions.userItemActions;

import com.javaguru.shoppinglist.domains.userItems.productListService.ProductListService;
import org.springframework.core.annotation.Order;
import org.springframework.stereotype.Component;

import java.util.Scanner;

@Component
@Order(11)
public class DeleteUserItemAction implements UserItemMenuAction {

    private final ProductListService productListService;

    public DeleteUserItemAction(ProductListService productListService) {
        this.productListService = productListService;
    }

    @Override
    public void execute() {
        Scanner scanner = new Scanner(System.in);
        System.out.println("Enter user ID");

        Long userId = Long.parseLong(scanner.nextLine());

        productListService.deleteAll(userId);
        System.out.println("Basket for user with ID " + userId + " was cleared");
    }

    @Override
    public String getName() {
        return "Remove all products from basket";
    }
}
