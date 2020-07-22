package com.javaguru.shoppinglist.mappers;

import org.junit.Test;

import static com.javaguru.shoppinglist.TestProductConstructors.productDto;
import static com.javaguru.shoppinglist.TestProductConstructors.productEntity;
import static org.junit.Assert.assertEquals;

public class ProductMapperTest {

    private final ProductMapper victim = new ProductMapper();


    @Test
    public void shouldMapEntityToDto() {
        assertEquals(productDto(), victim.toDto(productEntity()));
    }

    @Test
    public void shouldMapDtoToEntity() {
        assertEquals(productEntity(), victim.toEntity(productDto()));
    }

}