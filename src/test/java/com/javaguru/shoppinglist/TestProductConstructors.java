package com.javaguru.shoppinglist;

import com.javaguru.shoppinglist.domains.products.ProductEntity;

import java.math.BigDecimal;
import java.math.RoundingMode;
import java.util.ArrayList;

public class TestProductConstructors {

    public static com.javaguru.shoppinglist.domains.products.productDto.ProductDto productDto() {
        com.javaguru.shoppinglist.domains.products.productDto.ProductDto dto = new com.javaguru.shoppinglist.domains.products.productDto.ProductDto();
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

    public static com.javaguru.shoppinglist.domains.products.productDto.ProductDto productDtoAllValuesTooSmall() {
        com.javaguru.shoppinglist.domains.products.productDto.ProductDto dto = new com.javaguru.shoppinglist.domains.products.productDto.ProductDto();
        dto.setDiscount(new BigDecimal(-2));
        dto.setPrice(new BigDecimal(0));
        dto.setName("ab");
        return dto;
    }

    public static com.javaguru.shoppinglist.domains.products.productDto.ProductDto productDtoAllValuesTooBig() {
        com.javaguru.shoppinglist.domains.products.productDto.ProductDto dto = productDto();
        dto.setDiscount(new BigDecimal(101));
        dto.setName("123456789012345678901234567890123");
        return dto;
    }

    public static com.javaguru.shoppinglist.domains.products.productDto.ProductDto productDtoAllValuesNull() {
        com.javaguru.shoppinglist.domains.products.productDto.ProductDto dto = productDto();
        dto.setDiscount(null);
        dto.setPrice(null);
        dto.setSku(null);
        dto.setName(null);
        dto.setId(null);
        dto.setDescription(null);
        dto.setActualPrice(null);

        return dto;
    }

    public static com.javaguru.shoppinglist.domains.products.productDto.ProductDto productDtoLowPriceNotZeroDiscount() {
        com.javaguru.shoppinglist.domains.products.productDto.ProductDto dto = productDto();
        dto.setPrice(new BigDecimal(10));
        dto.setDiscount(new BigDecimal(1));
        return dto;
    }

    public static com.javaguru.shoppinglist.domains.products.productDto.ProductDto productDtoPriceOneHundredDiscountTen() {
        com.javaguru.shoppinglist.domains.products.productDto.ProductDto dto = productDto();
        dto.setPrice(new BigDecimal(100));
        dto.setDiscount(new BigDecimal(10));
        return dto;
    }

    public static com.javaguru.shoppinglist.domains.products.productDto.ProductDto productDtoPriceTenDiscountZero() {
        com.javaguru.shoppinglist.domains.products.productDto.ProductDto dto = productDto();
        dto.setPrice(new BigDecimal(10));
        dto.setDiscount(new BigDecimal(0));
        return dto;
    }

    public static ArrayList<ProductEntity> entityList() {
        ArrayList<ProductEntity> listEntity = new ArrayList<>();
        listEntity.add(productEntity());
        return listEntity;
    }

    public static ArrayList<com.javaguru.shoppinglist.domains.products.productDto.ProductDto> dtoList() {
        ArrayList<com.javaguru.shoppinglist.domains.products.productDto.ProductDto> listDto = new ArrayList<>();
        listDto.add(productDto());
        return listDto;
    }


    public static com.javaguru.shoppinglist.domains.products.productDto.ProductDto productDtoNull() {
        return null;
    }
}
