package com.zachprogramming.carcomparisonwebsite.Repository;

import com.zachprogramming.carcomparisonwebsite.Model.Car;
import org.springframework.data.jpa.domain.Specification;
import org.springframework.util.StringUtils;

public class CarSpecifications
{
    public static Specification<Car> hasMake(String make)
    {
        return (root, query, criteriaBuilder) ->
        {
            if(!StringUtils.hasText(make)) return null;
            return criteriaBuilder.equal(criteriaBuilder.lower(root.get("make")), make.toLowerCase());
        };
    }

    public static Specification<Car> priceLessThan(Double maxPrice)
    {
        return (root, query, criteriaBuilder) ->
        {
            if(maxPrice == null) return null;
            return criteriaBuilder.lessThanOrEqualTo(root.get("price"), maxPrice);
        };
    }

    public static Specification<Car> modelContains(String modelFragment)
    {
        return (root, query, criteriaBuilder) ->
        {
            if(!StringUtils.hasText(modelFragment)) return null;
            return criteriaBuilder.like(criteriaBuilder.lower(root.get("model")), "%" + modelFragment.toLowerCase() + "%");
        };
    }

    public static Specification<Car> isColor(String color)
    {
        return (root, query, criteriaBuilder) ->
        {
            if(!StringUtils.hasText(color)) return null;
            return criteriaBuilder.equal(criteriaBuilder.lower(root.get("color")), color.toLowerCase());
        };
    }

    public static Specification<Car> horsepowerGreaterThan (Integer minHorsepower)
    {
        return (root, query, criteriaBuilder) ->
        {
            if(minHorsepower == 0) return null;
            return criteriaBuilder.greaterThanOrEqualTo(root.get("horsepower"), minHorsepower);
        };
    }

    public static Specification<Car> mpgGreaterThan (Integer minMpg)
    {
        return (root, query, criteriaBuilder) ->
        {
            if(minMpg == 0) return null;
            return criteriaBuilder.greaterThanOrEqualTo(root.get("fuelEconomy"), minMpg);
        };
    }

    public static Specification<Car> betweenYears(Integer minYear, Integer maxYear)
    {
        return (root, query, criteriaBuilder) ->
        {
            if(minYear == null && maxYear == null) return null;
            if(minYear != null && maxYear != null) {return criteriaBuilder.between(root.get("modelYear"), minYear, maxYear);}
            if(minYear != null) {return criteriaBuilder.greaterThanOrEqualTo(root.get("modelYear"), minYear);}
            return criteriaBuilder.lessThanOrEqualTo(root.get("modelYear"), maxYear);
        };
    }
}
