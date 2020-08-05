package com.javaguru.shoppinglist.console.appActions.userItemActions;

import com.javaguru.shoppinglist.domains.userItems.UserItemDto;
import com.javaguru.shoppinglist.domains.userItems.productListService.ProductListService;
import org.springframework.core.annotation.Order;
import org.springframework.stereotype.Component;

import java.util.List;
import java.util.Scanner;

@Component
@Order(9)
public class PrintAllUserItemsForUserAction implements UserItemMenuAction {

    private final ProductListService productListService;

    public PrintAllUserItemsForUserAction(ProductListService productListService) {
        this.productListService = productListService;
    }

    @Override
    public void execute() {
        Scanner scanner = new Scanner(System.in);

        System.out.println("Enter user id");
        Long userId = Long.parseLong(scanner.nextLine());

        List<UserItemDto> dtoList = productListService.findByUserId(userId);

        dtoList.forEach(System.out::println);
    }

    @Override
    public String getName() {
        return "Print products from basket";
    }
}
