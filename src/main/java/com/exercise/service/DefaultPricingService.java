package com.exercise.service;

import com.exercise.domain.Client;
import com.exercise.domain.Individual;
import com.exercise.domain.Professional;
import com.exercise.enums.ProductType;

public class DefaultPricingService implements PricingService {
    
    @Override
    public double getPrice(Client client, ProductType productType) {
        if (client instanceof Individual) {
            return switch (productType) {
                case HIGH -> 1500;
                case MEDIUM -> 800;
                case LAPTOP -> 1200;
            };
        }
        
        if (client instanceof Professional professional) {
            double annualRevenue = professional.getAnnualRevenue();

            if (annualRevenue > 10_000_000) {
                return switch (productType) {
                    case HIGH -> 1000;
                    case MEDIUM -> 550;
                    case LAPTOP -> 900;
                };
            } else {
                return switch (productType) {
                    case HIGH -> 1150;
                    case MEDIUM -> 600;
                    case LAPTOP -> 1000;
                };
            }
        }

        throw new UnsupportedOperationException("Unsupported client type");
    }
}
