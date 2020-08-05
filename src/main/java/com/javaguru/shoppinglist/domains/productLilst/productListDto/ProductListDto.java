package com.javaguru.shoppinglist.domains.productLilst.productListDto;

import com.javaguru.shoppinglist.domains.products.productDto.ProductDto;
import com.javaguru.shoppinglist.domains.users.dto.UserDto;

import java.util.Objects;

public class ProductListDto {

    Long id;
    UserDto user;
    ProductDto product;
    int quantity;

    public ProductListDto() {
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public UserDto getUser() {
        return user;
    }

    public void setUser(UserDto user) {
        this.user = user;
    }

    public ProductDto getProduct() {
        return product;
    }

    public void setProduct(ProductDto product) {
        this.product = product;
    }

    public int getQuantity() {
        return quantity;
    }

    public void setQuantity(int quantity) {
        this.quantity = quantity;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        ProductListDto dto = (ProductListDto) o;
        return quantity == dto.quantity &&
                Objects.equals(id, dto.id) &&
                Objects.equals(user, dto.user) &&
                Objects.equals(product, dto.product);
    }

    @Override
    public int hashCode() {
        return Objects.hash(id, user, product, quantity);
    }

    @Override
    public String toString() {
        return "ProductListDto{" +
                "id=" + id +
                ", user=" + user +
                ", product=" + product +
                ", quantity=" + quantity +
                '}';
    }
}
