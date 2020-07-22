package com.javaguru.shoppinglist.console;

import org.springframework.core.annotation.Order;
import org.springframework.stereotype.Component;

@Component
@Order(6)
public class ExitAction implements MenuAction {

    @Override
    public void execute() {
        System.exit(0);
    }

    @Override
    public String getName() {
        return "Exit";
    }
}
