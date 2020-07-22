package com.javaguru.shoppinglist.service.validation.rules;

import com.javaguru.shoppinglist.service.validation.exceptions.DiscountIllegalException;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.mockito.Spy;
import org.mockito.junit.MockitoJUnitRunner;

import static com.javaguru.shoppinglist.TestProductConstructors.*;
import static org.assertj.core.api.Assertions.assertThatCode;
import static org.assertj.core.api.Assertions.assertThatThrownBy;
import static org.mockito.Mockito.verify;

@RunWith(MockitoJUnitRunner.class)
public class DiscountValidationRuleTest {

    @Spy
    DiscountValidationRule victim;

    @Test
    public void shouldThrowDiscountNullException() {
        assertThatThrownBy(() -> victim.validate(productDtoAllValuesNull()))
                .isInstanceOf(IllegalArgumentException.class)
                .hasMessage("Discount should be not null");
    }

    @Test
    public void shouldThrowDiscountIllegalException() {
        assertThatThrownBy(() -> victim.validate(productDtoAllValuesTooSmall()))
                .isInstanceOf(DiscountIllegalException.class)
                .hasMessage("Discount shall not be less than 0 or greater than 100");

        assertThatThrownBy(() -> victim.validate(productDtoAllValuesTooBig()))
                .isInstanceOf(DiscountIllegalException.class)
                .hasMessage("Discount shall not be less than 0 or greater than 100");

        verify(victim).checkProductNotNull(productDtoAllValuesTooSmall());
        verify(victim).checkProductNotNull(productDtoAllValuesTooBig());
    }

    @Test
    public void shouldThrowDiscountExceptionDueToPriceLevel() {
        assertThatThrownBy(() -> victim.validate(productDtoLowPriceNotZeroDiscount()))
                .isInstanceOf(DiscountIllegalException.class)
                .hasMessage("Discount shall be 0 if product price less than 20$");

        verify(victim).checkProductNotNull(productDtoLowPriceNotZeroDiscount());
    }

    @Test
    public void shouldNotThrowException() {
        assertThatCode(() -> victim.validate(productDtoPriceOneHundredDiscountTen())).doesNotThrowAnyException();

        assertThatCode(() -> victim.validate(productDtoPriceTenDiscountZero())).doesNotThrowAnyException();

        verify(victim).checkProductNotNull(productDtoPriceOneHundredDiscountTen());
        verify(victim).checkProductNotNull(productDtoPriceTenDiscountZero());
    }


}