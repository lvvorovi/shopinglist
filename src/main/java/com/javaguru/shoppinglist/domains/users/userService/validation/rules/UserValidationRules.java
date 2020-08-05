package com.javaguru.shoppinglist.domains.users.userService.validation.rules;

import com.javaguru.shoppinglist.domains.users.UserDto;
import com.javaguru.shoppinglist.domains.users.userService.validation.exceptions.UserNullException;
import org.springframework.stereotype.Component;

@Component
public interface UserValidationRules {

    void validate(UserDto dto);

    default void notNull(UserDto dto) {
        if (dto == null) {
            throw new UserNullException("User should be not null");
        }
    }

}
