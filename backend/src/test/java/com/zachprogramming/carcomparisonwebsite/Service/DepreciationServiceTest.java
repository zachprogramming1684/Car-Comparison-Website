package com.zachprogramming.carcomparisonwebsite.Service;

import com.zachprogramming.carcomparisonwebsite.DTO.DepreciationDTO;
import com.zachprogramming.carcomparisonwebsite.Model.Car;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

class DepreciationServiceTest
{
    private final DepreciationService depreciationService = new DepreciationService();

    @Test
    void shouldCalculateDepreciationCorrectly()
    {
        Car car = new Car();
        car.setId(1L);
        car.setMake("Test");
        car.setModel("Model");
        car.setPrice(10000.0);

        DepreciationDTO result = depreciationService.calculateDepreciation(car, 5); //

        assertEquals(5, result.getYearlyDepreciation().size());

        // Year 1: Lose 20% of 10,000 -> 8000
        assertEquals(8000.0, result.getYearlyDepreciation().get(0).getPrice(), 0.01);

        // Year 2: Lose 11.5% of 8000 -> 7080
        assertEquals(7080.0, result.getYearlyDepreciation().get(1).getPrice(), 0.01);

        assertEquals(6266.0, result.getYearlyDepreciation().get(2).getPrice(), 0.01);
    }
}