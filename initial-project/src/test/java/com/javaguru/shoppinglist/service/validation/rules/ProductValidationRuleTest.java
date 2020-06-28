package com.javaguru.shoppinglist.service.validation.rules;

import com.javaguru.shoppinglist.dto.ProductDto;
import org.junit.Test;

import static org.assertj.core.api.Assertions.assertThatCode;
import static org.assertj.core.api.Assertions.assertThatThrownBy;

public class ProductValidationRuleTest {

    ProductValidationRule victim = new PriceValidationRule();

    ProductDto dto;

    @Test
    public void shouldThrowNullProductException() {

        assertThatThrownBy(() -> victim.checkProductNotNull(dto)).
                isInstanceOf(IllegalArgumentException.class).
                hasMessage("Product should be not null");

    }

    @Test
    public void shouldNotThrowException() {
        dto = new ProductDto();

        assertThatCode(() -> victim.checkProductNotNull(dto)).
                doesNotThrowAnyException();
    }
}