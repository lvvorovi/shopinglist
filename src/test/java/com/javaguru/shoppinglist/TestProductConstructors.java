package com.javaguru.shoppinglist;

import com.javaguru.shoppinglist.domain.ProductEntity;
import com.javaguru.shoppinglist.dto.ProductDto;

import java.math.BigDecimal;
import java.math.RoundingMode;
import java.util.ArrayList;

public class TestProductConstructors {

    public static ProductDto productDto() {
        ProductDto dto = new ProductDto();
        dto.setName("name");
        dto.setPrice(new BigDecimal(100));
        dto.setDiscount(new BigDecimal(10));
        dto.setSku("100");
        dto.setActualPrice(new BigDecimal(90).setScale(2, RoundingMode.HALF_EVEN));
        dto.setId(10L);
        dto.setDescription("description");
        return dto;
    }

    public static ProductEntity productEntity() {
        ProductEntity entity = new ProductEntity();
        entity.setName("name");
        entity.setPrice(new BigDecimal(100));
        entity.setDiscount(new BigDecimal(10));
        entity.setId(10L);
        entity.setSku("100");
        entity.setDescription("description");
        return entity;
    }

    public static ProductDto productDtoAllValuesTooSmall() {
        ProductDto dto = new ProductDto();
        dto.setDiscount(new BigDecimal(-2));
        dto.setPrice(new BigDecimal(0));
        dto.setName("ab");
        return dto;
    }

    public static ProductDto productDtoAllValuesTooBig() {
        ProductDto dto = productDto();
        dto.setDiscount(new BigDecimal(101));
        dto.setName("123456789012345678901234567890123");
        return dto;
    }

    public static ProductDto productDtoAllValuesNull() {
        ProductDto dto = productDto();
        dto.setDiscount(null);
        dto.setPrice(null);
        dto.setSku(null);
        dto.setName(null);
        dto.setId(null);
        dto.setDescription(null);
        dto.setActualPrice(null);

        return dto;
    }

    public static ProductDto productDtoLowPriceNotZeroDiscount() {
        ProductDto dto = productDto();
        dto.setPrice(new BigDecimal(10));
        dto.setDiscount(new BigDecimal(1));
        return dto;
    }

    public static ProductDto productDtoPriceOneHundredDiscountTen() {
        ProductDto dto = productDto();
        dto.setPrice(new BigDecimal(100));
        dto.setDiscount(new BigDecimal(10));
        return dto;
    }

    public static ProductDto productDtoPriceTenDiscountZero() {
        ProductDto dto = productDto();
        dto.setPrice(new BigDecimal(10));
        dto.setDiscount(new BigDecimal(0));
        return dto;
    }

    public static ArrayList<ProductEntity> entityList() {
        ArrayList<ProductEntity> listEntity = new ArrayList<>();
        listEntity.add(productEntity());
        return listEntity;
    }

    public static ArrayList<ProductDto> dtoList() {
        ArrayList<ProductDto> listDto = new ArrayList<>();
        listDto.add(productDto());
        return listDto;
    }


    public static ProductDto productDtoNull() {
        return null;
    }
}
