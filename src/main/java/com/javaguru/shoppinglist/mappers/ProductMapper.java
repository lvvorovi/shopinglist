package com.javaguru.shoppinglist.mappers;

import com.javaguru.shoppinglist.domain.ProductEntity;
import com.javaguru.shoppinglist.dto.ProductDto;
import org.springframework.stereotype.Service;

import java.math.BigDecimal;
import java.math.RoundingMode;

@Service
public class ProductMapper {

    public ProductDto toDto(ProductEntity entity) {
        ProductDto dto = new ProductDto();
        dto.setId(entity.getId());
        dto.setName(entity.getName());
        dto.setPrice(entity.getPrice());
        dto.setDiscount(entity.getDiscount());
        dto.setSku(entity.getSku());
        dto.setDescription(entity.getDescription());
        dto.setActualPrice(toActualPrice(entity.getPrice(), entity.getDiscount()));
        return dto;
    }

    public ProductEntity toEntity(ProductDto dto) {
        ProductEntity entity = new ProductEntity();
        entity.setId(dto.getId());
        entity.setName(dto.getName());
        entity.setPrice(dto.getPrice());
        entity.setDiscount(dto.getDiscount());
        entity.setSku(dto.getSku());
        entity.setDescription(dto.getDescription());
        return entity;
    }

    private BigDecimal toActualPrice(BigDecimal price, BigDecimal discount) {
        return price.multiply(new BigDecimal(1).subtract(discount
                .divide(new BigDecimal(100), 2, RoundingMode.HALF_EVEN)));
    }
}
