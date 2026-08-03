package com.cfgmasters.CoffeeApp.model.entity;

import jakarta.persistence.*;

@Entity
@Table(name = "products")
public class CoffeeProduct {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "id")
    private Long id;

    @Column(name = "name", nullable = false)
    private String name;

    @Enumerated(EnumType.STRING)
    @Column(name = "coffee_type", nullable = false)
    private CoffeeType coffeeType;

    @Column(name = "weight_in_grams")
    private Integer weightInGrams;

    @Column(name = "strength", nullable = false)
    private Integer strength;

    @Column(name = "decaf", nullable = false)
    private boolean decaf;

    @Column(name = "price", nullable = false)
    private Double price;

    @Column(name = "total_orders", nullable = false)
    private Integer orderTotal;

    @Column(name = "total_in_stock", nullable = false)
    private Integer stockTotal;

    public CoffeeProduct() {
    }

    public CoffeeProduct(Long id, String name, CoffeeType coffeeType, Integer weightInGrams, Integer strength, boolean decaf, Double price, Integer orderTotal, Integer stockTotal) {
        this.id = id;
        this.name = name;
        this.coffeeType = coffeeType;
        this.weightInGrams = weightInGrams;
        this.strength = strength;
        this.decaf = decaf;
        this.price = price;
        this.orderTotal = orderTotal;
        this.stockTotal = stockTotal;
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

    public CoffeeType getCoffeeType() {
        return coffeeType;
    }

    public void setCoffeeType(CoffeeType coffeeType) {
        this.coffeeType = coffeeType;
    }

    public Integer getWeightInGrams() {
        return weightInGrams;
    }

    public void setWeightInGrams(Integer weightInGrams) {
        this.weightInGrams = weightInGrams;
    }

    public Integer getStrength() {
        return strength;
    }

    public void setStrength(Integer strength) {
        this.strength = strength;
    }

    public boolean isDecaf() {
        return decaf;
    }

    public void setDecaf(boolean decaf) {
        this.decaf = decaf;
    }

    public Double getPrice() {
        return price;
    }

    public void setPrice(Double price) {
        this.price = price;
    }

    public Integer getOrderTotal() {
        return orderTotal;
    }

    public void setOrderTotal(Integer orderTotal) {
        this.orderTotal = orderTotal;
    }

    public Integer getStockTotal() {
        return stockTotal;
    }

    public void setStockTotal(Integer stockTotal) {
        this.stockTotal = stockTotal;
    }
}
