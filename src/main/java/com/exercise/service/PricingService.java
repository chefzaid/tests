package com.exercise.service;

import com.exercise.domain.Client;
import com.exercise.enums.ProductType;

public interface PricingService {
    double getPrice(Client client, ProductType productType);
}