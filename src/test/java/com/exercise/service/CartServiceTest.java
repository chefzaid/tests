package com.exercise.service;

import com.exercise.domain.Client;
import com.exercise.domain.Individual;
import com.exercise.domain.Professional;
import com.exercise.enums.ProductType;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.assertEquals;

public class CartServiceTest {

    private static final PricingService DEFAULT_PRICING_SERVICE = new DefaultPricingService();

    @Test
    void should_return_total_for_individual_client() {
        Client client = new Individual("C002", "Someone", "Test");

        CartService cart = new CartService(DEFAULT_PRICING_SERVICE);
        cart.addProduct(ProductType.HIGH, 1);
        cart.addProduct(ProductType.MEDIUM, 1);
        cart.addProduct(ProductType.LAPTOP, 1);

        double expectedTotal = 1500 + 800 + 1200;
        assertEquals(expectedTotal, cart.calculateTotal(client));
    }

    @Test
    void should_return_total_for_professional_with_high_revenue() {
        Client client = new Professional("P002", "Company BIG", "987654321", "FR123456789", 20_000_000);

        CartService cart = new CartService(DEFAULT_PRICING_SERVICE);
        cart.addProduct(ProductType.HIGH, 2);
        cart.addProduct(ProductType.MEDIUM, 1);

        double expectedTotal = 2 * 1000 + 1 * 550;
        assertEquals(expectedTotal, cart.calculateTotal(client));
    }

    @Test
    void should_return_total_for_professional_with_low_revenue() {
        Client client = new Professional("P003", "Company SMALL", "112233445", null, 5_000_000);

        CartService cart = new CartService(DEFAULT_PRICING_SERVICE);
        cart.addProduct(ProductType.LAPTOP, 2);

        double expectedTotal = 2 * 1000;
        assertEquals(expectedTotal, cart.calculateTotal(client));
    }
}
