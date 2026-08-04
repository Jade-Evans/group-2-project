package com.cfgmasters.CoffeeApp.services;

import org.springframework.http.HttpStatus;
import org.springframework.stereotype.Service;
import org.springframework.web.server.ResponseStatusException;

import com.cfgmasters.CoffeeApp.model.entity.CoffeeProduct;
import com.cfgmasters.CoffeeApp.repository.CoffeeProductRepository;

@Service
public class CoffeeProductService {

    private final CoffeeProductRepository coffeeProductRepository;

    public CoffeeProductService(CoffeeProductRepository coffeeProductRepository) {
        this.coffeeProductRepository = coffeeProductRepository;
    }

    public CoffeeProduct updateStock(Long id, Integer quantity) {
        CoffeeProduct product = coffeeProductRepository.findById(id)
                .orElseThrow(() -> new ResponseStatusException(HttpStatus.NOT_FOUND, "Couldn't access the coffee product from id:" + id));

        product.setStockTotal(quantity);
        return coffeeProductRepository.save(product);
    }

    public CoffeeProduct adjustStock(Long id, Integer amount) {
        CoffeeProduct product = coffeeProductRepository.findById(id)
                .orElseThrow(() -> new ResponseStatusException(HttpStatus.NOT_FOUND, "Couldn't access the coffee product from id:" + id));

        int currentStock = product.getStockTotal() != null ? product.getStockTotal() : 0;
        int adjustment = amount != null ? amount : 0;
        product.setStockTotal(currentStock + adjustment);
        return coffeeProductRepository.save(product);
    }

    // Updates only the price of a coffee product
    public CoffeeProduct updatePrice(Long id, Double price) {
        CoffeeProduct product = coffeeProductRepository.findById(id)
                .orElseThrow(() -> new ResponseStatusException(
                        HttpStatus.NOT_FOUND,
                        "Couldn't access the coffee product from id:" + id));

        product.setPrice(price);

        return coffeeProductRepository.save(product);
    }

    // Deletes a coffee product from the database based of its ID
    public void deleteProduct(Long id) {
        // Find the coffee product using the ID provided by the delete request.
        //If no product exists with ID, it throws a 404 NOT FOUND error.
        CoffeeProduct product = coffeeProductRepository.findById(id)
                .orElseThrow(() -> new ResponseStatusException(
                        HttpStatus.NOT_FOUND,
                        "Couldn't find coffee product with id: " + id

                ));
        // removes product from the database once found
        coffeeProductRepository.delete(product);
    }
    }
