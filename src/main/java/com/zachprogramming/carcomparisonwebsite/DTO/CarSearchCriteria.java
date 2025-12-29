package com.zachprogramming.carcomparisonwebsite.DTO;

public class CarSearchCriteria
{
    private String make;
    private String model;
    private Double maxPrice;
    private String color;
    private Integer minHorsepower;
    private Integer minMpg;
    private Integer minYear;
    private Integer maxYear;

    public String getMake() {
        return make;
    }

    public void setMake(String make) {
        this.make = make;
    }

    public String getModel() {
        return model;
    }

    public void setModel(String model) {
        this.model = model;
    }

    public Double getMaxPrice() {
        return maxPrice;
    }

    public void setMaxPrice(Double maxPrice) {
        this.maxPrice = maxPrice;
    }

    public String getColor() {
        return color;
    }

    public void setColor(String color) {
        this.color = color;
    }

    public Integer getMinHorsepower() {
        return minHorsepower;
    }

    public void setMinHorsepower(Integer minHorsepower) {
        this.minHorsepower = minHorsepower;
    }

    public Integer getMinMpg() {
        return minMpg;
    }

    public void setMinMpg(Integer minMpg) {
        this.minMpg = minMpg;
    }

    public Integer getMinYear() {
        return minYear;
    }

    public void setMinYear(Integer minYear) {
        this.minYear = minYear;
    }

    public Integer getMaxYear() {
        return maxYear;
    }

    public void setMaxYear(Integer maxYear) {
        this.maxYear = maxYear;
    }
}
