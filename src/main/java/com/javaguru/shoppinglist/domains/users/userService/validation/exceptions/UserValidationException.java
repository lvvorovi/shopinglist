package com.javaguru.shoppinglist.domains.users.userService.validation.exceptions;

import com.javaguru.shoppinglist.domains.ValidationException;

public class UserValidationException extends ValidationException {

    public UserValidationException(String message) {
        super(message);
    }
}
