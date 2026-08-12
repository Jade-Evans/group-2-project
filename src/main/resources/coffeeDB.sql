CREATE DATABASE IF NOT EXISTS coffeeDB;

USE coffeeDB;

CREATE TABLE IF NOT EXISTS products(
                         id BIGINT AUTO_INCREMENT PRIMARY KEY,
                         name VARCHAR(50) NOT NULL,
                         blend_type VARCHAR(50) NOT NULL,
                         weight_in_grams INT NOT NULL,
                         strength INT NOT NULL,
                         decaf BOOLEAN,
                         price DOUBLE(5,2) NOT NULL,
                         total_ordered INT NOT NULL,
                         total_in_stock INT NOT NULL
);

INSERT INTO products (name, blend_type, weight_in_grams, strength, decaf, price, total_ordered, total_in_stock)


VALUES
    ('House Blend', 'BEAN', 250, 3, FALSE, 8.99, 0, 50),
    ('House Blend', 'GROUND', 500, 3, FALSE, 9.99, 0, 50),
    ('House Blend', 'BEAN', 250, 3, TRUE, 9.49, 0, 50),
    ('House Blend', 'GROUND', 500, 3, TRUE, 9.99, 0, 50),
    ('House Blend', 'BEAN', 1000, 3, FALSE, 16.99, 0, 30),
    ('House Blend', 'BEAN', 100, 3, FALSE, 4.49, 0, 75),

    ('Signature Blend', 'BEAN', 250, 4, FALSE, 9.99, 0, 50),
    ('Signature Blend', 'GROUND', 500, 4, FALSE, 9.99, 0, 50),
    ('Signature Blend', 'BEAN', 1000, 4, FALSE, 18.49, 0, 25),
    ('Signature Blend', 'GROUND', 250, 4, TRUE, 6.99, 0, 40),

    ('Italian Noir', 'BEAN', 250, 5, FALSE, 9.99, 0, 50),
    ('Italian Noir', 'GROUND', 500, 5, FALSE, 9.99, 0, 50),
    ('Italian Noir', 'BEAN', 500, 5, FALSE, 15.99, 0, 35),
    ('Italian Noir', 'GROUND', 1000, 5, FALSE, 22.99, 0, 15),
    ('Italian Noir', 'BEAN', 100, 5, TRUE, 5.49, 0, 60),

    ('Velvet Roast', 'BEAN', 250, 4, FALSE, 9.99, 0, 50),
    ('Velvet Roast', 'GROUND', 500, 4, FALSE, 9.99, 0, 50),
    ('Velvet Roast', 'BEAN', 250, 4, TRUE, 10.49, 0, 45),
    ('Velvet Roast', 'GROUND', 100, 4, FALSE, 4.99, 0, 80),

    ('Sumatra Dark', 'BEAN', 250, 5, FALSE, 11.49, 0, 40),
    ('Sumatra Dark', 'GROUND', 500, 5, FALSE, 12.99, 0, 30),
    ('Sumatra Dark', 'BEAN', 1000, 5, FALSE, 24.99, 0, 12),

    ('Ethiopian Light', 'BEAN', 250, 2, FALSE, 13.49, 0, 20),
    ('Ethiopian Light', 'GROUND', 250, 2, FALSE, 13.99, 0, 18),
    ('Ethiopian Light', 'BEAN', 100, 2, FALSE, 6.29, 0, 55),

    ('Colombian Gold', 'BEAN', 500, 3, FALSE, 15.49, 0, 22),
    ('Colombian Gold', 'GROUND', 500, 3, TRUE, 16.49, 0, 18),
    ('Colombian Gold', 'BEAN', 250, 3, FALSE, 8.49, 0, 65),

    ('Midnight Espresso', 'BEAN', 250, 5, FALSE, 10.99, 0, 42),
    ('Midnight Espresso', 'GROUND', 250, 5, FALSE, 10.99, 0, 38),
    ('Midnight Espresso', 'BEAN', 1000, 5, FALSE, 20.99, 0, 10),

    ('Vanilla Cream', 'GROUND', 250, 2, FALSE, 9.49, 0, 33),
    ('Vanilla Cream', 'BEAN', 250, 2, TRUE, 9.99, 0, 28)
;
