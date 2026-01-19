package com.zachprogramming.carcomparisonwebsite.Service;

import com.zachprogramming.carcomparisonwebsite.DTO.DepreciationDTO;
import com.zachprogramming.carcomparisonwebsite.DTO.YearlyDepreciation;
import com.zachprogramming.carcomparisonwebsite.Model.Car;
import org.springframework.stereotype.Service;

@Service
public class DepreciationService
{
    public DepreciationDTO calculateDepreciation(Car car, int years)
    {
        DepreciationDTO dto = new DepreciationDTO();
        dto.setId(car.getId());
        dto.setModelName(car.getFullName());
        double currPrice = car.getPrice();

        for(int i = 0; i < years; i++)
        {
            // price decreases by 20% in first year
            if(i == 0)
            {
                currPrice -= currPrice * 0.2;
            }
            // then by 11.5% in years 2 and 3
            else if(i == 1 || i == 2)
            {
                currPrice -= currPrice * 0.115;
            }
            // then by 9% every year after
            else
            {
                currPrice -= currPrice * 0.09;
            }
            // new "year" object is created every iteration then added to the DepreciationDTO
            YearlyDepreciation currYear = new YearlyDepreciation();
            currYear.setYear(i + 1);
            currYear.setPrice(Math.round(currPrice));
            dto.addYearlyDepreciation(currYear);
        }
        return dto;
    }
}
