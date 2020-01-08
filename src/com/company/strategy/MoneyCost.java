package com.company.strategy;

import com.company.models.Route;

public class MoneyCost implements CostType {
    @Override
    public double getCost(Route route) {
        return route.getCost();
    }
}
