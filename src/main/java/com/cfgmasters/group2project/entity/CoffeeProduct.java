package com.cfgmasters.group2project.entity;
import jakarta.persistence.*;
import lombok.*;

 @Entity
 @Table(name = "products") //this specifies which table in the DB
 @Getter
 @Setter
 @ToString
 @AllArgsConstructor
 @NoArgsConstructor
public class CoffeeProduct {
    @Id //required by entity
    @GeneratedValue(strategy = GenerationType.IDENTITY) //=AUTOINCREMENT
    @Column(name = "id")
    private Long id;

    @Column(name = "blend", nullable = false)
    private String title;

    @Column(name = "coffee_type", nullable = false)
    private CoffeeType coffeeType;

    @Column(name = "bag_size")
    private Integer bagSizeInGrams;

    @Column(name = "strength", nullable = false)
    private Integer strength;

    @Column(name = "decaf", nullable = false)
    private boolean decaf;

    @Column(name = "price", nullable = false)
    private Double price;

    @Column(name = "total_in_stock", nullable = false)
    private Integer stockTotal;
}


