package com.cfgmasters.CoffeeApp.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.cfgmasters.CoffeeApp.model.entity.CoffeeProduct;

@Repository
public interface CoffeeProductRepository extends JpaRepository<CoffeeProduct, Long> {
}

