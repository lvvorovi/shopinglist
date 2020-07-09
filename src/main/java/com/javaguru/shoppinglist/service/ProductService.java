package com.javaguru.shoppinglist.service;

import com.javaguru.shoppinglist.domain.ProductEntity;
import com.javaguru.shoppinglist.dto.ProductDto;
import com.javaguru.shoppinglist.mappers.ProductMapper;
import com.javaguru.shoppinglist.repository.ProductRepository;
import com.javaguru.shoppinglist.service.validation.ProductValidationService;
import com.javaguru.shoppinglist.service.validation.exceptions.ProductNotFoundException;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;

@Service
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
        ProductEntity entity = productRepository.findByID(id)
                .orElseThrow(() -> new ProductNotFoundException("Product with ID " + id + " not Found"));
        return productMapper.toDto(entity);
    }

    public List<ProductDto> findAll() {
        List<ProductDto> listDto = new ArrayList<>();
        for (ProductEntity entity : productRepository.findAll()) {
            listDto.add(productMapper.toDto(entity));
        }
        return listDto;
    }

    public ProductDto updateByID(Long id, ProductDto dto) {
        validationService.validate(dto);
        ProductEntity updatedEntity = productRepository.findByID(id)
                .orElseThrow(() -> new ProductNotFoundException("Product with ID " + id + " not Found"));
        updatedEntity.setName(dto.getName());
        updatedEntity.setDiscount(dto.getDiscount());
        updatedEntity.setCategory(dto.getCategory());
        updatedEntity.setPrice(dto.getPrice());
        updatedEntity.setDescription(dto.getDescription());
        return productMapper.toDto(updatedEntity);
    }

    public void deleteByID(Long id) {
        productRepository.findByID(id)
                .orElseThrow(() -> new ProductNotFoundException("Product with ID " + id + " not Found"));
        productRepository.deleteByID(id);
    }
}
