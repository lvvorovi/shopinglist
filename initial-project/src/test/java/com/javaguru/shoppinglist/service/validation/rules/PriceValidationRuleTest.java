package com.javaguru.shoppinglist.service.validation.rules;

import com.javaguru.shoppinglist.dto.ProductDto;
import com.javaguru.shoppinglist.service.validation.exceptions.PriceIllegalException;
import org.junit.Test;

import java.math.BigDecimal;

import static org.assertj.core.api.Assertions.assertThatCode;
import static org.assertj.core.api.Assertions.assertThatThrownBy;

public class PriceValidationRuleTest {

    ProductDto dto = new ProductDto();

    PriceValidationRule victim = new PriceValidationRule();

    @Test
    public void shouldThrowPriceNullException() {
        assertThatThrownBy(() -> victim.validate(dto)).
                isInstanceOf(IllegalArgumentException.class).
                hasMessage("Price should be not null");

    }

    @Test
    public void shouldThrowPriceGreaterThanZeroException() {
        dto.setPrice(new BigDecimal(0));

        assertThatThrownBy(() -> victim.validate(dto)).
                isInstanceOf(PriceIllegalException.class).
                hasMessage("Price must be greater than 0");

    }

    @Test
    public void shouldNotThrowException() {
        dto.setPrice(new BigDecimal(10));

        assertThatCode(() -> victim.validate(dto)).doesNotThrowAnyException();

    }

}