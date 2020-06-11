package com.javaguru.shoppinglist;

import com.javaguru.shoppinglist.repository.ProductInMemoryRepository;
import com.javaguru.shoppinglist.domain.Product;

import java.math.BigDecimal;
import java.util.Scanner;

class ShoppingListApplication {

    public static void main(String[] args) {

        Console console = new Console();
        console.execute();

    }
}
