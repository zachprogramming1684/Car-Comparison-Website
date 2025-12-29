package com.zachprogramming.carcomparisonwebsite.DTO;

public class ValueScoreDTO
{
    private Long id;
    private String modelName;
    private int valueScore;
    private String aiAnalysis;

    public ValueScoreDTO()
    {
        this.id = null;
        this.modelName = null;
        this.valueScore = 0;
        this.aiAnalysis = null;
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
}
