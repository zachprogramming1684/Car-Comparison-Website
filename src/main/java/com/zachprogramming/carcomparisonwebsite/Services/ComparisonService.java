package com.zachprogramming.carcomparisonwebsite.Services;

import com.zachprogramming.carcomparisonwebsite.Models.Car;
import com.zachprogramming.carcomparisonwebsite.DTOs.ComparisonDTO;
import com.zachprogramming.carcomparisonwebsite.DTOs.DifferenceDTO;
import org.springframework.stereotype.Service;

@Service
public class ComparisonService
{
    public ComparisonDTO compareCars(Car car1, Car car2)
    {
        ComparisonDTO compare = new ComparisonDTO();

        compare.addName(car1.getFullName() + " ID: " + car1.getId());
        compare.addName(car2.getFullName() + " ID: " + car2.getId());

        Long priceWinner = null;
        if(car1.getPrice() < car2.getPrice()) {priceWinner = car1.getId();}
        else if(car2.getPrice() < car1.getPrice()) {priceWinner = car2.getId();}
        compare.addDifference(new DifferenceDTO("Price", car1.getPrice(), car2.getPrice(), priceWinner));

        Long horsepowerWinner = null;
        if(car1.getHorsepower() > car2.getHorsepower()) {horsepowerWinner = car1.getId();}
        else if(car2.getHorsepower() > car1.getHorsepower()) {horsepowerWinner = car2.getId();}
        compare.addDifference(new DifferenceDTO("Horsepower", car1.getHorsepower(), car2.getHorsepower(), horsepowerWinner));

        Long fuelEconomyWinner = null;
        if(car1.getFuelEconomy() > car2.getFuelEconomy()) {fuelEconomyWinner = car1.getId();}
        else if(car2.getFuelEconomy() > car1.getFuelEconomy()) {fuelEconomyWinner = car2.getId();}
        compare.addDifference(new DifferenceDTO("Fuel Economy (mpg)", car1.getFuelEconomy(), car2.getFuelEconomy(), fuelEconomyWinner));

        compare.setPriceSummary(generatePriceSummary(car1, car2, priceWinner));
        compare.setHorsepowerSummary(generateHorsepowerSummary(car1, car2, horsepowerWinner));
        compare.setFuelEconomySummary(generateFuelEconomySummary(car1, car2, fuelEconomyWinner));

        return compare;
    }

    public String generatePriceSummary(Car car1, Car car2, Long paramId)
    {
        if(car1.getId().equals(paramId))
        {
            double diff = car2.getPrice() - car1.getPrice();
            return "There is a $" + diff + " savings in going with the " + car1.getFullName() + " over the " + car2.getFullName() + ".";
        }
        else if(car2.getId().equals(paramId))
        {
            double diff = car1.getPrice() - car2.getPrice();
            return "There is a $" + diff + " savings in going with the " + car2.getFullName() + " over the " + car1.getFullName() + ".";
        }
        return "These cars have equal prices.";
    }

    public String generateHorsepowerSummary(Car car1, Car car2, Long paramId)
    {
        if(car1.getId().equals(paramId))
        {
            int diff = car1.getHorsepower() - car2.getHorsepower();
            return "The " + car1.getFullName() + " is more powerful than the " + car2.getFullName() + " by " + diff + " horsepower.";
        }
        else if(car2.getId().equals(paramId))
        {
            int diff = car2.getHorsepower() - car1.getHorsepower();
            return "The " + car2.getFullName() + " is more powerful than the " + car1.getFullName() + " by " + diff + " horsepower.";
        }
        return "These cars have equal horsepower.";
    }

    public String generateFuelEconomySummary(Car car1, Car car2, Long paramId)
    {
        if(car1.getId().equals(paramId))
        {
            int diff = car1.getFuelEconomy() - car2.getFuelEconomy();
            return "The " + car1.getFullName() + " is better on gas than the  " + car2.getFullName() + " by " + diff + " miles per gallon.";
        }
        else if(car2.getId().equals(paramId))
        {
            int diff = car2.getFuelEconomy() - car1.getFuelEconomy();
            return "The " + car2.getFullName() + " is better on gas than the  " + car1.getFullName() + " by " + diff + " miles per gallon.";
        }
        return "These cars have equal fuel economy.";
    }
}
