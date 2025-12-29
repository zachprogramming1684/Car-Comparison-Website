package com.zachprogramming.carcomparisonwebsite.DTO;

import java.util.ArrayList;
import java.util.List;

public class DepreciationDTO
{
    // depreciation over 5 years
    private Long  id;
    private String modelName;
    private List<YearlyDepreciation> yearlyDepreciation;

    public DepreciationDTO()
    {
        this.id = null;
        this.modelName = null;
        this.yearlyDepreciation = new ArrayList<>();
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getModelName() {
        return modelName;
    }

    public void setModelName(String modelName) {
        this.modelName = modelName;
    }

    public List<YearlyDepreciation> getYearlyDepreciation() {
        return yearlyDepreciation;
    }

    public void setYearlyDepreciation(List<YearlyDepreciation> yearlyDepreciation) {
        this.yearlyDepreciation = yearlyDepreciation;
    }

    public void addYearlyDepreciation(YearlyDepreciation yearlyDepreciation)
    {
        this.yearlyDepreciation.add(yearlyDepreciation);
    }
}
