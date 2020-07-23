package com.javaguru.shoppinglist.domain;


import org.hibernate.search.annotations.Field;

import javax.persistence.*;
import java.math.BigDecimal;
import java.util.Objects;

@Entity
@Table(name = "products")
public class ProductEntity {

    @Id
    @Column(name = "id")
    @GeneratedValue(strategy = GenerationType.SEQUENCE)
    private Long id;
    @Column(name = "name", nullable = false, unique = true)
    @Field
    private String name;
    @Column(name = "price", nullable = false)
    private BigDecimal price;
    @Column(name = "discount", nullable = false)
    private BigDecimal discount;
    @Column(name = "description")
    private String description;
    @Field
    @Column(name = "sku")
    private String sku;

    public String getSku() {
        return sku;
    }

    public void setSku(String sku) {
        this.sku = sku;
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public BigDecimal getPrice() {
        return price;
    }

    public void setPrice(BigDecimal price) {
        this.price = price;
    }

    public BigDecimal getDiscount() {
        return discount;
    }

    public void setDiscount(BigDecimal discount) {
        this.discount = discount;
    }

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        ProductEntity product = (ProductEntity) o;
        return getDiscount().equals(product.getDiscount()) &&
                getId().equals(product.getId()) &&
                getName().equals(product.getName()) &&
                getPrice().equals(product.getPrice()) &&
                getSku().equals(product.getSku()) &&
                Objects.equals(getDescription(), product.getDescription());
    }

    @Override
    public int hashCode() {
        return Objects.hash(getId(), getName(), getPrice(), getDiscount(), getSku(), getDescription());
    }

    @Override
    public String toString() {
        return "ProductEntity{" +
                "id=" + id +
                ", name='" + name + '\'' +
                ", price=" + price +
                ", discount=" + discount +
                ", SKU=" + sku +
                ", description='" + description + '\'' +
                '}';
    }
}