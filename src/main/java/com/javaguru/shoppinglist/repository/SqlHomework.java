package com.javaguru.shoppinglist.repository;

public class SqlHomework {

    CREATE TABLE users(
            user_id               BIGINT      NOT NULL AUTO_INCREMENT,
            user_login            VARCHAR(20) NOT NULL UNIQUE,
            user_first_name       VARCHAR(20) NOT NULL,
            user_last_name        VARCHAR(20) NOT NULL,
            user_email            VARCHAR(50) UNIQUE,
            user_phone            VARCHAR(50) UNIQUE,
//            user_permission_level INT DEFAULT 1,

    PRIMARY KEY (user_id)
);

    CREATE TABLE addresses(
            address_id  BIGINT      NOT NULL AUTO_INCREMENT,
            street      VARCHAR(40) NOT NULL,
    building_nr VARCHAR(20) NOT NULL,
    apt_nr      VARCHAR(20),
    state       VARCHAR(20),
    city        VARCHAR(20) NOT NULL ,
    zip_code    VARCHAR(20) NOT NULL ,
    country     VARCHAR(30) NOT NULL ,
    user_id     BIGINT      NOT NULL,

    PRIMARY KEY (address_id),
    FOREIGN KEY (user_id) REFERENCES users (user_id),
    CONSTRAINT uc_addresses UNIQUE (street, building_nr, apt_nr, city, zip_code, country, user_id)
);

    CREATE TABLE products(
            product_id          BIGINT      NOT NULL AUTO_INCREMENT,
            product_sku         VARCHAR(10),
    product_name        VARCHAR(35) NOT NULL,
    product_price       DECIMAL     NOT NULL,
    product_discount    DECIMAL     NOT NULL,
    product_category    VARCHAR(20),
    product_description VARCHAR(500),

    PRIMARY KEY (product_id),
    CONSTRAINT uc_products UNIQUE (product_name, product_category, product_description),
    INDEX (product_price, product_name)
);

    CREATE TABLE baskets(
            basket_items_id  BIGINT NOT NULL AUTO_INCREMENT,
            user_id          BIGINT NOT NULL,
            product_id       BIGINT  DEFAULT NULL,
            product_price    DECIMAL DEFAULT NULL,
            product_quantity BIGINT  DEFAULT 1,
    #     user_session_id  VARCHAR(50),

    PRIMARY KEY (basket_items_id),
    FOREIGN KEY (product_id) REFERENCES products (product_id),
    FOREIGN KEY (product_price) REFERENCES products (product_price),
    FOREIGN KEY (user_id) REFERENCES users (user_id)
            );

    CREATE TABLE orders(
            order_id         BIGINT    NOT NULL AUTO_INCREMENT,
            user_id          BIGINT    NOT NULL,
            order_date       DATE      NOT NULL,
            order_time       TIME      NOT NULL,
            user_session     TIMESTAMP NOT NULL, #todo
                    order_address    BIGINT    NOT NULL,
            orders_completed BOOLEAN DEFAULT 0,

            PRIMARY KEY (order_id),
    FOREIGN KEY (user_id) REFERENCES users (user_id)
            );

    CREATE TABLE order_products(
            order_product_id   BIGINT  NOT NULL AUTO_INCREMENT,
            order_id         BIGINT  NOT NULL,
            product_id       BIGINT  NOT NULL,
            product_price    DECIMAL NOT NULL,
            product_quantity BIGINT  NOT NULL,
            user_session_id  VARCHAR(50),

    PRIMARY KEY (order_product_id),
    FOREIGN KEY (order_id) REFERENCES orders (order_id),
    CONSTRAINT uc_order_items UNIQUE (order_id, product_id)
);

    CREATE TABLE collections(
            collection_id BIGINT NOT NULL AUTO_INCREMENT,
            collection_name VARCHAR(20) NOT NULL,

    PRIMARY KEY (collection_id)
);

    CREATE TABLE product_collections(
            product_collection_id BIGINT NOT NULL AUTO_INCREMENT,
            product_id BIGINT NOT NULL,

            PRIMARY KEY (product_collection_id),
    FOREIGN KEY (product_id) REFERENCES products (product_id)
            );

    INSERT INTO users (user_login, user_first_name, user_last_name) VALUES ('login1', 'name1', 'lastname1');
    INSERT INTO users (user_login, user_first_name, user_last_name) VALUES ('login2', 'name2', 'lastname2');
    INSERT INTO users (user_login, user_first_name, user_last_name) VALUES ('login3', 'name3', 'lastname3');
    INSERT INTO users (user_login, user_first_name, user_last_name) VALUES ('login4', 'name4', 'lastname4');
    INSERT INTO users (user_login, user_first_name, user_last_name) VALUES ('login5', 'name5', 'lastname5');
    INSERT INTO users (user_login, user_first_name, user_last_name) VALUES ('login6', 'name6', 'lastname6');
    INSERT INTO users (user_login, user_first_name, user_last_name) VALUES ('login7', 'name7', 'lastname7');
    INSERT INTO users (user_login, user_first_name, user_last_name) VALUES ('login8', 'name8', 'lastname8');
    INSERT INTO users (user_login, user_first_name, user_last_name) VALUES ('login9', 'name9', 'lastname9');
    INSERT INTO users (user_login, user_first_name, user_last_name) VALUES ('login10', 'nam10', 'lastname10');

