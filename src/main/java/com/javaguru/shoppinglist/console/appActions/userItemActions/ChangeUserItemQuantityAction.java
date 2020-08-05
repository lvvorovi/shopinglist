package com.javaguru.shoppinglist.console.appActions.userItemActions;

import com.javaguru.shoppinglist.domains.userItems.productListService.ProductListService;
import org.springframework.core.annotation.Order;
import org.springframework.stereotype.Component;

import java.util.Scanner;

@Component
@Order(10)
public class ChangeUserItemQuantityAction implements UserItemMenuAction {

    private final ProductListService productListService;

    public ChangeUserItemQuantityAction(ProductListService productListService) {
        this.productListService = productListService;
    }

    @Override
    public void execute() {
        Scanner scanner = new Scanner(System.in);
        System.out.println("Enter user ID");
        Long userId = Long.parseLong(scanner.nextLine());

        System.out.println("Enter product ID");
        Long productId = Long.parseLong(scanner.nextLine());

        System.out.println("Enter desired amount");
        int quantity = Integer.parseInt(scanner.nextLine());

        System.out.println(productListService.changeQuantity(userId, productId, quantity));
    }

    @Override
    public String getName() {
        return "Change quantity for product in basket";
    }
}
