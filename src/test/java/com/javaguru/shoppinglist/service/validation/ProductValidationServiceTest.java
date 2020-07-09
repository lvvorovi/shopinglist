package com.javaguru.shoppinglist.service.validation;

import com.javaguru.shoppinglist.dto.ProductDto;
import com.javaguru.shoppinglist.service.validation.rules.DiscountValidationRule;
import com.javaguru.shoppinglist.service.validation.rules.NameValidationRule;
import com.javaguru.shoppinglist.service.validation.rules.PriceValidationRule;
import com.javaguru.shoppinglist.service.validation.rules.ProductValidationRule;
import org.junit.Before;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.mockito.ArgumentCaptor;
import org.mockito.Captor;
import org.mockito.Mock;
import org.mockito.junit.MockitoJUnitRunner;

import java.math.BigDecimal;
import java.math.RoundingMode;
import java.util.LinkedList;
import java.util.List;

import static org.junit.Assert.assertEquals;
import static org.mockito.Mockito.verify;

@RunWith(MockitoJUnitRunner.class)
public class ProductValidationServiceTest {

    final ProductDto input = productDto();
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

    private ProductDto productDto() {
        ProductDto dto = new ProductDto();
        dto.setName("name");
        dto.setPrice(new BigDecimal(100));
        dto.setDiscount(new BigDecimal(10));
        dto.setActualPrice(new BigDecimal(90).setScale(2, RoundingMode.HALF_EVEN));
        dto.setId(10L);
        return dto;
    }

    @Test
    public void shouldValidateForEachRule() {
        victim.validate(input);

        verify(nameValidationRule).validate(captor.capture());
        verify(discountValidationRule).validate(captor.capture());
        verify(priceValidationRule).validate(captor.capture());

        captor.getAllValues().forEach(product -> assertEquals(input, product));
    }

}