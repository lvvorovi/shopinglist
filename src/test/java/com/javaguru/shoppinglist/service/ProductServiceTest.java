package com.javaguru.shoppinglist.service;

import com.javaguru.shoppinglist.dto.ProductDto;
import com.javaguru.shoppinglist.mappers.ProductMapper;
import com.javaguru.shoppinglist.repository.ProductSqlRepository;
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

import java.util.ArrayList;
import java.util.Optional;

import static com.javaguru.shoppinglist.TestProductConstructors.*;
import static org.assertj.core.api.Assertions.assertThatThrownBy;
import static org.mockito.Mockito.*;


@RunWith(MockitoJUnitRunner.class)
public class ProductServiceTest extends TestCase {

    @Rule
    public ExpectedException thrown = ExpectedException.none();
    @Mock
    private ProductSqlRepository productRepository;
    @Mock
    private ProductMapper productMapper;
    @Mock
    private ProductValidationService validationService;
    @InjectMocks
    private ProductService victim;

    @Test
    public void shouldRequestRepoToSaveProduct() {
        Mockito.doNothing().when(validationService).validate(any());
        when(productMapper.toEntity(productDto())).thenReturn(productEntity());
        when(productRepository.save(productEntity())).thenReturn(productEntity());
        when(productMapper.toDto(productEntity())).thenReturn(productDto());
        ProductDto dto = victim.save(productDto());
        verify(validationService).validate(any());
        verify(productRepository).save(any());
        assertEquals(productDto(), dto);
    }

    @Test
    public void shouldRequestRepoToFindByID() {
        when(productRepository.findById(any())).thenReturn(Optional.of(productEntity()));
        when(productMapper.toDto(productEntity())).thenReturn(productDto());
        ProductDto dto = victim.findByID(0L);
        verify(productRepository).findById(any());
        verify(productMapper).toDto(any());
        assertEquals(productDto(), dto);
    }

    @Test
    public void shouldRequestRepoToFindAll() {
        when(productRepository.findAll()).thenReturn(Optional.of(entityList()));
        when(productMapper.toDto(productEntity())).thenReturn(productDto());
        ArrayList<ProductDto> listActual = victim.findAll();
        verify(productRepository).findAll();
        verify(productMapper).toDto(any());
        assertEquals(dtoList(), listActual);
    }

    @Test
    public void shouldRequestRepoToUpdateByID() {
        Mockito.doNothing().when(validationService).validate(any());
        when(productMapper.toDto(productEntity())).thenReturn(productDto());
        when(productRepository.updateById(any(), any())).thenReturn(productEntity());
        ProductDto actualDto = victim.updateByID(0L, productDto());
        verify(productRepository).updateById(any(), any());
        verify(validationService).validate(any());
        verify(productMapper).toDto(any());
        assertEquals(productDto(), actualDto);
    }

    @Test
    public void shouldRequestRepoToDeleteByID() {
        when(productRepository.isById(any())).thenReturn(true);
        victim.deleteByID(10L);
        verify(productRepository).isById(10L);
        verify(productRepository).deleteById(10L);
    }

    @Test
    public void shouldThrowProductNotFoundExceptionWhenFindById() {
        when(productRepository.findById(any())).thenReturn(Optional.empty());
        assertThatThrownBy(() -> victim.findByID(0L))
                .isInstanceOf(ProductNotFoundException.class)
                .hasMessage("Product with ID " + 0L + " not found");
    }
}