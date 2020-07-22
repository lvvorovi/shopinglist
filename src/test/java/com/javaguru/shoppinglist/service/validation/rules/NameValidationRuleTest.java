package com.javaguru.shoppinglist.service.validation.rules;

import com.javaguru.shoppinglist.repository.ProductSqlRepository;
import com.javaguru.shoppinglist.service.validation.exceptions.NameAlreadyExistsException;
import com.javaguru.shoppinglist.service.validation.exceptions.NameIllegalException;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.Mockito;
import org.mockito.Spy;
import org.mockito.junit.MockitoJUnitRunner;

import static com.javaguru.shoppinglist.TestProductConstructors.*;
import static org.assertj.core.api.Assertions.assertThatCode;
import static org.assertj.core.api.Assertions.assertThatThrownBy;
import static org.mockito.Mockito.*;

@RunWith(MockitoJUnitRunner.class)
public class NameValidationRuleTest {

    @Mock
    ProductSqlRepository productRepository;
    @Spy
    @InjectMocks
    NameValidationRule victim;

    @Test
    public void shouldThrowExceptionWithNameNull() {
        assertThatThrownBy(() -> victim.validate(productDtoAllValuesNull()))
                .isInstanceOf(IllegalArgumentException.class)
                .hasMessage("Name should be not null");

        verify(victim).checkProductNotNull(productDtoAllValuesNull());
    }

    @Test
    public void shouldThrowNameLengthExceptions() {
        assertThatThrownBy(() -> victim.validate(productDtoAllValuesTooSmall()))
                .isInstanceOf(NameIllegalException.class)
                .hasMessage("Name should be 3-32 characters long");

        assertThatThrownBy(() -> victim.validate(productDtoAllValuesTooBig()))
                .isInstanceOf(NameIllegalException.class)
                .hasMessage("Name should be 3-32 characters long");

        verify(victim).checkProductNotNull(productDtoAllValuesTooSmall());
        verify(victim).checkProductNotNull(productDtoAllValuesTooBig());
    }

    @Test
    public void shouldThrowNameAlreadyExistException() {
        when(productRepository.isByName(any())).thenReturn(true);

        assertThatThrownBy(() -> victim.validate(productDto()))
                .isInstanceOf(NameAlreadyExistsException.class)
                .hasMessage("Name already exist");

        verify(victim).checkProductNotNull(productDto());
    }

    @Test
    public void shouldNotThrowException() {
        Mockito.when(productRepository.isByName(any())).thenReturn(false);

        assertThatCode(() -> victim.validate(productDto())).doesNotThrowAnyException();

        verify(victim).checkProductNotNull(productDto());
    }

}