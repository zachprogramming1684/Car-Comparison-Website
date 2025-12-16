package com.zachprogramming.carcomparisonwebsite.DTOs;

public class YearlyDepreciation
{
    private int year;
    private double price;

    public YearlyDepreciation()
    {
        this.year = 0;
        this.price = 0;
    }

    public int getYear() {
        return year;
    }

    public void setYear(int year) {
        this.year = year;
    }

    public double getPrice() {
        return price;
    }

    public void setPrice(double price) {
        this.price = price;
    }
}
