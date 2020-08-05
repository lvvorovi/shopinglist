package com.javaguru.shoppinglist.console.appActions.userActions;

import com.javaguru.shoppinglist.console.MenuAction;
import com.javaguru.shoppinglist.domains.users.dto.UserDto;

import java.util.Scanner;

public interface UserMenuAction extends MenuAction {

    @Override
    void execute();

    @Override
    String getName();

    default UserDto consoleUserBuilder() {
        UserDto dto = new UserDto();
        Scanner scanner = new Scanner(System.in);

        System.out.println("Enter user name");
        dto.setName(scanner.nextLine());

        System.out.println("Enter user email");
        dto.setEmail(scanner.nextLine());

        System.out.println("Enter user password");
        dto.setPassword(scanner.nextLine());

        return dto;
    }

}
