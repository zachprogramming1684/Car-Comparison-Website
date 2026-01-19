package com.zachprogramming.carcomparisonwebsite.Service;

import com.zachprogramming.carcomparisonwebsite.Model.Car;
import com.zachprogramming.carcomparisonwebsite.DTO.ValueScoreDTO;
import org.springframework.stereotype.Service;

import java.time.Year;

@Service
public class ValueScoreService
{
    // max or min values for each category to provide a reasonable ceiling or floor when calculating scores
    private static final double MAX_PRICE_REF = 60000;
    private static final int MAX_AGE_REF = 20;
    private static final int MIN_HORSEPOWER_REF = 60;
    private static final int MAX_MPG_REF = 60;

    private static final double WEIGHT_PRICE = 0.40;
    private static final double WEIGHT_AGE = 0.30;
    private static final double WEIGHT_HORSEPOWER = 0.10;
    private static final double WEIGHT_MPG = 0.20;

    private final AiAnalysisService aiAnalysisService;
    public ValueScoreService(AiAnalysisService aiAnalysisService) {this.aiAnalysisService = aiAnalysisService;}

    public ValueScoreDTO generateValueScore(Car car1)
    {
        ValueScoreDTO valueScoreDTO = new ValueScoreDTO();
        valueScoreDTO.setId(car1.getId());
        valueScoreDTO.setModelName(car1.getFullName());
        double valueScore = 0;

        int year = car1.getYear();
        double price = car1.getPrice();
        int horsepower = car1.getHorsepower();
        int mpg = car1.getFuelEconomy();

        double priceScore = getPriceScore(price);
        double ageScore = getAgeScore(year);
        double horsepowerScore = getHorsepowerScore(horsepower);
        double mpgScore = getMpgScore(mpg);

        // scores are weighted then added together then multiplied by 100 to produce final value score
        valueScore = (priceScore * WEIGHT_PRICE)
                    + (ageScore * WEIGHT_AGE)
                    + (horsepowerScore * WEIGHT_HORSEPOWER)
                    + (mpgScore * WEIGHT_MPG);
        int totalScore = (int) Math.round(valueScore * 100);

        valueScoreDTO.setPrice(price);
        valueScoreDTO.setModelYear(year);
        valueScoreDTO.setHorsepower(horsepower);
        valueScoreDTO.setMpg(mpg);
        valueScoreDTO.setValueScore(totalScore);
        valueScoreDTO.setAiAnalysis(aiAnalysisService.generateAiAnalysis(car1, totalScore));
        return valueScoreDTO;
    }

    // helper methods to generate scores for each category before they are weighted

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

    private double getMpgScore(int mpg) {return clamp((double) mpg / MAX_MPG_REF);}

    // method to make sure scores do not exceed 100 or fall below 0
    private double clamp(double value)
    {
        return Math.max(0.0, Math.min(1.0, value));
    }
}
