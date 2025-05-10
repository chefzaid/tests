package com.exercise.service;

import java.util.HashMap;
import java.util.Map;

import com.exercise.domain.Client;
import com.exercise.enums.ProductType;

public class CartService {

    private Map<ProductType, Integer> products = new HashMap<>();
    private PricingService pricingService;

    public CartService(PricingService pricingService) {
        this.pricingService = pricingService;
    }

    public void addProduct(ProductType type, int quantity) {
        products.put(type, products.getOrDefault(type, 0) + quantity);
    }

    public double calculateTotal(Client client) {
        return products.entrySet().stream()
                .mapToDouble(entry -> pricingService.getPrice(client, entry.getKey()) * entry.getValue())
                .sum();
    }
}