package com.zachprogramming.carcomparisonwebsite.Services;

import com.zachprogramming.carcomparisonwebsite.DTOs.DepreciationDTO;
import com.zachprogramming.carcomparisonwebsite.DTOs.YearlyDepreciation;
import com.zachprogramming.carcomparisonwebsite.Models.Car;
import org.springframework.stereotype.Service;

//TODO: WORK IN PROGRESS
@Service
public class DepreciationService
{
    public DepreciationDTO calculateDepreciation(Car car, int years)
    {
        DepreciationDTO dto = new DepreciationDTO();
        dto.setId(car.getId());
        dto.setModelName(car.getFullName());
        double currPrice = car.getPrice();
        // loses 20% in the first year
        // loses 11.5% for years 2-3
        // loses 9% each year after that
        for(int i = 0; i < years; i++)
        {
            if(i == 1)
            {
                currPrice -= currPrice * 0.2;
            }
            else if(i == 2 || i == 3)
            {
                currPrice -= currPrice * 0.115;
            }
            else
            {
                currPrice -= currPrice * 0.09;
            }
            YearlyDepreciation currYear = new YearlyDepreciation();
            currYear.setYear(i + 1);
            currYear.setPrice(currPrice);
            dto.addYearlyDepreciation(currYear);
        }
        return dto;
    }
}
