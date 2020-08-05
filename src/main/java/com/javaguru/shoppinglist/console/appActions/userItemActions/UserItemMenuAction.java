package com.javaguru.shoppinglist.console.appActions.userItemActions;

import com.javaguru.shoppinglist.console.MenuAction;

public interface UserItemMenuAction extends MenuAction {

    @Override
    void execute();

    @Override
    String getName();
}
