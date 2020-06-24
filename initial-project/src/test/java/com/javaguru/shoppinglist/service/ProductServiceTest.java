package com.javaguru.shoppinglist.service;

import com.javaguru.shoppinglist.domain.ProductEntity;
import com.javaguru.shoppinglist.dto.ProductDto;
import com.javaguru.shoppinglist.mappers.ProductMapper;
import com.javaguru.shoppinglist.repository.ProductInMemoryRepository;
import com.javaguru.shoppinglist.service.validation.ProductValidationService;

import com.javaguru.shoppinglist.service.validation.exceptions.ProductNotFoundException;
import junit.framework.TestCase;
import org.junit.Rule;
import org.junit.Test;
import org.junit.rules.ExpectedException;
import org.junit.runner.RunWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.Mockito;
import org.mockito.junit.MockitoJUnitRunner;

import java.math.BigDecimal;
import java.math.RoundingMode;
import java.util.*;

import static org.assertj.core.api.Assertions.assertThatThrownBy;
import static org.mockito.Mockito.*;

@RunWith(MockitoJUnitRunner.class)
public class ProductServiceTest extends TestCase {

    @Mock
    private ProductInMemoryRepository productRepository;
    @Mock
    private ProductMapper productMapper;
    @Mock
    private ProductValidationService validationService;
    @InjectMocks
    private ProductService victim;
    @Rule
    public ExpectedException thrown = ExpectedException.none();

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

    private List<ProductEntity> listEntity() {
        List<ProductEntity> listEntity = new LinkedList<>();
        listEntity.add(productEntity());
        return listEntity;
    }

    private List<ProductDto> listDto() {
        List<ProductDto> listDto = new LinkedList<>();
        listDto.add(productDto());
        return listDto;
    }

    private ProductDto updatedNameDto() {
        ProductDto dto = productDto();
        dto.setName("newName");
        return dto;
    }

    private ProductEntity updatedNameEntity() {
        ProductEntity entity = productEntity();
        entity.setName("newName");
        return entity;
    }

    @Test
    public void shouldSaveProduct() {
        Mockito.doNothing().when(validationService).validate(any());
        when(productMapper.toEntity(productDto())).thenReturn(productEntity());
        when(productMapper.toDto(productEntity())).thenReturn(productDto());
        ProductDto dto = victim.save(productDto());
        verify(validationService).validate(any());
        verify(productRepository).save(any());
        assertEquals(productDto(), dto);
    }

    @Test
    public void shouldFindByID() {
        when(productRepository.findByID(any())).thenReturn(Optional.of(productEntity()));
        when(productMapper.toDto(productEntity())).thenReturn(productDto());
        ProductDto dto = victim.findByID(10L);
        verify(productRepository).findByID(any());
        verify(productMapper).toDto(any());
        assertEquals(productDto(), dto);
    }

    @Test
    public void shouldFindAll() {
        when(productRepository.findAll()).thenReturn(listEntity());
        when(productMapper.toDto(any())).thenReturn(productDto());
        List<ProductDto> listActual = victim.findAll();
        verify(productRepository).findAll();
        verify(productMapper).toDto(any());
        assertEquals(listDto(), listActual);
    }

    @Test
    public void shouldUpdateNameByID() {
        when(productRepository.findByID(any())).thenReturn(Optional.of(productEntity()));
        Mockito.doNothing().when(validationService).validate(any());
        when(productMapper.toDto(updatedNameEntity())).thenReturn(updatedNameDto());
        ProductDto actualDto = victim.updateNameByID(0L, "newName");
        assertEquals(updatedNameDto(), actualDto);
        verify(productRepository).findByID(any());
        verify(validationService).validate(any());
        verify(productMapper).toDto(any());
    }

    @Test
    public void shouldRequestRepoToDeleteByID() {
        when(productRepository.findByID(10L)).thenReturn(Optional.of(productEntity()));
        victim.deleteByID(10L);
        verify(productRepository).findByID(10L);
        verify(productRepository).deleteByID(10L);
    }

    @Test
    public void shouldThrowProductNotFoundExceptionWhenFindById() {
        when(productRepository.findByID(any())).thenReturn(Optional.ofNullable(null));

        assertThatThrownBy(() -> victim.findByID(any())).
                isInstanceOf(ProductNotFoundException.class).
                hasMessage("Product with such ID not Found");

    }
}