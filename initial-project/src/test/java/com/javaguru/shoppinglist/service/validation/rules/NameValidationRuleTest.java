package com.javaguru.shoppinglist.service.validation.rules;

import com.javaguru.shoppinglist.domain.ProductEntity;
import com.javaguru.shoppinglist.dto.ProductDto;
import com.javaguru.shoppinglist.repository.ProductInMemoryRepository;
import com.javaguru.shoppinglist.service.validation.exceptions.NameAlreadyExistsException;
import com.javaguru.shoppinglist.service.validation.exceptions.NameIllegalException;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.Spy;
import org.mockito.junit.MockitoJUnitRunner;

import java.util.LinkedList;
import java.util.List;

import static org.assertj.core.api.Assertions.assertThatCode;
import static org.assertj.core.api.Assertions.assertThatThrownBy;
import static org.mockito.Mockito.*;

@RunWith(MockitoJUnitRunner.class)
public class NameValidationRuleTest {

    @Mock
    ProductInMemoryRepository productRepository;
    @Spy
    @InjectMocks
    NameValidationRule victim;

    ProductDto dto = new ProductDto();

    @Test
    public void shouldThrowExceptionWithNameNull() {
        assertThatThrownBy(() -> victim.validate(dto)).
                isInstanceOf(IllegalArgumentException.class).
                hasMessage("Name should be not null");

        verify(victim).checkProductNotNull(dto);

    }

    @Test
    public void shouldThrowNameLengthExceptions() {
        dto.setName("ab");

        assertThatThrownBy(() -> victim.validate(dto)).
                isInstanceOf(NameIllegalException.class).
                hasMessage("Name should be 3-32 characters long");

        dto.setName("123456789012345678901234567890123");

        assertThatThrownBy(() -> victim.validate(dto)).
                isInstanceOf(NameIllegalException.class).
                hasMessage("Name should be 3-32 characters long");

        verify(victim, times(2)).checkProductNotNull(dto);
    }

    @Test
    public void shouldThrowNameAlreadyExistException() {
        ProductEntity entity = new ProductEntity();
        entity.setName("wrongName");

        List<ProductEntity> entityList = new LinkedList<>();
        entityList.add(entity);

        when(productRepository.findAll()).thenReturn(entityList);

        dto.setName("wrongName");

        assertThatThrownBy(() -> victim.validate(dto)).
                isInstanceOf(NameAlreadyExistsException.class).
                hasMessage("Name already exist");

        verify(victim).checkProductNotNull(dto);
    }

    @Test
    public void shouldNotThrowException() {
        dto.setName("name");

        assertThatCode(() -> victim.validate(dto)).doesNotThrowAnyException();

        verify(victim).checkProductNotNull(dto);
    }

}