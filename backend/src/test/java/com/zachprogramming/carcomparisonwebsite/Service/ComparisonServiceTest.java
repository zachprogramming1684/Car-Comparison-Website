package com.zachprogramming.carcomparisonwebsite.Service;

import com.zachprogramming.carcomparisonwebsite.DTO.ComparisonDTO;
import com.zachprogramming.carcomparisonwebsite.Model.Car;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

class ComparisonServiceTest
{
    private final ComparisonService comparisonService = new ComparisonService();

    @Test
    void shouldCompareCarsCorrectly()
    {
        Car car1 = new Car("Toyota", "Corolla", 2022, "White", 20000, 139, 30, "LE");
        car1.setId(1L);
        Car car2 = new Car("Honda", "Civic", 2022, "Black", 22000, 158, 32, "LX");
        car2.setId(2L);

        ComparisonDTO result = comparisonService.compareCars(car1, car2);

        var priceDiff = result.getDifferences().stream()
                .filter(d -> d.getFeature().equals("Price"))
                .findFirst().orElseThrow();
        assertEquals(1L, priceDiff.getWinnerId());

        var hpDiff = result.getDifferences().stream()
                .filter(d -> d.getFeature().equals("Horsepower"))
                .findFirst().orElseThrow();
        assertEquals(2L, hpDiff.getWinnerId());
    }
}