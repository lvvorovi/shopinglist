package com.javaguru.shoppinglist.console.appActions.userActions;

import com.javaguru.shoppinglist.domains.users.userService.UserService;
import org.springframework.core.annotation.Order;
import org.springframework.stereotype.Component;

@Component
@Order(6)
public class CreateUserAction implements UserMenuAction {

    private final UserService userService;

    public CreateUserAction(UserService userService) {
        this.userService = userService;
    }

    @Override
    public void execute() {
        System.out.println(userService.save(consoleUserBuilder()));
    }

    @Override
    public String getName() {
        return "Create User";
    }
}
