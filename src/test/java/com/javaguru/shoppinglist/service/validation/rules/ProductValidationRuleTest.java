package com.javaguru.shoppinglist.service.validation.rules;

import org.junit.Test;

import static com.javaguru.shoppinglist.TestProductConstructors.productDto;
import static com.javaguru.shoppinglist.TestProductConstructors.productDtoNull;
import static org.assertj.core.api.Assertions.assertThatCode;
import static org.assertj.core.api.Assertions.assertThatThrownBy;

public class ProductValidationRuleTest {

    final ProductValidationRule victim = new PriceValidationRule();

    @Test
    public void shouldThrowNullProductException() {
        assertThatThrownBy(() -> victim.checkProductNotNull(productDtoNull()))
                .isInstanceOf(IllegalArgumentException.class)
                .hasMessage("Product should be not null");
    }

    @Test
    public void shouldNotThrowException() {
        assertThatCode(() -> victim.checkProductNotNull(productDto()))
                .doesNotThrowAnyException();
    }
}