    INSERT INTO addresses (street, building_nr, city, zip_code, country, user_id) VALUES ('street_1', 'building_nr_1', 'city_1', 'zip_1', 'country_1', 1);
    INSERT INTO addresses (street, building_nr, city, zip_code, country, user_id) VALUES ('street_2', 'building_nr_2', 'city_2', 'zip_2', 'country_2', 2);
    INSERT INTO addresses (street, building_nr, city, zip_code, country, user_id) VALUES ('street_3', 'building_nr_3', 'city_3', 'zip_3', 'country_3', 3);
    INSERT INTO addresses (street, building_nr, city, zip_code, country, user_id) VALUES ('street_4', 'building_nr_4', 'city_4', 'zip_4', 'country_4', 4);
    INSERT INTO addresses (street, building_nr, city, zip_code, country, user_id) VALUES ('street_5', 'building_nr_5', 'city_5', 'zip_5', 'country_5', 5);
    INSERT INTO addresses (street, building_nr, city, zip_code, country, user_id) VALUES ('street_6', 'building_nr_6', 'city_6', 'zip_6', 'country_6', 6);
    INSERT INTO addresses (street, building_nr, city, zip_code, country, user_id) VALUES ('street_7', 'building_nr_7', 'city_7', 'zip_7', 'country_7', 7);
    INSERT INTO addresses (street, building_nr, city, zip_code, country, user_id) VALUES ('street_8', 'building_nr_8', 'city_8', 'zip_8', 'country_8', 8);
    INSERT INTO addresses (street, building_nr, city, zip_code, country, user_id) VALUES ('street_9', 'building_nr_9', 'city_9', 'zip_9', 'country_9', 9);
    INSERT INTO addresses (street, building_nr, city, zip_code, country, user_id) VALUES ('street_10', 'building_nr_10', 'city_10', 'zip_10', 'country_10', 10);

    INSERT INTO products (product_name, product_price, product_discount) VALUES ('name1', 100, 10);
    INSERT INTO products (product_name, product_price, product_discount) VALUES ('name2', 100, 10);
    INSERT INTO products (product_name, product_price, product_discount) VALUES ('name3', 100, 10);
    INSERT INTO products (product_name, product_price, product_discount) VALUES ('name4', 100, 10);
    INSERT INTO products (product_name, product_price, product_discount) VALUES ('name5', 100, 10);
    INSERT INTO products (product_name, product_price, product_discount) VALUES ('name6', 100, 10);
    INSERT INTO products (product_name, product_price, product_discount) VALUES ('name7', 100, 10);
    INSERT INTO products (product_name, product_price, product_discount) VALUES ('name8', 100, 10);
    INSERT INTO products (product_name, product_price, product_discount) VALUES ('name9', 100, 10);
    INSERT INTO products (product_name, product_price, product_discount) VALUES ('name10', 100, 10);

    INSERT INTO baskets (user_id, product_id, product_price, product_quantity) VALUES (1, 1, 100, 1);
    INSERT INTO baskets (user_id, product_id, product_price, product_quantity) VALUES (1, 2, 100, 1);
    INSERT INTO baskets (user_id, product_id, product_price, product_quantity) VALUES (1, 3, 100, 4);
    INSERT INTO baskets (user_id, product_id, product_price, product_quantity) VALUES (1, 8, 100, 5);

    INSERT INTO baskets (user_id, product_id, product_price, product_quantity) VALUES (2, 1, 100, 1);
    INSERT INTO baskets (user_id, product_id, product_price, product_quantity) VALUES (2, 2, 100, 1);
    INSERT INTO baskets (user_id, product_id, product_price, product_quantity) VALUES (2, 3, 100, 4);
    INSERT INTO baskets (user_id, product_id, product_price, product_quantity) VALUES (2, 8, 100, 5);

    INSERT INTO baskets (user_id, product_id, product_price, product_quantity) VALUES (4, 1, 100, 1);
    INSERT INTO baskets (user_id, product_id, product_price, product_quantity) VALUES (4, 2, 100, 1);
    INSERT INTO baskets (user_id, product_id, product_price, product_quantity) VALUES (4, 3, 100, 4);
    INSERT INTO baskets (user_id, product_id, product_price, product_quantity) VALUES (4, 8, 100, 5);

    INSERT INTO baskets (user_id, product_id, product_price, product_quantity) VALUES (7, 1, 100, 1);
    INSERT INTO baskets (user_id, product_id, product_price, product_quantity) VALUES (7, 2, 100, 1);
    INSERT INTO baskets (user_id, product_id, product_price, product_quantity) VALUES (7, 3, 100, 4);
    INSERT INTO baskets (user_id, product_id, product_price, product_quantity) VALUES (7, 8, 100, 5);

    INSERT INTO baskets (user_id, product_id, product_price, product_quantity) VALUES (3, 1, 100, 1);
    INSERT INTO baskets (user_id, product_id, product_price, product_quantity) VALUES (5, 2, 100, 1);
    INSERT INTO baskets (user_id, product_id, product_price, product_quantity) VALUES (6, 3, 100, 4);
    INSERT INTO baskets (user_id, product_id, product_price, product_quantity) VALUES (8, 8, 100, 5);

    SELECT * FROM users;
    SELECT * FROM addresses;
    SELECT * FROM products;
    SELECT * FROM baskets;

    SELECT users.user_first_name, users.user_last_name, baskets.product_id FROM baskets
    RIGHT JOIN users ON baskets.user_id = users.user_id
    WHERE users.user_id = 1;

}
