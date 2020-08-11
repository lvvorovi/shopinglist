package com.javaguru.shoppinglist;


import com.javaguru.shoppinglist.domains.products.productMappers.ProductMapper;
import org.junit.jupiter.api.Test;

import static com.javaguru.shoppinglist.TestProductConstructors.productDto;
import static com.javaguru.shoppinglist.TestProductConstructors.productEntity;
import static org.junit.jupiter.api.Assertions.assertEquals;

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