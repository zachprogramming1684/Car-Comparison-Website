package com.zachprogramming.carcomparisonwebsite.DTOs;

import java.util.List;

//TODO: WORK IN PROGRESS
public class DepreciationDTO
{
    // depreciation over 5 years
    private String  id;
    private String modelName;
    private List<Double> yearlyDepreciation;

    public DepreciationDTO()
    {
        this.id = null;
        this.modelName = null;
        this.yearlyDepreciation = null;
    }

    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id;
    }

    public String getModelName() {
        return modelName;
    }

    public void setModelName(String modelName) {
        this.modelName = modelName;
    }

    public List<Double> getYearlyDepreciation() {
        return yearlyDepreciation;
    }

    public void setYearlyDepreciation(List<Double> yearlyDepreciation) {
        this.yearlyDepreciation = yearlyDepreciation;
    }
}
