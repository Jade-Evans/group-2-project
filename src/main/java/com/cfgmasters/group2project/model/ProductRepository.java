package com.cfgmasters.group2project.model;

import com.cfgmasters.group2project.model.entity.CoffeeProduct;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface ProductRepository extends JpaRepository<CoffeeProduct, Long> {
}

