package com.javaguru.shoppinglist.service.validation.rules;

import com.javaguru.shoppinglist.dto.ProductDto;
import com.javaguru.shoppinglist.service.validation.exceptions.PriceIllegalException;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.mockito.Spy;
import org.mockito.junit.MockitoJUnitRunner;

import java.math.BigDecimal;

import static org.assertj.core.api.Assertions.assertThatCode;
import static org.assertj.core.api.Assertions.assertThatThrownBy;
import static org.mockito.Mockito.verify;

@RunWith(MockitoJUnitRunner.class)
public class PriceValidationRuleTest {

    ProductDto dto = new ProductDto();
    @Spy
    PriceValidationRule victim;

    @Test
    public void shouldThrowPriceNullException() {
        assertThatThrownBy(() -> victim.validate(dto))
                .isInstanceOf(IllegalArgumentException.class)
                .hasMessage("Price should be not null");
    }

    @Test
    public void shouldThrowPriceGreaterThanZeroException() {
        dto.setPrice(new BigDecimal(0));

        assertThatThrownBy(() -> victim.validate(dto))
                .isInstanceOf(PriceIllegalException.class)
                .hasMessage("Price must be greater than 0");

        verify(victim).checkProductNotNull(dto);
    }

    @Test
    public void shouldNotThrowException() {
        dto.setPrice(new BigDecimal(10));

        assertThatCode(() -> victim.validate(dto)).doesNotThrowAnyException();

        verify(victim).checkProductNotNull(dto);
    }

}