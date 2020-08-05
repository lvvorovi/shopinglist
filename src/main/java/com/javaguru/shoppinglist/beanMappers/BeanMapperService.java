package com.javaguru.shoppinglist.beanMappers;

import com.javaguru.shoppinglist.domains.productLilst.productListMapper.ProductListMapper;
import com.javaguru.shoppinglist.domains.products.productMappers.ProductMapper;
import com.javaguru.shoppinglist.domains.users.userMappers.UserMapper;
import org.springframework.stereotype.Component;

@Component
public class BeanMapperService {

    private final UserMapper userMapper;
    private final ProductMapper productMapper;
    private final ProductListMapper productListMapper;

    public BeanMapperService(UserMapper userMapper, ProductMapper productMapper, ProductListMapper productListMapper) {
        this.userMapper = userMapper;
        this.productMapper = productMapper;
        this.productListMapper = productListMapper;
    }

    public UserMapper getUserMapper() {
        return userMapper;
    }

    public ProductMapper getProductMapper() {
        return productMapper;
    }

    public ProductListMapper getProductListMapper() {
        return productListMapper;
    }

}
