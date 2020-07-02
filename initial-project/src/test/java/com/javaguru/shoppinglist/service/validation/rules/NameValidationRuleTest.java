package com.javaguru.shoppinglist.service.validation.rules;

import com.javaguru.shoppinglist.domain.ProductEntity;
import com.javaguru.shoppinglist.dto.ProductDto;
import com.javaguru.shoppinglist.repository.ProductInMemoryRepository;
import org.junit.Rule;
import org.junit.Test;
import org.junit.rules.ExpectedException;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.Mockito;

import java.math.BigDecimal;
import java.util.LinkedList;
import java.util.List;

import static org.mockito.Mockito.verify;
import static org.mockito.Mockito.when;

public class NameValidationRuleTest {

    @Mock
    ProductInMemoryRepository productRepository;
    @InjectMocks
    NameValidationRule victim;
    @Rule
    public ExpectedException thrown = ExpectedException.none();

/*    @Test
    public void shouldThrowNameValidationExceptionDueToNullPointer() {
        when(productRepository.findAll()).thenReturn(listEntity());
        ProductDto dto = new ProductDto();
        dto.setName("name");
        dto.setPrice(new BigDecimal(100));
        dto.setDiscount(new BigDecimal(10));
        dto.setActualPrice(new BigDecimal(90).setScale(2));
        dto.setId(10L);
        //Mockito.doNothing().when(productRepository.findAll());
        //when(productRepository.findAll()).thenReturn(productDtoNullName())
        //TODO thrown.expectMessage("Name should be not null");
        victim.validate(dto);
        thrown.expect(NullPointerException.class);
    }*/

/*    private ProductDto productDtoNullName() {
        ProductDto dto = new ProductDto();
        dto.setName("name");
        dto.setPrice(new BigDecimal(100));
        dto.setDiscount(new BigDecimal(10));
        dto.setActualPrice(new BigDecimal(90).setScale(2));
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
    private List<ProductEntity> listEntity() {
        List<ProductEntity> listEntity = new LinkedList<>();
        listEntity.add(productEntity());
        return listEntity;
    }*/

/*    @Test
    public void shouldThrowNameValidationExceptionDueToNameTooShort() {

    }*/

}