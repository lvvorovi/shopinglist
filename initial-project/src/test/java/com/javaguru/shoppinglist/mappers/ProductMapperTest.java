package com.javaguru.shoppinglist.mappers;

import com.javaguru.shoppinglist.domain.ProductEntity;
import com.javaguru.shoppinglist.dto.ProductDto;
import org.junit.Test;

import java.math.BigDecimal;
import java.math.RoundingMode;

import static org.junit.Assert.assertEquals;

public class ProductMapperTest {

    private ProductMapper victim = new ProductMapper();

    private ProductDto productDto() {
        ProductDto dto = new ProductDto();
        dto.setName("name");
        dto.setPrice(new BigDecimal(100));
        dto.setDiscount(new BigDecimal(10));
        dto.setActualPrice(new BigDecimal(90).setScale(2, RoundingMode.HALF_EVEN));
        dto.setId(10L);
        return dto;
    }

    private ProductEntity productEntity() {
        ProductEntity entity = new ProductEntity();
        entity.setName("name");
        entity.setPrice(new BigDecimal(100));
        entity.setDiscount(new BigDecimal(10));
        entity.setId(10L);
        return entity;
    }

    @Test
    public void shouldMapEntityToDto() {
        assertEquals(productDto(), victim.toDto(productEntity()));
    }

    @Test
    public void shouldMapDtoToEntity() {
        assertEquals(productEntity(), victim.toEntity(productDto()));
    }

}