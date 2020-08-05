package com.javaguru.shoppinglist;

import com.javaguru.shoppinglist.domains.products.productService.validation.exceptions.PriceIllegalException;
import com.javaguru.shoppinglist.domains.products.productService.validation.rules.PriceValidationRule;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.mockito.Spy;
import org.mockito.junit.MockitoJUnitRunner;

import static com.javaguru.shoppinglist.TestProductConstructors.*;
import static org.assertj.core.api.Assertions.assertThatCode;
import static org.assertj.core.api.Assertions.assertThatThrownBy;
import static org.mockito.Mockito.verify;

@RunWith(MockitoJUnitRunner.class)
public class PriceValidationRuleTest {

    @Spy
    PriceValidationRule victim;

    @Test
    public void shouldThrowPriceNullException() {
        assertThatThrownBy(() -> victim.validate(productDtoAllValuesNull()))
                .isInstanceOf(IllegalArgumentException.class)
                .hasMessage("Price should be not null");
    }

    @Test
    public void shouldThrowPriceGreaterThanZeroException() {
        assertThatThrownBy(() -> victim.validate(productDtoAllValuesTooSmall()))
                .isInstanceOf(PriceIllegalException.class)
                .hasMessage("Price must be greater than 0");

        verify(victim).checkProductNotNull(productDtoAllValuesTooSmall());
    }

    @Test
    public void shouldNotThrowException() {
        assertThatCode(() -> victim.validate(productDto())).doesNotThrowAnyException();

        verify(victim).checkProductNotNull(productDto());
    }

}