package com.javaguru.shoppinglist.console.appActions.userActions;

import com.javaguru.shoppinglist.domains.users.dto.UserDto;
import com.javaguru.shoppinglist.domains.users.userService.UserService;
import org.springframework.core.annotation.Order;
import org.springframework.stereotype.Component;

import java.util.Scanner;

@Component
@Order(7)
public class UpdateUserByIdAction implements UserMenuAction {

    private final UserService userService;

    public UpdateUserByIdAction(UserService userService) {
        this.userService = userService;
    }

    @Override
    public void execute() {
        Scanner scanner = new Scanner(System.in);
        System.out.println("Enter user id");
        Long id = Long.parseLong(scanner.nextLine());

        UserDto dto = consoleUserBuilder();

        dto.setId(id);

        System.out.println(userService.updateById(dto));

    }

    @Override
    public String getName() {
        return "Update User by id";
    }
}
