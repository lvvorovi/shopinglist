package com.javaguru.shoppinglist.service;

import com.javaguru.shoppinglist.domain.Product;
import com.javaguru.shoppinglist.repository.ProductInMemoryRepository;
import com.javaguru.shoppinglist.repository.ProductRepository;
import com.javaguru.shoppinglist.service.validation.ProductValidationService;
import com.javaguru.shoppinglist.service.validation.exceptions.ProductNotFoundException;
import java.util.Set;

public class ProductService {

    private ProductRepository productRepository = new ProductInMemoryRepository();
    private ProductValidationService validationService = new ProductValidationService(productRepository);

    public Long save(Product product){
        validationService.validate(product);
        Product createdProduct = productRepository.save(product);
        return createdProduct.getId();
    }

    public Product findProductByID(Long id) {
        return productRepository.findByID(id).orElseThrow(() -> new ProductNotFoundException("Product with such ID not Found"));
    }

    public Boolean findByName(String name){
        return productRepository.findByName(name);
    }

    public Set<Product> getListOfProducts(){
        return productRepository.getList();
    }

    public void updateProductNameByID(Long id, String newName){
        productRepository.findByID(id).orElseThrow(() -> new ProductNotFoundException("Product with such ID not Found"));
        productRepository.findByID(id).get().setName(newName);

    }

    public void deleteProductByID(Long id) {
        productRepository.findByID(id).orElseThrow(() -> new ProductNotFoundException("Product with such ID not Found"));
        productRepository.deleteByID(id);
    }
}
