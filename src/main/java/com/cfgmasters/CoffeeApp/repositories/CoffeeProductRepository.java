package com.cfgmasters.CoffeeApp.repositories;

import com.cfgmasters.CoffeeApp.model.enums.BlendType;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.cfgmasters.CoffeeApp.model.entities.CoffeeProduct;

import java.util.List;

@Repository
public interface CoffeeProductRepository extends JpaRepository<CoffeeProduct, Long> {
     List<CoffeeProduct> findByBlendTypeAndStrength(BlendType blendTypeEnum, Integer strength);
}

