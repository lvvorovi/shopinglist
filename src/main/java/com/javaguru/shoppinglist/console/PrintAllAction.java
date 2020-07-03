package com.javaguru.shoppinglist.console;

import com.javaguru.shoppinglist.dto.ProductDto;
import com.javaguru.shoppinglist.service.ProductService;
import org.springframework.core.annotation.Order;
import org.springframework.stereotype.Component;

@Component
@Order(3)
public class PrintAllAction implements MenuAction {

    private final ProductService productService;

    public PrintAllAction(ProductService productService) {
        this.productService = productService;
    }

    @Override
    public void execute() {
        for (ProductDto productDto : productService.findAll()) {
            System.out.println(productDto);
        }
    }

    @Override
    public String toString() {
        return "Print all products";
    }
}
