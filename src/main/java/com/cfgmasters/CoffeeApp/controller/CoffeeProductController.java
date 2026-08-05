package com.cfgmasters.CoffeeApp.controller;

import io.swagger.v3.oas.annotations.Operation;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import com.cfgmasters.CoffeeApp.model.entity.CoffeeProduct;
import com.cfgmasters.CoffeeApp.services.CoffeeProductService;

import java.util.List;

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
    @Operation(summary = "Delete a coffee product by ID")
    @DeleteMapping("/{id}")
    public ResponseEntity<Void> deleteProduct(@PathVariable Long id) {

        coffeeProductService.deleteProduct(id);
        // Returns HTTP 204 no content when deletion is successful
        return ResponseEntity.noContent().build();
    }

    @Operation(summary = "Update only the price of a coffee product.")
    @PatchMapping("/{id}/price")
    public ResponseEntity<CoffeeProduct> updatePrice(
            @PathVariable Long id,
            @RequestParam Double price) {

        CoffeeProduct updatedProduct =
                coffeeProductService.updatePrice(id, price);

        return ResponseEntity.ok(updatedProduct);
    }

    @Operation(summary = "Search Database by blendType AND strength, return all products of those parameters")
    @GetMapping("/{blendType}/{strength}")
    public ResponseEntity<List<CoffeeProduct>>findByBlendTypeAndStrength(
            @PathVariable String blendType,
            @PathVariable Integer strength) {
        List<CoffeeProduct> products = coffeeProductService.findByBlendTypeAndStrength(blendType, strength);
        return ResponseEntity.ok(products);
    }

    @Operation(summary = "Add a new coffee product.")
    @PostMapping
    public ResponseEntity<CoffeeProduct> addProduct(
            @RequestBody CoffeeProduct coffeeProduct) {

        CoffeeProduct savedProduct = coffeeProductService.addProduct(coffeeProduct);
        return ResponseEntity.status(HttpStatus.CREATED).body(savedProduct);
    }
}
