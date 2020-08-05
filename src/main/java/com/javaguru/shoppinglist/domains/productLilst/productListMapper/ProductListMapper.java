package com.javaguru.shoppinglist.domains.productLilst.productListMapper;

import com.javaguru.shoppinglist.domains.productLilst.ProductListEntity;
import com.javaguru.shoppinglist.domains.productLilst.productListDto.ProductListDto;
import com.javaguru.shoppinglist.domains.products.ProductEntity;
import com.javaguru.shoppinglist.domains.products.productDto.ProductDto;
import com.javaguru.shoppinglist.domains.products.productMappers.ProductMapper;
import com.javaguru.shoppinglist.domains.users.UserEntity;
import com.javaguru.shoppinglist.domains.users.dto.UserDto;
import com.javaguru.shoppinglist.domains.users.userMappers.UserMapper;
import org.springframework.stereotype.Service;

@Service
public class ProductListMapper {

    private final ProductMapper productMapper;
    private final UserMapper userMapper;

    public ProductListMapper(ProductMapper productMapper, UserMapper userMapper) {
        this.productMapper = productMapper;
        this.userMapper = userMapper;
    }

    public ProductListEntity toEntity(ProductListDto dto) {
        ProductListEntity entity = new ProductListEntity();
        entity.setId(dto.getId());
        UserEntity userEntity = userMapper.toEntity(dto.getUser());
        entity.setUser(userEntity);
        ProductEntity productEntity = productMapper.toEntity(dto.getProduct());
        entity.setProduct(productEntity);
        entity.setQuantity(dto.getQuantity());
        return entity;
    }

    public ProductListDto toDto(ProductListEntity entity) {
        ProductListDto dto = new ProductListDto();
        dto.setId(entity.getId());
        UserDto userDto = userMapper.toDto(entity.getUser());
        dto.setUser(userDto);
        ProductDto productDto = productMapper.toDto(entity.getProduct());
        dto.setProduct(productDto);
        dto.setQuantity(entity.getQuantity());
        return dto;
    }

}
