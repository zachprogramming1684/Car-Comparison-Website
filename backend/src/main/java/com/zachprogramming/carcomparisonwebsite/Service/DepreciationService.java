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
            if(i == 0)
            {
                currPrice -= currPrice * 0.2;
            }
            else if(i == 1 || i == 2)
            {
                currPrice -= currPrice * 0.115;
            }
            else
            {
                currPrice -= currPrice * 0.09;
            }
            YearlyDepreciation currYear = new YearlyDepreciation();
            currYear.setYear(i + 1);
            currYear.setPrice(Math.round(currPrice));
            dto.addYearlyDepreciation(currYear);
        }
        return dto;
    }
}
