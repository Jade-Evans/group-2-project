package com.cfgmasters.CoffeeApp.controller;

import io.swagger.v3.oas.annotations.Operation;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import com.cfgmasters.CoffeeApp.model.entity.CoffeeProduct;
import com.cfgmasters.CoffeeApp.services.CoffeeProductService;

@RestController
@RequestMapping("/products")
public class CoffeeProductController {

    private final CoffeeProductService coffeeProductService;

    public CoffeeProductController(CoffeeProductService coffeeProductService) {
        this.coffeeProductService = coffeeProductService;
    }

    @Operation(summary = "Update coffee stock to a specific amount.")
    @PutMapping("/stock/{id}")
    public ResponseEntity<CoffeeProduct> updateStock(
            @PathVariable Long id,
            @RequestParam Integer quantity) {
        CoffeeProduct updatedProduct = coffeeProductService.updateStock(id, quantity);
        return ResponseEntity.ok(updatedProduct);
    }

    @Operation(summary = "Adjusts coffee stock by an amount, can be negative or positive.")
    @PutMapping("/adjustStock/{id}")
    public ResponseEntity<CoffeeProduct> adjustStock(
            @PathVariable Long id,
            @RequestParam Integer amount) {
        CoffeeProduct updatedProduct = coffeeProductService.adjustStock(id, amount);
        return ResponseEntity.ok(updatedProduct);
    }

}
