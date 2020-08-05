package com.javaguru.shoppinglist.console.appActions;

import com.javaguru.shoppinglist.console.appActions.productActions.ProductMenuAction;
import org.springframework.core.annotation.Order;
import org.springframework.stereotype.Component;

@Component
@Order(20)
public class ExitAction implements ProductMenuAction {

    @Override
    public void execute() {
        System.exit(0);
    }

    @Override
    public String getName() {
        return "Exit";
    }
}
