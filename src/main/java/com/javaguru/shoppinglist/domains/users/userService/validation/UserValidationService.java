package com.javaguru.shoppinglist.domains.users.userService.validation;

import com.javaguru.shoppinglist.domains.users.dto.UserDto;
import com.javaguru.shoppinglist.domains.users.userService.validation.rules.UserValidationRules;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class UserValidationService {

    private final List<UserValidationRules> userValidationRules;

    public UserValidationService(List<UserValidationRules> userValidationRules) {
        this.userValidationRules = userValidationRules;
    }

    public void validate(UserDto dto) {
        for (UserValidationRules rule : userValidationRules) {
            rule.validate(dto);
        }
    }
}
