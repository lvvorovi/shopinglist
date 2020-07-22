/*
package com.javaguru.shoppinglist.repository;

import com.javaguru.shoppinglist.domain.ProductEntity;
import com.javaguru.shoppinglist.service.validation.exceptions.ProductNotFoundException;
import org.junit.Test;

import java.math.BigDecimal;
import java.util.LinkedList;
import java.util.List;

import static org.assertj.core.api.Assertions.assertThat;
import static org.junit.Assert.assertEquals;

public class ProductInMemoryRepositoryTest {

    final ProductRepository victim = new ProductInMemoryRepository();

    private ProductEntity productEntity() {
        ProductEntity entity = new ProductEntity();
        entity.setName("name");
        entity.setPrice(new BigDecimal(100));
        entity.setDiscount(new BigDecimal(10));
        entity.setId(0L);
        return entity;
    }

    private List<ProductEntity> listEntity() {
        List<ProductEntity> listEntity = new LinkedList<>();
        listEntity.add(productEntity());
        ProductEntity entity = updatedNameEntity();
        listEntity.add(entity);
        return listEntity;
    }

    private ProductEntity updatedNameEntity() {
        ProductEntity entity = productEntity();
        entity.setName("newName");
        entity.setId(1L);
        return entity;
    }

    @Test
    public void shouldSaveWithIdAndFindByIdAndFindByName() {
        victim.save(productEntity());
        Long id = 0L;

        assertEquals(productEntity(), victim.findByID(id)
                .orElseThrow(() -> new ProductNotFoundException("Product with ID " + id + " not Found")));

        assertEquals(productEntity(), victim.findByName("name")
                .orElseThrow(() -> new ProductNotFoundException("Product with name 'name' not Found")));

    }

    @Test
    public void shouldNotFindByIdAndByName() {
        assertThat(victim.findByID(0L)).isEmpty();
        assertThat(victim.findByName("name")).isEmpty();
    }

    @Test
    public void shouldFindAll() {
        victim.save(productEntity());
        victim.save(updatedNameEntity());

        assertEquals(listEntity(), victim.findAll());
    }

    @Test
    public void shouldDelete() {
        victim.save(productEntity());
        victim.save(updatedNameEntity());

        assertEquals(listEntity(), victim.findAll());

        victim.deleteByID(0L);

        List<ProductEntity> newList = listEntity();
        newList.remove(0);

        assertEquals(newList, victim.findAll());
    }

}

*/
