package com.javaguru.shoppinglist.service.validation;

import com.javaguru.shoppinglist.domain.ProductEntity;
import com.javaguru.shoppinglist.dto.ProductDto;
import com.javaguru.shoppinglist.repository.ProductInMemoryRepository;
import com.javaguru.shoppinglist.repository.ProductRepository;
import com.javaguru.shoppinglist.service.validation.rules.DiscountValidationRule;
import com.javaguru.shoppinglist.service.validation.rules.NameValidationRule;
import com.javaguru.shoppinglist.service.validation.rules.PriceValidationRule;
import com.javaguru.shoppinglist.service.validation.rules.ProductValidationRule;
import org.junit.Test;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.Mockito;

import java.math.BigDecimal;
import java.util.LinkedList;
import java.util.List;

import static org.junit.Assert.*;
import static org.mockito.Mockito.verify;
import static org.mockito.Mockito.when;

public class ProductValidationServiceTest {

    @Mock
    NameValidationRule nameValidationRule;
    @Mock
    DiscountValidationRule discountValidationRule;
    @Mock
    PriceValidationRule priceValidationRule;
    @Mock
    List<ProductValidationRule> validationRules;
    @Mock
    ProductInMemoryRepository productRepository;
    @InjectMocks
    ProductValidationService victim;

/*    @Test
    public void shouldValidateForEachRule() {
        when(
        victim.validate(productDto());
        verify(validationRules).add(new NameValidationRule(productRepository));
        verify(validationRules).add(new DiscountValidationRule());
        verify(validationRules).add(new PriceValidationRule());

    }

    private ProductDto productDto() {
        ProductDto dto = new ProductDto();
        dto.setName("name");
        dto.setPrice(new BigDecimal(100));
        dto.setDiscount(new BigDecimal(10));
        dto.setActualPrice(new BigDecimal(90).setScale(2));
        dto.setId(10L);
        return dto;
    }*/

}