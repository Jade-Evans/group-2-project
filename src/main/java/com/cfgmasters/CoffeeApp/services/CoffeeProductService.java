package com.cfgmasters.CoffeeApp.services;

import com.cfgmasters.CoffeeApp.model.enums.BlendType;
import com.cfgmasters.CoffeeApp.utils.ValidInputChecksUtils;
import lombok.extern.slf4j.Slf4j;
import org.springframework.http.HttpStatus;
import org.springframework.stereotype.Service;
import org.springframework.web.server.ResponseStatusException;

import com.cfgmasters.CoffeeApp.model.entities.CoffeeProduct;
import com.cfgmasters.CoffeeApp.repositories.CoffeeProductRepository;

import java.util.List;
@Slf4j
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

    public List<CoffeeProduct> findByBlendTypeAndStrength(String blendType, Integer strength){
        ValidInputChecksUtils.notNullCheck(strength, "strength");
        ValidInputChecksUtils.validStrengthValueCheck(strength);
        ValidInputChecksUtils.notBlankCheck(blendType, "blendType");
        //use toUpperCase() & trim() methods to normalise input into all CAPs, no spaces
        String normalisedInput = blendType.toUpperCase().trim();
        //declare enum:
        BlendType blendTypeEnum;
        try {
            //convert the data type of validated String input into a CoffeeType:
            blendTypeEnum = BlendType.valueOf(normalisedInput);
        } catch (IllegalArgumentException e) {
            throw new ResponseStatusException(HttpStatus.BAD_REQUEST, "Invalid search", e);
        }

        log.info("Searching for products of blend type: {} and strength: {}", blendTypeEnum, strength);
        List<CoffeeProduct> products = coffeeProductRepository.findByBlendTypeAndStrength(blendTypeEnum, strength);//method sig. is defined in repository

        if (products.isEmpty()) {
            throw new ResponseStatusException(HttpStatus.NOT_FOUND, "Currently there are no products available of type:" + normalisedInput + "with a strength of:" + strength);
        } else {
            log.info("Found {} products of coffee type: {} and strength: {}", products.size(), normalisedInput, strength);
        }
        return products;

    }

    public CoffeeProduct addProduct(CoffeeProduct coffeeProduct) {
        ValidInputChecksUtils.notNullCheck(coffeeProduct, "coffeeProduct");
        ValidInputChecksUtils.notBlankCheck(coffeeProduct.getName(), "name");
        ValidInputChecksUtils.notNullCheck(coffeeProduct.getBlendType(), "blendType");
        ValidInputChecksUtils.notNullCheck(coffeeProduct.getStrength(), "strength");
        ValidInputChecksUtils.validStrengthValueCheck(coffeeProduct.getStrength());
        ValidInputChecksUtils.notNullCheck(coffeeProduct.getPrice(), "price");
        ValidInputChecksUtils.positiveCheck(coffeeProduct.getPrice(), "price");
        ValidInputChecksUtils.notNullCheck(coffeeProduct.getOrderTotal(), "orderTotal");
        ValidInputChecksUtils.nonNegativeCheck(coffeeProduct.getOrderTotal(), "orderTotal");
        ValidInputChecksUtils.notNullCheck(coffeeProduct.getStockTotal(), "stockTotal");
        ValidInputChecksUtils.nonNegativeCheck(coffeeProduct.getStockTotal(), "stockTotal");

        log.info("Adding new coffee product: {}", coffeeProduct);

        CoffeeProduct savedProduct = coffeeProductRepository.save(coffeeProduct);

        log.info("Product saved: {}", savedProduct);
        return savedProduct;
    }

    public List<CoffeeProduct> getAllProducts() {
        log.info("Fetching all coffee products");
        return coffeeProductRepository.findAll();
    }
}



