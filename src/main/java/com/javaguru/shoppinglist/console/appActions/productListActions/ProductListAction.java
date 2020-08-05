package com.javaguru.shoppinglist.console.appActions.productListActions;

import com.javaguru.shoppinglist.console.MenuAction;

public interface ProductListAction extends MenuAction {

    @Override
    void execute();

    @Override
    String getName();
}
