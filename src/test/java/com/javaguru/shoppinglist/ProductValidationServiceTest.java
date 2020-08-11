/*
package com.javaguru.shoppinglist;

import com.javaguru.shoppinglist.domains.products.productDto.ProductDto;
import com.javaguru.shoppinglist.domains.products.productService.validation.ProductValidationService;
import com.javaguru.shoppinglist.domains.products.productService.validation.rules.DiscountValidationRule;
import com.javaguru.shoppinglist.domains.products.productService.validation.rules.NameValidationRule;
import com.javaguru.shoppinglist.domains.products.productService.validation.rules.PriceValidationRule;
import com.javaguru.shoppinglist.domains.products.productService.validation.rules.ProductValidationRule;
import org.junit.Before;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.mockito.ArgumentCaptor;
import org.mockito.Captor;
import org.mockito.Mock;
import org.mockito.junit.MockitoJUnitRunner;

import java.util.LinkedList;
import java.util.List;

import static com.javaguru.shoppinglist.TestProductConstructors.productDto;
import static org.junit.Assert.assertEquals;
import static org.mockito.Mockito.verify;

@RunWith(MockitoJUnitRunner.class)
public class ProductValidationServiceTest {

    @Mock
    NameValidationRule nameValidationRule;
    @Mock
    DiscountValidationRule discountValidationRule;
    @Mock
    PriceValidationRule priceValidationRule;
    ProductValidationService victim;
    @Captor
    private ArgumentCaptor<ProductDto> captor;

    @Before
    public void setUp() {
        List<ProductValidationRule> validationRules = new LinkedList<>();
        validationRules.add(nameValidationRule);
        validationRules.add(discountValidationRule);
        validationRules.add(priceValidationRule);
        victim = new ProductValidationService(validationRules);
    }

    @Test
    public void shouldValidateForEachRule() {
        victim.validate(productDto());

        verify(nameValidationRule).validate(captor.capture());
        verify(discountValidationRule).validate(captor.capture());
        verify(priceValidationRule).validate(captor.capture());

        captor.getAllValues().forEach(product -> assertEquals(productDto(), product));
    }

}*/
