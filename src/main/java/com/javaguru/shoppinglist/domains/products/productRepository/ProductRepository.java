package com.javaguru.shoppinglist.domains.products.productRepository;

import com.javaguru.shoppinglist.domains.products.ProductEntity;
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
        if (!entityList.isEmpty()) {
            return Optional.of(entityList);
        }
        return Optional.empty();
    }

    @Override
    public ProductEntity update(ProductEntity entity) {
        dataBase().update(entity);
        return entity;
    }

    @Override
    public void delete(ProductEntity entity) {
        dataBase().delete(entity);
    }

    @Override
    public Boolean isById(Long id) {
        return dataBase().get(ProductEntity.class, id) != null;
    }

    @Override
    public ProductEntity findByName(String name) {
        return (ProductEntity) dataBase().createCriteria(ProductEntity.class)
                .add(Restrictions.eq("name", name).ignoreCase()).uniqueResult();

    }
}
