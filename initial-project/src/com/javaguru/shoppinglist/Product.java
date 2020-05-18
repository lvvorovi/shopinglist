package com.javaguru.shoppinglist;

import java.math.BigDecimal;

public class Product {

    private Long id;
    private String name;
    private BigDecimal price;
    private String category;
    private int discount;
    private String description;

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
        if (name.length() >= 3 && name.length() <= 32 )
        this.name = name;
    }

    public BigDecimal getPrice() {
        return price;
    }

    public void setPrice(BigDecimal price) {
        if ((price.compareTo(new BigDecimal(0))) > 0) {
            this.price = price;
        }
    }

    public String getCategory() {
        return category;
    }

    public void setCategory(String category) {
        this.category = category;
    }

    public int getDiscount() {
        return discount;
    }

    public void setDiscount(int discount) {
        if (discount <= 100) {
            this.discount = discount;
        }
    }

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    @Override
    public String toString() {
        return "Product{" +
                "id=" + id +
                ", name='" + name + '\'' +
                ", price=" + price +
                ", category='" + category + '\'' +
                ", discount=" + discount +
                ", description='" + description + '\'' +
                '}';
    }
}