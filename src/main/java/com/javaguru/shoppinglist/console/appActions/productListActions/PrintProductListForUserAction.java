package com.javaguru.shoppinglist.console.appActions.productListActions;

import com.javaguru.shoppinglist.domains.productLilst.productListDto.ProductListDto;
import com.javaguru.shoppinglist.domains.productLilst.productListService.ProductListService;
import org.springframework.core.annotation.Order;
import org.springframework.stereotype.Component;

import java.util.List;
import java.util.Scanner;

@Component
@Order(11)
public class PrintProductListForUserAction implements ProductListAction {

    private final ProductListService productListService;

    public PrintProductListForUserAction(ProductListService productListService) {
        this.productListService = productListService;
    }

    @Override
    public void execute() {
        Scanner scanner = new Scanner(System.in);

        System.out.println("Enter user id");
        Long userId = Long.parseLong(scanner.nextLine());

        List<ProductListDto> dtoList = productListService.findByUserId(userId);

        dtoList.forEach(System.out::println);
    }

    @Override
    public String getName() {
        return "Print products from basket";
    }
}
