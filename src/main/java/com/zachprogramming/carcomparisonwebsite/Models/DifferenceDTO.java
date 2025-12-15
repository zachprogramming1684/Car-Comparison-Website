package com.zachprogramming.carcomparisonwebsite.Models;

public class DifferenceDTO
{
    private String feature;
    private double car1Value;
    private double car2Value;
    Long winnerId;

    public DifferenceDTO(String feature, double car1Value, double car2Value, Long winnerId)
    {
        this.feature = feature;
        this.car1Value = car1Value;
        this.car2Value = car2Value;
        this.winnerId = winnerId;
    }

    public String getFeature() {
        return feature;
    }

    public void setFeature(String feature) {
        this.feature = feature;
    }

    public double getCar1Value() {
        return car1Value;
    }

    public void setCar1Value(double car1Value) {
        this.car1Value = car1Value;
    }

    public double getCar2Value() {
        return car2Value;
    }

    public void setCar2Value(double carValue2) {
        this.car2Value = carValue2;
    }

    public Long getWinnerId() {
        return winnerId;
    }

    public void setWinnerId(Long winnerId) {
        this.winnerId = winnerId;
    }
}
