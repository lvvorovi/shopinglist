package com.javaguru.shoppinglist.domains.userItems;

import com.javaguru.shoppinglist.domains.products.productDto.ProductDto;
import com.javaguru.shoppinglist.domains.users.UserDto;

import java.math.BigDecimal;
import java.util.Objects;

public class UserItemDto {

    private Long id;
    private UserDto user;
    private ProductDto product;
    private int quantity;
    private BigDecimal totalPrice;

    public UserItemDto() {
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

    public BigDecimal getTotalPrice() {
        return totalPrice;
    }

    public void setTotalPrice(BigDecimal totalPrice) {
        this.totalPrice = totalPrice;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        UserItemDto that = (UserItemDto) o;
        return quantity == that.quantity &&
                Objects.equals(id, that.id) &&
                Objects.equals(user, that.user) &&
                Objects.equals(product, that.product) &&
                Objects.equals(totalPrice, that.totalPrice);
    }

    @Override
    public int hashCode() {
        return Objects.hash(id, user, product, quantity, totalPrice);
    }

    @Override
    public String toString() {
        return "UserItemDto{" +
                "id=" + id +
                ", user=" + user.getId() +
                ", product=" + product.getId() +
                ", quantity=" + quantity +
                ", totalPrice=" + totalPrice +
                '}';
    }
}
