package com.javaguru.shoppinglist.service;

import com.javaguru.shoppinglist.domain.ProductEntity;
import com.javaguru.shoppinglist.dto.ProductDto;
import com.javaguru.shoppinglist.mappers.ProductMapper;
import com.javaguru.shoppinglist.repository.ProductRepository;
import com.javaguru.shoppinglist.service.validation.ProductValidationService;
import com.javaguru.shoppinglist.service.validation.exceptions.ProductNotFoundException;
import org.springframework.stereotype.Service;

import java.util.ArrayList;

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
        ProductEntity entity = productRepository.save(productMapper.toEntity(productDto));
        return productMapper.toDto(entity);
    }

    public ProductDto findByID(Long id) {
        ProductEntity entity = productRepository.findByID(id)
                .orElseThrow(() -> new ProductNotFoundException("Product with ID " + id + " not found"));
        return productMapper.toDto(entity);
    }

    public ArrayList<ProductDto> findAll() {
        ArrayList<ProductEntity> entityList = productRepository.findAll()
                .orElseThrow(() -> new ProductNotFoundException("No Products found"));
        ArrayList<ProductDto> dtoList = new ArrayList<>();
        entityList.forEach(entity -> dtoList.add(productMapper.toDto(entity)));
        return dtoList;
    }

    public ProductDto updateByID(Long id, ProductDto dto) {
        validationService.validate(dto);
        ProductEntity updatedEntity = productRepository.updateById(id, productMapper.toEntity(dto));
        return productMapper.toDto(updatedEntity);
    }

    public Boolean deleteByID(Long id) {
        try {
            if (!productRepository.isById(id)) {
                throw new ProductNotFoundException("Product with ID " + id + " not found");
            }
        } catch (NullPointerException e) {
            e.printStackTrace();
        }
        return productRepository.deleteByID(id);
    }
}
