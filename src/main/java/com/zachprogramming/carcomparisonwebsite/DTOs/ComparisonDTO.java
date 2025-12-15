package com.zachprogramming.carcomparisonwebsite.DTOs;

import java.util.ArrayList;
import java.util.List;

public class ComparisonDTO
{
    private List<String> names;
    private List<DifferenceDTO> differences;
    private String priceSummary;
    private String horsepowerSummary;

    public ComparisonDTO()
    {
        this.names = new ArrayList<>();
        this.differences = new ArrayList<>();
        this.priceSummary = null;
        this.horsepowerSummary = null;
    }

    public List<String> getNames() {
        return names;
    }

    public void setNames(List<String> names) {
        this.names = names;
    }

    public void addName(String name)
    {
        this.names.add(name);
    }

    public List<DifferenceDTO> getDifferences() {
        return differences;
    }

    public void setDifferences(List<DifferenceDTO> differences) {
        this.differences = differences;
    }

    public void addDifference(DifferenceDTO difference)
    {
        this.differences.add(difference);
    }

    public String getPriceSummary() {
        return priceSummary;
    }

    public void setPriceSummary(String priceSummary) {
        this.priceSummary = priceSummary;
    }

    public String getHorsepowerSummary() {
        return horsepowerSummary;
    }

    public void setHorsepowerSummary(String horsepowerSummary) {
        this.horsepowerSummary = horsepowerSummary;
    }
}
