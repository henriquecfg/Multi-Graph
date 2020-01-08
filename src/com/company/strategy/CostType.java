package com.company.strategy;

import com.company.models.Route;

public interface CostType {
    double getCost(Route route);
}
