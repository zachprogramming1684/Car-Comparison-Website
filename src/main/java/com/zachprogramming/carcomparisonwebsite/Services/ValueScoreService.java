package com.zachprogramming.carcomparisonwebsite.Services;

import com.zachprogramming.carcomparisonwebsite.Models.Car;
import com.zachprogramming.carcomparisonwebsite.Models.ValueScoreDTO;

public class ValueScoreService
{
    /* Value score takes in three properties of the car
        1. Model Year
        2. Price
        3. Horsepower
        Total score is 100, each category gets 100/3 points

        year:
            0-2 years old: 25pts
            3-4 years old: 20pts
            5-6 years old: 15pts
            7-8 years old: 10pts
            9-10 years old: 5pts
            11+ years old: 0pts
        price:
            <$20,000: 25pts
            $20,000 - $24,999: 20pts
            $25,000 - $29,999: 15pts
            $30,000 - $34,999: 10pts
            $35,000 - $39,999: 5pts
            >$40,000: 0pts
        horsepower:
            >=300: 25pts
            250 - 299: 20pts
            200 - 249: 15pts
            150 - 199: 10pts
            <=100: 5pts
     */
    public ValueScoreDTO generateValueScore(Car car1)
    {
        ValueScoreDTO valueScoreDTO = new ValueScoreDTO();
        valueScoreDTO.setId(car1.getId());
        valueScoreDTO.setModelName(car1.getFullName());
        double valueScore = 0;
        
        int year = car1.getYear();
        double price = car1.getPrice();
        int horsepower = car1.getHorsepower();



        return null;
    }
}
