package com.javaguru.shoppinglist.dto;

import java.math.BigDecimal;
import java.util.Objects;

public class ProductDto {

    private Long id;
    private String name;
    private BigDecimal price;
    private BigDecimal discount;
    private String description;
    private BigDecimal actualPrice;
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

    public BigDecimal getActualPrice() {
        return actualPrice;
    }

    public void setActualPrice(BigDecimal actualPrice) {
        this.actualPrice = actualPrice;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        ProductDto that = (ProductDto) o;
        return Objects.equals(getId(), that.getId()) &&
                Objects.equals(getName(), that.getName()) &&
                Objects.equals(getPrice(), that.getPrice()) &&
                Objects.equals(getDiscount(), that.getDiscount()) &&
                Objects.equals(getSku(), that.getSku()) &&
                Objects.equals(getDescription(), that.getDescription()) &&
                Objects.equals(getActualPrice(), that.getActualPrice());
    }

    @Override
    public int hashCode() {
        return Objects.hash(getId(), getName(), getPrice(), getDiscount(), getSku(), getDescription(), getActualPrice());
    }

    @Override
    public String toString() {
        return "Product{" +
                "id=" + id +
                ", name='" + name + '\'' +
                ", price=" + price +
                ", discount=" + discount +
                ", SKU=" + sku +
                ", description='" + description + '\'' +
                ", actualPrice=" + actualPrice +
                '}';
    }
}
