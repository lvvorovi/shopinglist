package com.javaguru.shoppinglist.service;

import com.javaguru.shoppinglist.domain.Product;
import com.javaguru.shoppinglist.repository.ProductInMemoryRepository;
import com.javaguru.shoppinglist.repository.ProductRepository;
import com.javaguru.shoppinglist.service.validation.ProductValidationService;
import com.javaguru.shoppinglist.service.validation.exceptions.ProductNotFoundException;

import java.math.BigDecimal;
import java.util.List;

public class ProductService {

    private ProductRepository productRepository = new ProductInMemoryRepository();
    private ProductValidationService validationService = new ProductValidationService(productRepository);

    public Long save(Product product) {
        validationService.validate(product);
        return productRepository.save(product).getId();
    }

    public Product findByID(Long id) {
        return productRepository.findByID(id).orElseThrow(() -> new ProductNotFoundException("Product with such ID not Found"));
    }

    public List<Product> findAll() {
        return productRepository.findAll();
    }

    public void updateNameByID(Long id, String newName) {
        productRepository.findByID(id).orElseThrow(() -> new ProductNotFoundException("Product with such ID not Found"));
        Product product = new Product();
        product.setName(newName);
        product.setPrice(new BigDecimal(1));
        product.setDiscount(new BigDecimal(0));
        validationService.validate(product);
        productRepository.findByID(id).get().setName(newName);
    }

    public void deleteByID(Long id) {
        productRepository.findByID(id).orElseThrow(() -> new ProductNotFoundException("Product with such ID not Found"));
        productRepository.deleteByID(id);
    }
}
