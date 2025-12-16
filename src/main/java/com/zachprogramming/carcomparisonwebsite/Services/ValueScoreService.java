package com.zachprogramming.carcomparisonwebsite.Services;

import com.zachprogramming.carcomparisonwebsite.Models.Car;
import com.zachprogramming.carcomparisonwebsite.DTOs.ValueScoreDTO;
import org.springframework.stereotype.Service;

import java.time.Year;

@Service
public class ValueScoreService
{

    private static final double MAX_PRICE_REF = 60000;
    private static final int MAX_AGE_REF = 20;
    private static final int MIN_HORSEPOWER_REF = 60;

    private static final double WEIGHT_PRICE = 0.55;
    private static final double WEIGHT_AGE = 0.35;
    private static final double WEIGHT_HORSEPOWER = 0.10;

    public ValueScoreDTO generateValueScore(Car car1)
    {
        ValueScoreDTO valueScoreDTO = new ValueScoreDTO();
        valueScoreDTO.setId(car1.getId());
        valueScoreDTO.setModelName(car1.getFullName());
        double valueScore = 0;

        int year = car1.getYear();
        double price = car1.getPrice();
        int horsepower = car1.getHorsepower();

        double priceScore = getPriceScore(price);
        double ageScore = getAgeScore(year);
        double horsepowerScore = getHorsepowerScore(horsepower);

        valueScore = (priceScore * WEIGHT_PRICE)
                    + (ageScore * WEIGHT_AGE)
                    + (horsepowerScore * WEIGHT_HORSEPOWER);
        int totalScore = (int) Math.round(valueScore * 100);

        valueScoreDTO.setValueScore(totalScore);
        return valueScoreDTO;
    }

    private double getPriceScore(double price)
    {
        return clamp(1 - (price / MAX_PRICE_REF));
    }

    private double getAgeScore(int year)
    {
        int currentYear = Year.now().getValue();
        int vehicleAge = currentYear - year;

        return clamp(1 - ((double) vehicleAge / MAX_AGE_REF));
    }

    private double getHorsepowerScore(int horsepower)
    {
        return clamp(1 - ((double) MIN_HORSEPOWER_REF / horsepower));
    }

    private double clamp(double value)
    {
        return Math.max(0.0, Math.min(1.0, value));
    }
}
