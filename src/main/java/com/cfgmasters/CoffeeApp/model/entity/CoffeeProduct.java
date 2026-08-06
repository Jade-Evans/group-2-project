package com.cfgmasters.CoffeeApp.model.entity;

import jakarta.persistence.*;
import lombok.Builder;
import lombok.*;


@Builder
@Entity
@Table(name = "products")
@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
public class CoffeeProduct {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "id")
    private Long id;

    @Column(name = "name", nullable = false)
    private String name;

    @Enumerated(EnumType.STRING)
    @Column(name = "blend_type", nullable = false)
    private BlendType blendType;

    @Column(name = "weight_in_grams")
    private Integer weightInGrams;

    @Column(name = "strength", nullable = false)
    private Integer strength;

    @Column(name = "decaf", nullable = false)
    private boolean decaf;

    @Column(name = "price", nullable = false)
    private Double price;

    @Column(name = "total_ordered", nullable = false)
    private Integer orderTotal;

    @Column(name = "total_in_stock", nullable = false)
    private Integer stockTotal;

}
