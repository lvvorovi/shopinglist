package com.javaguru.shoppinglist.console.appActions.userActions;

import com.javaguru.shoppinglist.domains.users.userService.UserService;

import java.util.Scanner;

public class DeleteUserAction implements UserMenuAction {

    private final UserService userService;

    public DeleteUserAction(UserService userService) {
        this.userService = userService;
    }

    @Override
    public void execute() {
        Scanner scanner = new Scanner(System.in);

        System.out.println("Enter user ID: ");
        long id = Long.parseLong(scanner.nextLine());

        userService.deleteById(id);
        System.out.println("User with ID " + id + " deleted successfully.");
    }

    @Override
    public String getName() {
        return "Delete user by id";
    }
}
