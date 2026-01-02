package com.zachprogramming.carcomparisonwebsite.DTO;

public class ValueScoreDTO
{
    private Long id;
    private String modelName;
    private double price;
    private int modelYear;
    private int horsepower;
    private int mpg;
    private int valueScore;
    private String aiAnalysis;

    public ValueScoreDTO()
    {
        this.id = null;
        this.modelName = null;
        this.valueScore = 0;
        this.aiAnalysis = null;
        this.price = 0;
        this.modelYear = 0;
        this.horsepower = 0;
        this.mpg = 0;
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

    public int getValueScore() {
        return valueScore;
    }

    public void setValueScore(int valueScore) {
        this.valueScore = valueScore;
    }

    public String getAiAnalysis() {
        return aiAnalysis;
    }

    public void setAiAnalysis(String aiAnalysis) {
        this.aiAnalysis = aiAnalysis;
    }

    public double getPrice() {
        return price;
    }

    public void setPrice(double price) {
        this.price = price;
    }

    public int getModelYear() {
        return modelYear;
    }

    public void setModelYear(int modelYear) {
        this.modelYear = modelYear;
    }

    public int getHorsepower() {
        return horsepower;
    }

    public void setHorsepower(int horsepower) {
        this.horsepower = horsepower;
    }

    public int getMpg() {
        return mpg;
    }

    public void setMpg(int mpg) {
        this.mpg = mpg;
    }
}
