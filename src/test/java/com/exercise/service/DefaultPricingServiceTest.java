package com.exercise.service;

import com.exercise.domain.Client;
import com.exercise.domain.Individual;
import com.exercise.domain.Professional;
import com.exercise.enums.ProductType;

import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertThrows;

public class DefaultPricingServiceTest {

    private final PricingService pricingService = new DefaultPricingService();

    @Test
    void should_return_price_for_individual_client() {
        Client individual = new Individual("1", "Test", "Someone");

        assertEquals(1500, pricingService.getPrice(individual, ProductType.HIGH));
        assertEquals(800, pricingService.getPrice(individual, ProductType.MEDIUM));
        assertEquals(1200, pricingService.getPrice(individual, ProductType.LAPTOP));
    }

    @Test
    void should_return_discounted_price_for_high_revenue_professional() {
        Client professional = new Professional("P002", "Company BIG", "987654321", "FR123456789", 20_000_000);
        
        assertEquals(1000, pricingService.getPrice(professional, ProductType.HIGH));
        assertEquals(550, pricingService.getPrice(professional, ProductType.MEDIUM));
        assertEquals(900, pricingService.getPrice(professional, ProductType.LAPTOP));
    }

    @Test
    void should_return_standard_price_for_low_revenue_professional() {
        Client professional = new Professional("P003", "Company SMALL", "112233445", null, 5_000_000);

        assertEquals(1150, pricingService.getPrice(professional, ProductType.HIGH));
        assertEquals(600, pricingService.getPrice(professional, ProductType.MEDIUM));
        assertEquals(1000, pricingService.getPrice(professional, ProductType.LAPTOP));
    }

    @Test
    void should_throw_exception_for_unsupported_client_type() {
        Client unknownClient = new Client("999") {}; // anonymous subclass of Client

        assertThrows(UnsupportedOperationException.class, () ->
                pricingService.getPrice(unknownClient, ProductType.HIGH)
        );
    }
}
