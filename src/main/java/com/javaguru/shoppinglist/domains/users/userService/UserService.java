package com.javaguru.shoppinglist.domains.users.userService;

import com.javaguru.shoppinglist.domains.users.UserEntity;
import com.javaguru.shoppinglist.domains.users.UserDto;
import com.javaguru.shoppinglist.domains.users.userMappers.UserMapper;
import com.javaguru.shoppinglist.domains.users.userRepository.UserHibernateRepository;
import com.javaguru.shoppinglist.domains.users.userService.validation.UserValidationService;
import com.javaguru.shoppinglist.domains.users.userService.validation.exceptions.UserNotFoundException;
import org.springframework.stereotype.Service;

@Service
public class UserService {

    private final UserHibernateRepository userRepository;
    private final UserValidationService validationService;
    private final UserMapper userMapper;

    public UserService(UserHibernateRepository userRepository,
                       UserValidationService validationService,
                       UserMapper userMapper) {
        this.userRepository = userRepository;
        this.validationService = validationService;
        this.userMapper = userMapper;
    }

    public UserDto save(UserDto dto) {
        validationService.validate(dto);
        return userMapper.toDto(userRepository.save(userMapper.toEntity(dto)));
    }

    public UserDto findByName(String name) {
        return userMapper.toDto(userRepository.findByName(name)
                .orElseThrow(() -> new UserNotFoundException("User with name " + name + " not found")));
    }

    public UserDto updateById(UserDto dto) {
        validationService.validate(dto);
        UserEntity entity = userRepository.findById(dto.getId())
                .orElseThrow(() -> new UserNotFoundException("User with id " + dto.getId() + " not found"));
        entity.setName(dto.getName());
        entity.setEmail(dto.getEmail());
        entity.setPassword(dto.getPassword());
        entity.setPhone(dto.getPhone());
        return userMapper.toDto(userRepository.update(entity));
    }

    public void deleteById(Long id) {
        UserEntity entity = userRepository.findById(id)
                .orElseThrow(() -> new UserNotFoundException("User with id " + id + " not found"));
        userRepository.delete(entity);
    }

    public UserDto findById(Long id) {
        return userMapper.toDto(userRepository.findById(id)
                .orElseThrow(() -> new UserNotFoundException("User with id " + id + " not found")));
    }

    public Boolean isById(Long id) {
        return userRepository.isById(id);
    }

}
