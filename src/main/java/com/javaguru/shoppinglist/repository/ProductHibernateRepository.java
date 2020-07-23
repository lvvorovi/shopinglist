package com.javaguru.shoppinglist.repository;

import com.javaguru.shoppinglist.domain.ProductEntity;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.criterion.Restrictions;
import org.springframework.context.annotation.Profile;
import org.springframework.stereotype.Repository;

import javax.transaction.Transactional;
import java.util.List;
import java.util.Optional;

@Repository
@Profile("hibernate")
@Transactional
public class ProductHibernateRepository implements ProductRepository {

    private final SessionFactory sessionFactory;

    public ProductHibernateRepository(SessionFactory sessionFactory) {
        this.sessionFactory = sessionFactory;
    }

    private Session dataBase() {
        return sessionFactory.getCurrentSession();
    }

    @Override
    public ProductEntity save(ProductEntity entity) {
        dataBase().save(entity);
        return entity;
    }

    @Override
    public Optional<ProductEntity> findById(Long id) {
        return Optional.ofNullable(dataBase().get(ProductEntity.class, id));
    }

    @Override
    public Optional<List<ProductEntity>> findAll() {
        List<ProductEntity> entityList = dataBase().createCriteria(ProductEntity.class).list();
        return Optional.of(entityList);
    }

    @Override
    public ProductEntity updateById(Long id, ProductEntity entity) {
        dataBase().update(entity);
        entity.setId(id);
        return entity;
    }

    @Override
    public Boolean deleteById(Long id) {
        ProductEntity entity = dataBase().get(ProductEntity.class, id);
        if (entity != null) {
            dataBase().delete(entity);
            return true;
        }
        return false;
    }

    @Override
    public Boolean isById(Long id) {
        return dataBase().get(ProductEntity.class, id) != null;
    }

    @Override
    public Boolean isByName(String name) {
        return dataBase().createCriteria(ProductEntity.class).add(Restrictions.eq("name", name)).uniqueResult() != null;
    }
}
