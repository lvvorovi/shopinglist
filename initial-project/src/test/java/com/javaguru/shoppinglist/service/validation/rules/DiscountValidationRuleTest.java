package com.javaguru.shoppinglist.service.validation.rules;

import com.javaguru.shoppinglist.dto.ProductDto;
import com.javaguru.shoppinglist.service.validation.exceptions.DiscountIllegalException;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.mockito.Spy;
import org.mockito.junit.MockitoJUnitRunner;

import java.math.BigDecimal;

import static org.assertj.core.api.Assertions.assertThatCode;
import static org.assertj.core.api.Assertions.assertThatThrownBy;
import static org.mockito.Mockito.times;
import static org.mockito.Mockito.verify;

@RunWith(MockitoJUnitRunner.class)
public class DiscountValidationRuleTest {

    @Spy
    DiscountValidationRule victim;

    final ProductDto dto = new ProductDto();

    @Test
    public void shouldThrowDiscountNullException() {
        assertThatThrownBy(() -> victim.validate(dto))
                .isInstanceOf(IllegalArgumentException.class)
                .hasMessage("Discount should be not null");
    }

    @Test
    public void shouldThrowDiscountIllegalException() {
        dto.setDiscount(new BigDecimal(-1));

        assertThatThrownBy(() -> victim.validate(dto))
                .isInstanceOf(DiscountIllegalException.class)
                .hasMessage("Discount shall not be less than 0 or greater than 100");

        dto.setDiscount(new BigDecimal(101));

        assertThatThrownBy(() -> victim.validate(dto))
                .isInstanceOf(DiscountIllegalException.class)
                .hasMessage("Discount shall not be less than 0 or greater than 100");

        verify(victim, times(2)).checkProductNotNull(dto);
    }

    @Test
    public void shouldThrowDiscountExceptionDueToPriceLevel() {
        dto.setPrice(new BigDecimal(10));
        dto.setDiscount(new BigDecimal(1));

        assertThatThrownBy(() -> victim.validate(dto))
                .isInstanceOf(DiscountIllegalException.class)
                .hasMessage("Discount shall be 0 if product price less than 20$");

        verify(victim).checkProductNotNull(dto);
    }

    @Test
    public void shouldNotThrowException() {
        dto.setPrice(new BigDecimal(25));
        dto.setDiscount(new BigDecimal(25));

        assertThatCode(() -> victim.validate(dto)).doesNotThrowAnyException();

        dto.setPrice(new BigDecimal(10));
        dto.setDiscount(new BigDecimal(0));

        assertThatCode(() -> victim.validate(dto)).doesNotThrowAnyException();

        verify(victim, times(2)).checkProductNotNull(dto);
    }


}