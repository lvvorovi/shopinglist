package com.javaguru.shoppinglist.service;

import com.javaguru.shoppinglist.domain.ProductEntity;
import com.javaguru.shoppinglist.dto.ProductDto;
import com.javaguru.shoppinglist.mappers.ProductMapper;
import com.javaguru.shoppinglist.repository.ProductRepository;
import com.javaguru.shoppinglist.service.validation.ProductValidationService;
import com.javaguru.shoppinglist.service.validation.exceptions.ProductNotFoundException;

import java.math.BigDecimal;
import java.util.LinkedList;
import java.util.List;
import java.util.Optional;

public class ProductService {

    final ProductRepository productRepository;
    final ProductValidationService validationService;
    final ProductMapper productMapper;

    public ProductService(ProductRepository productRepository, ProductValidationService validationService, ProductMapper productMapper) {
        this.productRepository = productRepository;
        this.validationService = validationService;
        this.productMapper = productMapper;
    }

    public ProductDto save(ProductDto productDto) {
        validationService.validate(productDto);
        ProductEntity entity = productMapper.toEntity(productDto);
        productRepository.save(entity);
        return productMapper.toDto(entity);
    }

    public ProductDto findByID(Long id) {
        return productMapper.toDto(productRepository.findByID(id).
                orElseThrow(() -> new ProductNotFoundException("Product with such ID not Found")));
    }

    public List<ProductDto> findAll() {
        List<ProductDto> listDto = new LinkedList<>();
        for (ProductEntity entity : productRepository.findAll()) {
            listDto.add(productMapper.toDto(entity));
        }
        return listDto;
    }

    public ProductDto updateNameByID(Long id, String newName) {
        //Переписал логику метода во время написания теста
        ProductEntity updatedEntity = productRepository.findByID(id).orElseThrow(() -> new ProductNotFoundException("Product with such ID not Found"));
        //В тесте мы выносили обьявление новой переменной и ее логики в отдельный метод. Тут так же нужно поступить с productDto или это относится только к тестам?
        ProductDto productDto = new ProductDto();
        productDto.setName(newName);
        productDto.setPrice(new BigDecimal(1));
        productDto.setDiscount(new BigDecimal(0));
        validationService.validate(productDto);
        updatedEntity.setName(newName);
        return productMapper.toDto(updatedEntity);
    }

    public void deleteByID(Long id) {
        productRepository.findByID(id).orElseThrow(() -> new ProductNotFoundException("Product with such ID not Found"));
        productRepository.deleteByID(id);
    }
}
