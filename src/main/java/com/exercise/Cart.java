package com.exercise;

import com.exercise.domain.Client;
import com.exercise.domain.Individual;
import com.exercise.domain.Professional;
import com.exercise.enums.ProductType;
import com.exercise.service.CartService;
import com.exercise.service.DefaultPricingService;
import com.exercise.service.PricingService;

public class Cart {
    public static void main(String[] args) {
        Client client1 = new Individual("C001", "Test", "Jean");
        Client client2 = new Professional("P001", "Company Test", "123456789", null, 8_000_000);
        Client client3 = new Professional("P002", "Company ABC", "987654321", null, 12_000_000);

        PricingService pricingService = new DefaultPricingService();
        CartService cart1 = new CartService(pricingService);
        cart1.addProduct(ProductType.HIGH, 1);
        cart1.addProduct(ProductType.MEDIUM, 2);
        cart1.addProduct(ProductType.LAPTOP, 3);

        System.out.println("Total C001: " + cart1.calculateTotal(client1) + " euros");
        System.out.println("Total P001: " + cart1.calculateTotal(client2) + " euros");
        System.out.println("Total P002: " + cart1.calculateTotal(client3) + " euros");

        // PS: Just an example, cf. Test classes for whole cases coverage
    }
}