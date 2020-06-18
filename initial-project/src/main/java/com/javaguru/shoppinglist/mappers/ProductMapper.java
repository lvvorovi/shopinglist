package com.javaguru.shoppinglist.mappers;

import com.javaguru.shoppinglist.domain.ProductEntity;
import com.javaguru.shoppinglist.dto.ProductDto;

import java.math.BigDecimal;

public class ProductMapper {

    public ProductDto ToDto(ProductEntity entity) {
        ProductDto dto = new ProductDto();
        dto.setId(entity.getId());
        dto.setName(entity.getName());
        dto.setPrice(entity.getPrice());
        dto.setDiscount(entity.getDiscount());
        dto.setCategory(entity.getCategory());
        dto.setDescription(entity.getDescription());
        dto.setActualPrice(entity.getPrice().multiply(new BigDecimal(1).subtract(entity.getDiscount().divide(new BigDecimal(100)))).setScale(2));
        return dto;
    }

    public ProductEntity ToEntity(ProductDto dto) {

        ProductEntity entity = new ProductEntity();
        entity.setId(dto.getId());
        entity.setName(dto.getName());
        entity.setPrice(dto.getPrice());
        entity.setDiscount(dto.getDiscount());
        entity.setCategory(dto.getCategory());
        entity.setDescription(dto.getDescription());

        return entity;
    }

}
