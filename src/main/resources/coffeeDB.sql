CREATE DATABASE coffeeDB;

USE coffeeDB;

CREATE TABLE products(
     id BIGINT AUTO_INCREMENT PRIMARY KEY,
     name VARCHAR(50) NOT NULL,
     coffee_type VARCHAR(50) NOT NULL,
     weight_in_grams INT NOT NULL,
     strength INT NOT NULL,
     decaf BOOLEAN,
     price DOUBLE(5,2) NOT NULL,
     total_ordered INT NOT NULL,
     total_in_stock INT NOT NULL
);

INSERT INTO products (name, coffee_type, weight_in_grams, strength, decaf, price, total_ordered, total_in_stock)
VALUES
    ('House Blend', 'BEAN', 250, 3, FALSE, 8.99, 0, 50),
    ('House Blend', 'GROUND', 500, 3, FALSE, 9.99, 0, 50),
    ('House Blend', 'BEAN', 250, 3, TRUE, 9.49, 0, 50),
    ('House Blend', 'GROUND', 500, 3, TRUE, 9.99, 0, 50),
    ('Signature Blend', 'BEAN', 250, 4, FALSE, 9.99, 0, 50),
    ('Signature Blend', 'GROUND', 500, 4, FALSE, 9.99, 0, 50),
    ('Italian Noir', 'BEAN', 250, 5, FALSE, 9.99, 0, 50),
    ('Italian Noir', 'GROUND', 500, 5, FALSE, 9.99, 0, 50),
    ('Velvet Roast', 'BEAN', 250, 4, FALSE, 9.99, 0, 50),
    ('Velvet Roast', 'GROUND', 500, 4, FALSE, 9.99, 0, 50)
;