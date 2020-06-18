package com.javaguru.shoppinglist.service;

import com.javaguru.shoppinglist.domain.ProductEntity;
import com.javaguru.shoppinglist.dto.ProductDto;
import com.javaguru.shoppinglist.mappers.ProductMapper;
import com.javaguru.shoppinglist.repository.ProductInMemoryRepository;
import com.javaguru.shoppinglist.repository.ProductRepository;
import com.javaguru.shoppinglist.service.validation.ProductValidationService;
import com.javaguru.shoppinglist.service.validation.exceptions.ProductNotFoundException;

import java.math.BigDecimal;
import java.util.LinkedList;
import java.util.List;

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
        ProductEntity entity = productMapper.ToEntity(productDto);
        productRepository.save(entity);
        return productMapper.ToDto(entity);
    }

    public ProductEntity findByID(Long id) {
        return productRepository.findByID(id).orElseThrow(() -> new ProductNotFoundException("Product with such ID not Found"));
    }

    public List<ProductDto> findAll() {
        List<ProductDto> listDto = new LinkedList<>();
        for (ProductEntity entity : productRepository.findAll()) {
            listDto.add(productMapper.ToDto(entity));
        }
        return listDto;
    }

    public void updateNameByID(Long id, String newName) {
        productRepository.findByID(id).orElseThrow(() -> new ProductNotFoundException("Product with such ID not Found"));
        ProductDto productDto = new ProductDto();
        productDto.setName(newName);
        productDto.setPrice(new BigDecimal(1));
        productDto.setDiscount(new BigDecimal(0));
        validationService.validate(productDto);
        productRepository.findByID(id).get().setName(newName);
    }

    public void deleteByID(Long id) {
        productRepository.findByID(id).orElseThrow(() -> new ProductNotFoundException("Product with such ID not Found"));
        productRepository.deleteByID(id);
    }
}
