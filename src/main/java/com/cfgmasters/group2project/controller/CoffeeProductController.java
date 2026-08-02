package com.cfgmasters.group2project.controller;
import com.cfgmasters.group2project.model.ProductRepository;
import com.cfgmasters.group2project.model.entity.CoffeeProduct;
import lombok.extern.slf4j.Slf4j;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController //tells Spring class contains methods that respond to HTTP requests
@RequestMapping("/products") //requests specific to artworks table (will add prefix "artworks/" before the endpoint)
@Slf4j
public class CoffeeProductController {
    //field declaration:
    private final ProductRepository productRepository;
    //constructor:
    public CoffeeProductController(ProductRepository productRepository) {
        this.productRepository = productRepository;
    }

    //GET method 1: calls a fresh SELECT*FROM products each time
// & returns a full list of products from whatever rows exist at this point in time
    @GetMapping
    public List<CoffeeProduct> getAllProducts() {
        log.info("Retrieving all products from DB");
        List<CoffeeProduct> products = productRepository.findAll();//finds objects and store in artworks variable
        log.info("Products found: {}", products);
        return products;
    }
}

